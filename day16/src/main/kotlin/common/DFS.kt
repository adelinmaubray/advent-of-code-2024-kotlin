package common

fun findAllPath(mazeWalls: List<Point>, start: Point, end: Point, size: Int): List<Path> {
	
	// All paths found
	val allPaths = mutableListOf<Path>()
	
	// Possible directions
	val directions = Direction.entries
	
	// Visited points for the current path
	val currentPath = mutableListOf<Point>()
	val visited = mutableSetOf<Point>()
	
	// Recursive function
	fun explore(current: Point) {
		
		// Add current point to visited points
		currentPath.add(current)
		visited.add(current)
		
		// Si on atteint la fin, on a trouvé un chemin valide
		if (current == end) {
			
			val scoredPath = getPathScore(currentPath)
			allPaths.add(scoredPath)
		} else {
			
			// Get all directions
			directions.forEach { direction ->
				
				val nextX = current.x + direction.point.x
				val nextY = current.y + direction.point.y
				val nextCell = Point(nextX, nextY)
				
				if (isVisitable(nextX, nextY, size) &&
					!mazeWalls.contains(nextCell) &&
					!visited.contains(nextCell)
				) {
					
					explore(nextCell)
				}
			}
		}
		
		// Backtracking
		currentPath.removeAt(currentPath.lastIndex)
		visited.remove(current)
	}
	
	explore(start)
	return allPaths
}

// check if the position is physically valid
private fun isVisitable(x: Int, y: Int, size: Int): Boolean {
	return x in 0 until size && y in 0 until size
}

// Rebuild the path
private fun getPathScore(path: List<Point>): Path {
	
	var currentDirection = Direction.RIGHT
	
	val score = path.foldIndexed(0L) { index, pathScore, point ->
		
		if (index == path.lastIndex) return@foldIndexed pathScore
		
		val newDirection = point.directionTo(path[index + 1])
		return@foldIndexed if (currentDirection != newDirection) {
			currentDirection = newDirection
			pathScore + 1 + 1000
		} else {
			pathScore + 1
		}
	}
	
	return Path(score, listOf(*path.toTypedArray()))

}
