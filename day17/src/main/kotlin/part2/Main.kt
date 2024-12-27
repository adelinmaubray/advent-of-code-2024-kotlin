package part2

import common.parseInput

fun main() {

//	val computer = parseInput("example.txt")
	val computer = parseInput("puzzle_input.txt")
	
	val softwareResult = runSpecificSoftware(computer)
	println(softwareResult)
}
