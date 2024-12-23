package common

import java.io.File

typealias Connection = Set<String>
typealias Connections = Set<Connection>

fun getConnections(path: String): Connections {
	return File("src/main/resources/$path").readLines().map { setOf(it.split("-")[0], it.split("-")[1]) }.toSet()
}
