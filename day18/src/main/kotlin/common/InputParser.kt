package common

import java.io.File

fun parseInput(path: String): List<Point> {
	return File("src/main/resources/$path").readLines().map { line -> Point(line.split(",")[0].toInt(), line.split(",")[1].toInt()) }
}
