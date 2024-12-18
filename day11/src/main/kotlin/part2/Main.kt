package part2

import common.getInitialStones

fun main() {
	
	// Parse input
//	val stones = getStones("example.txt")
	val stones = getInitialStones("puzzle_input.txt")
	
	val finalStones = computeBlinks(stones)
	val finalNumberOfStones = finalStones.values.sum()
	println(finalNumberOfStones)
}
