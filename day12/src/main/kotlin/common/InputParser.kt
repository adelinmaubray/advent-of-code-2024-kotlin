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
	return return File("src/main/resources/$path").readLines().map { it.toList() }
}
