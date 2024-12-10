package common

import java.io.File

fun parseInput(path: String): List<List<Int>> {
	return File("src/main/resources/$path").readLines().map { row -> row.toList().map { it.digitToInt() } }
}
