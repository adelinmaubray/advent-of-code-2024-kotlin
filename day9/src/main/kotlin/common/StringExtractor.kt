package common

import java.io.File

fun getDiskMap(path: String): List<Int> {
	return File("src/main/resources/$path").readLines().map { line -> line.map { it.digitToInt() } }.flatten()
}
