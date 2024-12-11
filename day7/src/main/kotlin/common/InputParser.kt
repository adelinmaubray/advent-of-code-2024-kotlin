package common

import java.io.File

fun parseInput(path: String): List<Equation> {
	return File("src/main/resources/$path").readLines().map { line ->
		Equation(line.split(": ")[0].toLong(), line.split(": ")[1].split(" ").map { it.toLong() })
	}
}
