package common

import java.io.File

fun getInitialStones(path: String): List<Long> {
	return File("src/main/resources/$path").readLines()[0].split(" ").map { it.toLong() }
}
