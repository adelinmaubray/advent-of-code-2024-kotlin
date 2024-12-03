package part2

import common.computeMultiplication
import common.extractMultiplicatorPair
import common.readInput

fun main() {
	
	// Get the puzzle input
//	val input = exampleInput
	val input = readInput()
	
	// Extract operation
	val multiplicatorPair = extractMultiplicatorPair(input, true)
	
	// Multiple result
	val res = computeMultiplication(multiplicatorPair)
	
	println(res)
}
