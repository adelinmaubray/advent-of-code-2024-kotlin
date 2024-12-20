package part1

import common.computeMaze
import common.computeSaveTimeForEachCheats
import common.findShortestPathLength
import common.getMaze

fun main() {

//	val bruteMaze = getMaze("example.txt")
	val bruteMaze = getMaze("puzzle_input.txt")
	
	val (maze, coordinates) = computeMaze(bruteMaze)
	val start = coordinates.first
	val end = coordinates.second
	
	val pathWithoutCheat = findShortestPathLength(maze, start, end, bruteMaze.size)
	
	val savedTimePerCheat = computeSaveTimeForEachCheats(maze, pathWithoutCheat, bruteMaze.size)
	println(savedTimePerCheat.toSortedMap())
	println(savedTimePerCheat.filter { it.key >= 100 }.values.sum())
	
	// 413 is too low
}
