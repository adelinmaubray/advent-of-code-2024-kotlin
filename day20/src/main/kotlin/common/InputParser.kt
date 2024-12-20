package common

import java.io.File

fun getMaze(path: String): Maze {
	return File("src/main/resources/$path").readLines().map { row -> row.toList() }
}

fun computeMaze(maze: Maze): Pair<List<Point>, Pair<Point, Point>> {
	
	// Find start and end
	var start = Point(0, 0)
	var end = Point(0, 0)
	
	// Remove start and end from maze
	val listOfWalls = mutableListOf<Point>()
	
	maze.forEachIndexed { rowIndex, row ->
		row.forEachIndexed { colIndex, char ->
			when (char) {
				'S' -> {
					start = Point(colIndex, rowIndex)
				}
				
				'E' -> {
					end = Point(colIndex, rowIndex)
				}
				
				'#' -> listOfWalls.add(Point(colIndex, rowIndex))
			}
		}
	}
	
	return listOfWalls to (start to end)
}
