package part1

import common.*

fun getAntiNodesForFrequency(frequency: Char, areaMap: List<List<Char>>): List<Pair<Int, Int>> {
	
	// Get all identical frequency
	val antennasLocations = getAntennaLocation(frequency, areaMap)
	
	// Compute the antiNode
	val computedAntiNodes = computeAntiNode(antennasLocations)
	
	// Check in the map
	return checkAntiNode(computedAntiNodes, areaMap)
}

private fun computeAntiNode(antennas: List<Pair<Int, Int>>): Set<Pair<Int, Int>> {
	
	val antiNode = mutableSetOf<Pair<Int, Int>>()
	antennas.forEachIndexed { firstIndex, _ ->
		for (secondIndex in firstIndex + 1..antennas.lastIndex) {
			val difference = computeDifference(antennas[firstIndex], antennas[secondIndex])
			antiNode.add(northerAntiNode(antennas[firstIndex], difference))
			antiNode.add(southernAntiNode(antennas[secondIndex], difference))
		}
	}
	return antiNode
}

private fun checkAntiNode(antiNodeToChecks: Set<Pair<Int, Int>>, areaMap: List<List<Char>>): List<Pair<Int, Int>> {
	val rowMaxSize = areaMap.lastIndex
	val colMaxSize = areaMap[0].lastIndex
	return antiNodeToChecks.filter { antiNode -> isInBound(antiNode, rowMaxSize, colMaxSize) }
}
