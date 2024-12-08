package part1

import common.countOccurrence
import common.extractInput

fun main() {
	
	// Extract matrix
//	val input = extractInput("example.txt")
	val input = extractInput("input.txt")
	
	// Count number of XMAS
	val count = countOccurrence(input)
	
	println(count)
}


