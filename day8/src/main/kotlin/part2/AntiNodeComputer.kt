package part2

import common.*

fun getAntiNodesForFrequency(frequency: Char, areaMap: List<List<Char>>): List<Pair<Int, Int>> {
	
	// Get all identical frequency
	val antennasLocations = getAntennaLocation(frequency, areaMap)
	
	// Compute the antiNode
	return computeAntiNode(antennasLocations, areaMap)
}


private fun computeAntiNode(antennas: List<Pair<Int, Int>>, areaMap: List<List<Char>>): List<Pair<Int, Int>> {
	
	val areaRowMaxSize = areaMap.lastIndex
	val areaColMaxSize = areaMap[0].lastIndex
	
	val antiNodes = mutableSetOf<Pair<Int, Int>>()
	antennas.forEachIndexed { firstIndex, _ ->
		for (secondIndex in firstIndex + 1..antennas.lastIndex) {
			val firstAntenna = antennas[firstIndex]
			val secondAntenna = antennas[secondIndex]
			
			val difference = computeDifference(firstAntenna, secondAntenna)
			
			// go north
			var northLocation = firstAntenna
			do {
				antiNodes.add(northLocation)
				northLocation = northerAntiNode(northLocation, difference)
			} while (isInBound(northLocation, areaRowMaxSize, areaColMaxSize))
			
			// go south
			var southLocation = secondAntenna
			do {
				antiNodes.add(southLocation)
				southLocation = southernAntiNode(southLocation, difference)
			} while (isInBound(southLocation, areaRowMaxSize, areaColMaxSize))
		}
	}
	return antiNodes.toList()
}
