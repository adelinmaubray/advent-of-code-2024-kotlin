package common

import java.io.File

fun parseInput(path: String): List<Pair<Char, Coordinate>> {
	return File("src/main/resources/$path")
		.readLines()
		.flatMapIndexed { rowIndex, row ->
			row.mapIndexed { colIndex, plant -> plant to Coordinate(rowIndex, colIndex) }
		}
}
