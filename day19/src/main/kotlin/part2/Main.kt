package part2

import common.parseInput
import kotlin.system.measureTimeMillis

fun main() {
	
	// Parse two files inputs
//	val (patterns, designs) = parseInput(true)
	val (patterns, designs) = parseInput()
	
	println(patterns.toList().joinToString(", "))
	designs.forEach(::println)
	
	// Get the possible patterns
	val timeToProcess = measureTimeMillis {
		val possiblePatterns = getPossiblePattern(patterns, designs)
		println(possiblePatterns.sum())
	}
	
	println("Time to process: $timeToProcess")
	// with sequence 190
	// with list 310ms
}
