package common

import java.util.*

fun findPathWithLowerScore(mazeWalls: List<Point>, start: Point, end: Point, size: Int): PathState {
	
	// A priority queue by score
	val queue = PriorityQueue<PathState>(compareBy { it.score })
	
	// Map of best score for each point
	val bestScores = mutableMapOf<Pair<Point, Direction>, Long>()
	
	// Possible directions
	val directions = Direction.entries
	
	// Initial state
	queue.add(PathState(start))
	
	while (queue.isNotEmpty()) {
		
		val current = queue.poll()
		
		// If the end is reached, it is the best solution (due to Priority Queue)
		if (current.point == end) {
			return current
		}
		
		directions.forEach { newDirection ->
			
			val nextX = current.point.x + newDirection.point.x
			val nextY = current.point.y + newDirection.point.y
			val nextPoint = Point(nextX, nextY)
			
			if (isVisitable(nextX, nextY, size) && !mazeWalls.contains(nextPoint)) {
				
				// Compute extra cost
				val turnCost = if (current.direction != newDirection) 1000 else 0
				val newScore = current.score + 1 + turnCost
				
				val stateKey = Pair(nextPoint, newDirection)
				val existingScore = bestScores[stateKey]
				
				// Carry on only if it is the best score for this position and direction
				if (existingScore == null || newScore < existingScore) {
					
					bestScores[stateKey] = newScore
					queue.add(PathState(nextPoint, newScore, current.cells + nextPoint, newDirection))
				}
			}
		}
	}
	
	throw Exception("No path found!")
}

// check if the position is physically valid
private fun isVisitable(x: Int, y: Int, size: Int): Boolean {
	return x in 0 until size && y in 0 until size
}

// Rebuild the path
private fun getPathScore(path: List<Point>): Long {
	
	var currentDirection = Direction.RIGHT
	
	return path.foldIndexed(0L) { index, pathScore, point ->
		
		if (index == path.lastIndex) return@foldIndexed pathScore
		
		val newDirection = point.directionTo(path[index + 1])
		return@foldIndexed if (currentDirection != newDirection) {
			currentDirection = newDirection
			pathScore + 1 + 1000
		} else {
			pathScore + 1
		}
	}
}
