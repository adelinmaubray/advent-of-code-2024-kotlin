package part2

import common.Direction
import common.PathState
import common.Point
import java.util.*

fun findPathAllWithLowerScore(mazeWalls: List<Point>, start: Point, end: Point, size: Int): List<PathState> {
	
	// A priority queue by score
	val queue = PriorityQueue<PathState>(compareBy { it.score })
	
	// Possible directions
	val directions = Direction.entries
	
	// List of optimal paths
	val optimalPaths = mutableListOf<PathState>()
	
	// Best score ever
	var bestOverallScore = Long.MAX_VALUE
	
	// Initial state
	queue.add(PathState(start))
	
	while (queue.isNotEmpty()) {
		
		println(queue.size)
		val current = queue.poll()
		
		// If the current score is bigger than the best score found, break the loop because we have a Priority Queue
		if (current.score > bestOverallScore) break
		
		if (current.point == end) {
			
			// New best score found
			if (current.score < bestOverallScore) {
				// Reset list and save the score
				bestOverallScore = current.score
				optimalPaths.clear()
			}
			
			optimalPaths.add(current)
			
			// Go to next path state
			continue
		}
		
		directions.forEach directionForEach@{ newDirection ->
			
			val nextX = current.point.x + newDirection.point.x
			val nextY = current.point.y + newDirection.point.y
			val nextPoint = Point(nextX, nextY)
			
			if (isVisitable(nextX, nextY, size) && !mazeWalls.contains(nextPoint)) {
				
				// Compute extra cost
				val turnCost = if (current.direction != newDirection) 1000 else 0
				val newScore = current.score + 1 + turnCost
				
				// Do not explore this direction of the score is highest
				if (newScore <= bestOverallScore) {
					
					val newState = PathState(
						point = nextPoint,
						score = newScore,
						visitedCells = current.visitedCells + nextPoint,
						direction = newDirection
					)
					
					// Check there is no cycle in the path!
					if (!newState.hasCycle()) {
						queue.add(newState)
					}
				}
			}
		}
	}
	
	if (optimalPaths.isEmpty()) throw Exception("No path found!")
	return optimalPaths
}

// check if the position is physically valid
private fun isVisitable(x: Int, y: Int, size: Int): Boolean {
	return x in 0 until size && y in 0 until size
}
