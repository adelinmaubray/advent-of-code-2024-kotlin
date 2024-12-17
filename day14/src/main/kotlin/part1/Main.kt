package part1

import common.IS_EXAMPLE
import common.parseInput

fun main() {
	
	IS_EXAMPLE = true
	
	val filePath = if (IS_EXAMPLE) "example.txt" else "puzzle_input.txt"
	val robots = parseInput(filePath)
	
	robots.forEach {
		println(it)
	}
}
