package part2

import common.computeMaze
import common.parseInput

fun main() {

//	val bruteMaze = parseInput("example.txt")
	val bruteMaze = parseInput("puzzle_input.txt")
	
	val (maze, coordinates) = computeMaze(bruteMaze)
	val start = coordinates.first
	val end = coordinates.second
	
	val bestPaths = findPathAllWithLowerScore(maze, start, end, bruteMaze.size)
	val allPlacesToSit = bestPaths.flatMap { it.visitedCells }.toSet()
	
	println(allPlacesToSit.size)
}
