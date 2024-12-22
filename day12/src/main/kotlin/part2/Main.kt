package part2

import common.findRegions
import common.getGardenFromTable


fun main() {
	
	val garden = getGardenFromTable("simple_example.txt")
//	val garden = getGardenFromTable("example.txt")
//	val garden = getGardenFromTable("puzzle_input.txt")
	val regions = findRegions(garden)
	
	val cost = computeCosts(garden, regions)
	println(cost)
	
	// 1930 to low
}
