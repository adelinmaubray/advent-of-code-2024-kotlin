package common

import java.io.File

fun readInput(): String {
	return File("src/main/resources/puzzle-input.txt").readLines().reduce { acc, line -> acc + line }
}
