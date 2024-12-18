package part2

import common.*

fun main() {
	
	IS_EXAMPLE = false
	
	val fileInputPath = if (IS_EXAMPLE) "example.txt" else "puzzle_input.txt"
	val bytes = parseInput(fileInputPath)
	val memorySpacePoint = getMemorySpace() - 1
	
	run allIndex@{
		(1..bytes.size).forEach { index ->
			val corruptedBytes = bytes.slice(0 until index)
			
			try {
				findVisitedSteps(corruptedBytes, Point(0, 0), Point(memorySpacePoint, memorySpacePoint), getMemorySpace())
				println("Iteration $index done")
			} catch (_: Exception) {
				println(bytes[index - 1])
				return@allIndex
			}
		}
	}
}
