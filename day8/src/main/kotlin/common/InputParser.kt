package common

import java.io.File

fun parseInput(path: String): MutableList<MutableList<Char>> {
	return File("src/main/resources/$path").readLines().map { it.toMutableList() }.toMutableList()
}
