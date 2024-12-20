package common

fun findShortestPathLength(maze: List<Point>, start: Point, end: Point, size: Int): List<Point> {
	
	// Possible directions
	val directions = listOf(
		Point(-1, 0),
		Point(0, 1),
		Point(1, 0),
		Point(0, -1)
	)
	
	// Visited points
	val visited = mutableSetOf<Point>()
	
	// To rebuild the path
	val parent = mutableMapOf<Point, Point>()
	
	// Queue for BFS algorithm
	val queue = ArrayDeque<Point>()
	queue.add(start)
	visited.add(start)
	
	while (queue.isNotEmpty()) {
		
		val current = queue.removeFirst()
		
		// Exit is reached
		if (current == end) return getCompletePath(parent, start, end)
		
		// Explore next cells
		directions.forEach allDirections@{ direction ->
			
			val nextX = current.x + direction.x
			val nextY = current.y + direction.y
			val nextCell = Point(nextX, nextY)
			
			// Check the cell is valid (in the bound if
			if (!isVisitable(nextX, nextY, size)) {
				return@allDirections
			}
			
			// Check it is not a wall
			if (maze.contains(nextCell)) {
				return@allDirections
			}
			
			// Check it has not been visited before
			if (visited.contains(nextCell)) {
				return@allDirections
			}
			
			queue.add(nextCell)
			visited.add(nextCell)
			parent[nextCell] = current
		}
	}
	throw Exception("Not path found!")
}

// check if the position is physically valid
private fun isVisitable(x: Int, y: Int, size: Int): Boolean {
	return x in 0 until size && y in 0 until size
}

// Rebuild the path
private fun getCompletePath(parent: Map<Point, Point>, start: Point, end: Point): List<Point> {
	
	val path = mutableListOf<Point>()
	var current = end
	
	while (parent.containsKey(current)) {
		path.add(0, current)
		current = parent[current]!!
	}
	
	path.add(0, start)
	return path
}
