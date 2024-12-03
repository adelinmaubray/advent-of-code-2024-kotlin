package part1

import common.readInput

fun main() {
	
	// Get the puzzle input
//	val input = exampleInput
	val input = readInput()
	
	// Extract operation
	val multiplicatorPair = extractMultiplicatorPair(input)
	
	// Multiple result
	val res = computeMultiplication(multiplicatorPair)
	
	println(res)
}
