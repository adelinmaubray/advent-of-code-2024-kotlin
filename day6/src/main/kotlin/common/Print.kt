package common

// Utils fonction to check if the maze is properly parsed
fun printMaze(maze: List<List<Char>>) {
	maze.forEach { row ->
		row.forEach(::print)
		println()
	}
}
