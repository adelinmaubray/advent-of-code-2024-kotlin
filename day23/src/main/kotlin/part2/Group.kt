package part2

import common.Connection
import common.Connections

fun getAllCompanions(connections: Connections): Map<String, Connection> {
	
	val companions = mutableMapOf<String, Connection>()
	
	connections.forEach { connection ->
		
		val computer1 = connection.first()
		val computer2 = connection.last()
		
		if (!companions.containsKey(computer1)) {
			val computerCompanions = getCompanions(computer1, connections)
			companions.put(computer1, computerCompanions)
		}
		
		if (!companions.containsKey(computer2)) {
			val computerCompanions = getCompanions(computer2, connections)
			companions.put(computer2, computerCompanions)
		}
	}
	
	return companions
}

private fun getCompanions(computer: String, connections: Connections): Connection =
	connections
		.filter { it.contains(computer) }
		.flatMap { it }
		.filterNot { it == computer }
		.toSet()

fun getLans(groups: Map<String, Connection>): Connections {
	val lans = mutableSetOf<Connection>()
	
	groups.forEach { (computer, group) ->
		
		// Take each computer
		// Create a new LAN and add the computer to it
		val lan = mutableSetOf(computer)
		
		// For each companion in the group of the computer
		group.forEach { companion ->
			// Check that it is in all groups of the current LAN
			if (lan.all { groups[it]?.contains(companion) == true }) lan.add(companion)
		}
		lans.add(lan)
	}
	
	return lans
}




