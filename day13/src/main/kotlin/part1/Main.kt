package part1

import common.computeTotalNumberOfTokens
import common.parseInput

fun main() {
	// Get machine behavior
//	val behaviors = parseInput("example.txt")
	val behaviors = parseInput("puzzle_input.txt")
	
	// Get all the cheapest combinaisons
	val numberOfTokens = computeTotalNumberOfTokens(behaviors)
	
	println(numberOfTokens)
}

