package part1

import common.getInitialStones

fun main() {
	
	// Parse input
//	val stones = getStones("example.txt")
	val stones = getInitialStones("puzzle_input.txt")
	
	// Compute 25 blinks
	val finalNumberOfStones = computeBlinks(stones)
	
	println(finalNumberOfStones)
}
