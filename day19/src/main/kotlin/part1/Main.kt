package part1

import common.filterPattern
import common.parseInput
import kotlin.system.measureTimeMillis

fun main() {
	
	// Parse two files inputs
//	val (patterns, designs) = parseInput(true)
	val (patterns, designs) = parseInput()
	
	// Get the possible patterns
	val timeToProcess = measureTimeMillis {
		val possiblePatterns = filterPattern(patterns, designs)
		println(possiblePatterns.count())
	}
	
	println("Time to process: $timeToProcess")
	// with sequence 190
	// with list 310ms
}
