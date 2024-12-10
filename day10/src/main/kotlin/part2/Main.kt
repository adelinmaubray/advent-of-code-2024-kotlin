package part2

import common.getTrailHeads
import common.parseInput

fun main() {
	
	//	val hikingMap = parseInput("simple_example.txt")
//	val hikingMap = parseInput("example.txt")
	val hikingMap = parseInput("puzzle_input.txt")
	
	val trailHeads = getTrailHeads(hikingMap)
	val scores = computeScores(trailHeads, hikingMap)
	println(scores.sum())
}
