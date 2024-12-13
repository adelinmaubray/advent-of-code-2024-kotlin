package common

import java.io.File

fun parseInput(path: String): List<Report> {
	return File("src/main/resources/$path").readLines().map { line ->
		Report.create(line.split(" "))
	}
}
