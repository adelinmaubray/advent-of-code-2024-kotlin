package part1

import common.parseInput

fun main() {
	
	// Parse inputs
//	val lists = parseInput("example.txt")
	val lists = parseInput("puzzle_input.txt")
	
	// Sort the list in order to properly compare them
	val sortedList = orderLists(lists)
	
	// Compute the distance
	val distance = computeDistance(sortedList)
	
	print(distance)
}
