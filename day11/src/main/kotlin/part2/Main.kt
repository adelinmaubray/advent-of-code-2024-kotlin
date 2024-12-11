package part2

import common.getInitialStones

fun main() {
	
	tempFolder.deleteRecursively()
	
	// Parse input
//	val stones = getInitialStones("example.txt")
	val stones = getInitialStones("puzzle_input.txt")
	
	// Compute 75 blinks
	val numberOfIterations = 75
	computeBlinks(stones, numberOfIterations)
	
	// Get the number of stones
	val finalNumberOfStones = getNumberOfStones(numberOfIterations)
	
	println(finalNumberOfStones)
}
