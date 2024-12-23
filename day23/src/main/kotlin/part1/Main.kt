package part1

import common.getConnections

fun main() {

//	val connections = getConnections("example.txt")
	val connections = getConnections("puzzle_input.txt")
	
	val groups = getGroupes(connections)
	val numberOfT = getGroupWithT(groups)
	
	println(numberOfT)
}
