package part2

import common.IS_EXAMPLE
import common.parseInput

fun main() {
	
	IS_EXAMPLE = false
	
	val filePath = if (IS_EXAMPLE) "example.txt" else "puzzle_input.txt"
	val initialRobots = parseInput(filePath)
	
	moveRobots(initialRobots)
	
	// brute force : print robots position in file and search for tree
}
