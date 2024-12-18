package part1

import common.IS_EXAMPLE
import common.Point
import common.getMemorySpace
import common.parseInput

fun main() {
	
	IS_EXAMPLE = false
	
	val fileInputPath = if (IS_EXAMPLE) "example.txt" else "puzzle_input.txt"
	val bytes = parseInput(fileInputPath)
	
	val corruptedBytes = bytes.slice(0 until getNumberOfCorruptedBytes())
	
	// This is a BFS algorithm
	val memorySpacePoint = getMemorySpace() - 1
	val steps = findVisitedSteps(corruptedBytes, Point(0, 0), Point(memorySpacePoint, memorySpacePoint), getMemorySpace())
	
	// x cell visited but x-1 steps
	println(steps.size - 1)
}
