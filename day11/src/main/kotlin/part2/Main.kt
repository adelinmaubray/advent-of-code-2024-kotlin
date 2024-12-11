package part2

import common.getInitialStones

fun main() {
	
	// Parse input
//	val stones = getInitialStones("example.txt")
	val stones = getInitialStones("puzzle_input.txt")
	
	val finalNumberOfStones = stones.fold(0L) stoneBlink@{ numberOfStones, stone ->
		
		tempFolder.deleteRecursively()
		println("Handling $stone | $numberOfStones already found")
		
		// Compute 75 blinks
		val numberOfIterations = 75
		computeBlinks(listOf(stone), numberOfIterations)
		
		// Get the number of stones
		return@stoneBlink numberOfIterations + getNumberOfStones(numberOfIterations)
	}
	
	println(finalNumberOfStones)
}
