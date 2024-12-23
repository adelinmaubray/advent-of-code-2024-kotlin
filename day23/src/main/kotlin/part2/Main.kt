package part2

import common.getConnections

fun main() {
//	val connections = getConnections("example.txt")
	val connections = getConnections("puzzle_input.txt")
	
	val groups = getAllCompanions(connections)
	
	val lans = getLans(groups)
	val lansGroupedBySize = lans.groupBy { it.size }
	val longestLansSize = lansGroupedBySize.keys.max()
	println("The longest LAN has size $longestLansSize")
	
	val longestLan = lansGroupedBySize[longestLansSize]!![0]
	println(longestLan.sortedBy { it }.joinToString(","))
}
