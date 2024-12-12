package part1

import common.getRegions
import common.parseInput

fun main() {
	
	// Get the garden
	val garden = parseInput("example.txt")
//	val garden = parseInput("puzzle_input.txt")
	
	// Get plant regions
	val regions = getRegions(garden)
}
