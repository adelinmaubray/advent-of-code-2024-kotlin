package part1

import common.computeMaze
import common.findPathWithLowerScore
import common.parseInput

fun main() {

//	val bruteMaze = parseInput("example.txt")
	val bruteMaze = parseInput("puzzle_input.txt")
	
	val (maze, coordinates) = computeMaze(bruteMaze)
	val start = coordinates.first
	val end = coordinates.second
	
	val bestPath = findPathWithLowerScore(maze, start, end, bruteMaze.size)
	
	println(bestPath.score)
}
