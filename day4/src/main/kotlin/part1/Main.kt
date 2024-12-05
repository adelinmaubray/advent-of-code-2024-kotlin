package part1

import common.countOccurrence
import common.extractInput

fun main() {
	
	// Extract matrix
	val input = extractInput("src/main/resources/examples")
	
	// Count number of XMAS
	val count = countOccurrence(input)
	
	println(count)
}


