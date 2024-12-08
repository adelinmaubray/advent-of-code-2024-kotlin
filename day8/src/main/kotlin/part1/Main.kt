package part1

import common.foundFrequencies
import common.getAntiNodesForFrequency
import common.parseInput

fun main() {
	
	// Parse the area map
//	val areaMap = parseInput("input_example.txt")
	val areaMap = parseInput("puzzle_input.txt")
	
	// Get all frequencies
	val frequencies = foundFrequencies(areaMap)
	
	// For each frequency, compute the antiNodes
	val antiNodes = mutableSetOf<Pair<Int, Int>>()
	frequencies.forEach { frequency ->
		antiNodes.addAll(getAntiNodesForFrequency(frequency, areaMap))
	}
	
	println(antiNodes.size)
}

