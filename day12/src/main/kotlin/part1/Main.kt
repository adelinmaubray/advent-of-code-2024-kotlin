package part1

import common.findRegions
import common.getGardenFromTable

fun main() {
	
	/*
	
	// Get the garden
//	val garden = getGarden("simple_example.txt")
	val garden = getGarden("example.txt")
//	val garden = parseInput("puzzle_input.txt")
	
	// Get plant regions
	val regions = getRegions(garden)
	
	val cost = computeCosts(regions)
	println(cost)
	
	*/

//	val garden = getGardenFromTable("example.txt")
	val garden = getGardenFromTable("puzzle_input.txt")
	val regions = findRegions(garden)
	
	val cost = computeCosts(regions)
	println(cost)
}
