package common

import java.io.File

fun extractInput(path: String): List<List<Char>> {
	return File("src/main/resources/$path").readLines().map { line -> line.toList() }
}
