package part1

import common.extractInput

fun main() {
	
	// Extract matrix
//	val input = extractInput("example.txt")
	val input = extractInput("puzzle_input.txt")
	
	// Count number of XMAS
	val count = countOccurrence(input)
	
	println(count)
}


