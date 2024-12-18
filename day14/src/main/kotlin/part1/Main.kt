package part1

import common.IS_EXAMPLE
import common.computeSafetyFactor
import common.moveRobots
import common.parseInput

fun main() {
	
	IS_EXAMPLE = false
	
	val filePath = if (IS_EXAMPLE) "example.txt" else "puzzle_input.txt"
	val initialRobots = parseInput(filePath)
	
	val robots = moveRobots(initialRobots)
	
	val safetyFactor = computeSafetyFactor(robots)
	
	println(safetyFactor)
}
