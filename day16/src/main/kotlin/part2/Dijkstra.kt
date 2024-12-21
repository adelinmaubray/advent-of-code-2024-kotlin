package part2

import common.Direction
import common.Point
import java.util.*

fun findPathAllWithLowerScoreWithDijkstra(mazeWalls: List<Point>, start: Point, end: Point, size: Int): List<Node> {
	
	// A priority queue by score
	val queue = PriorityQueue<Node>(compareBy { it.score })
	
	
	val distances = mutableMapOf<State, Long>()
	
	// List of optimal paths
	val optimalPaths = mutableListOf<Node>()
	
	// Best score ever
	var bestOverallScore = Long.MAX_VALUE
	
	// Initial state
	val initialState = State(start, Direction.RIGHT)
	distances[initialState] = 0
	queue.add(Node(state = initialState, path = listOf(start)))
	
	while (queue.isNotEmpty()) {
		
		// If the current score is bigger than the best score found, break the loop because we have a Priority Queue
		val current = queue.poll()
		
		if (current.score > bestOverallScore) break
		
		if (current.state.point == end) {
			
			// New best score found
			if (current.score < bestOverallScore) {
				// Reset list and save the score
				bestOverallScore = current.score
				optimalPaths.clear()
			}
			
			optimalPaths.add(current)
			
			// Go to next node
			continue
		}
		
		// Explorer les directions possibles
		Direction.entries.forEach { newDirection ->
			val nextX = current.state.point.x + newDirection.point.x
			val nextY = current.state.point.y + newDirection.point.y
			val nextPoint = Point(nextX, nextY)
			
			if (isVisitable(nextX, nextY, size) && !mazeWalls.contains(nextPoint)) {
				
				// Compute extra cost
				val turnCost = if (current.state.direction != newDirection) 1000L else 0L
				val newScore = current.score + 1L + turnCost
				val nextState = State(nextPoint, newDirection)
				
				// We consider the new state if its score is equal or lower
				if (newScore <= distances.getOrDefault(nextState, Long.MAX_VALUE)) {
					distances[nextState] = newScore
					queue.add(
						Node(
							state = nextState,
							score = newScore,
							path = current.path + nextPoint
						)
					)
				}
			}
		}
	}
	
	if (optimalPaths.isEmpty()) throw Exception("Aucun chemin trouvé!")
	return optimalPaths
}

// check if the position is physically valid
private fun isVisitable(x: Int, y: Int, size: Int): Boolean {
	return x in 0 until size && y in 0 until size
}
