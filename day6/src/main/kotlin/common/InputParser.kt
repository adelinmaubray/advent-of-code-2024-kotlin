package common

import java.io.File

fun parseMaze(input: String): MutableList<MutableList<Char>> {
	return File("src/main/resources/$input").readLines().map { line -> line.toMutableList() }.toMutableList()
}

fun getCurrentPosition(maze: List<List<Char>>): Pair<Int, Int> {
	maze.forEachIndexed { rowIndex, row ->
		row.forEachIndexed { colIndex, chars ->
			if (!listOf('.', '#').contains(maze[rowIndex][colIndex])) return Pair(rowIndex, colIndex)
		}
	}
	throw Exception("Current position not found")
}

fun maskCurrentPosition(maze: MutableList<MutableList<Char>>, situation: Situation): List<List<Char>> {
	maze[situation.position.first][situation.position.second] = '.'
	return maze.toList()
}
