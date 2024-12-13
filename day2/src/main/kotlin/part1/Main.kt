package part1

import common.parseInput

fun main(args: Array<String>) {
	
	// Get the report
//	val inputReports = parseInput("example.txt")
	val inputReports = parseInput("puzzle_input.txt")
	
	// Compute the number of reports
	val numberOfSafeReport = computeNumberOfSafeReport(inputReports)
	
	println(numberOfSafeReport)
}
