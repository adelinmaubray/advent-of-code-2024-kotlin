package common

import java.io.File

/*
fun getGarden(path: String): List<PlantInformation> {
	return File("src/main/resources/$path")
		.readLines()
		.flatMapIndexed { rowIndex, row ->
			row.mapIndexed { colIndex, plant ->
				PlantInformation(plant, Coordinate(x = colIndex, y = rowIndex))
			}
		}
}
 */

fun getGardenFromTable(path: String): List<List<Char>> {
	val lines = File("src/main/resources/$path").readLines()
	val garden = List(lines.size) {
		MutableList<Char>(lines.size) { '.' }
	}
	lines.forEachIndexed { rowIndex, row ->
		row.forEachIndexed { colIndex, ch ->
			garden[colIndex][rowIndex] = ch
		}
	}
	return garden
}
