package part1

import common.computeBlinks
import common.getStones

fun main() {
	
	// Parse input
//	val stones = getStones("example.txt")
	val stones = getStones("puzzle_input.txt")
	
	// Compute 25 blinks
	val finalNumberOfStones = computeBlinks(stones)
	
	println(finalNumberOfStones)
}
