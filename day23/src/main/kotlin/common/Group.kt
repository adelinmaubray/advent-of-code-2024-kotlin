package common

fun getGroupes(connections: Connections): Connections {
	
	val groups = mutableSetOf<Connection>()
	connections.forEachIndexed { index, connection ->
		
		val firstComputer = connection.first()
		val otherComputer = connection.last()
		
		// Find all companions
		val allCompanions = getCompanions(firstComputer, connections, index)
		
		// For each
		allCompanions.forEach { companion ->
			val thirdComputers = getCompanions(companion, connections)
			thirdComputers.forEach { thirdComputer ->
				if (thirdComputer == otherComputer) {
					groups.add(setOf(firstComputer, companion, thirdComputer))
				}
			}
		}
	}
	
	return groups
}

fun getGroupWithT(connections: Connections): Int {
	return connections.count { connection ->
		connection.any { it.startsWith("t") }
	}
}

private fun getCompanions(computer: String, connections: Connections, currentIndex: Int? = null): List<String> {
	
	val connectionWithoutCurrent = connections.toMutableList()
	currentIndex?.let { connectionWithoutCurrent.removeAt(it) }
	
	return connectionWithoutCurrent
		.filter { it.contains(computer) }
		.flatMap { it }
		.filterNot { it == computer }
}


