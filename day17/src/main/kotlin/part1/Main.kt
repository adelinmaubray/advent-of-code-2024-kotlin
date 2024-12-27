package part1

import common.parseInput
import common.runSoftware

fun main() {

//	val computer = parseInput("example.txt")
	val computer = parseInput("puzzle_input.txt")
	val softwareResult = runSoftware(computer)
	println(softwareResult.joinToString(","))
}
