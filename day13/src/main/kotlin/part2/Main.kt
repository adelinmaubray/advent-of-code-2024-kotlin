package part2

import common.computeTotalNumberOfTokens
import common.parseInput

fun main() {
	// Get machine behavior
//	val behaviors = parseInput("example.txt", true)
	val behaviors = parseInput("puzzle_input.txt", true)
	
	// Get all the cheapest combinaisons
	val numberOfTokens = computeTotalNumberOfTokens(behaviors)
	
	println(numberOfTokens)
}

