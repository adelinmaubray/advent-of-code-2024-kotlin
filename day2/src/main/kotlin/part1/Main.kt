package part1

import Report
import parseInput

val exampleInputs = listOf(
	listOf(7, 6, 4, 2, 1),
	listOf(1, 2, 7, 8, 9),
	listOf(9, 7, 6, 2, 1),
	listOf(1, 3, 2, 4, 5),
	listOf(8, 6, 4, 4, 1),
	listOf(1, 3, 6, 7, 9)
)

fun main(args: Array<String>) {
	
	// Get the report
//	val inputReports = exampleInputs.map { list -> Report.create(list.map { it.toString() }) }
	val inputReports = parseInput()
	
	// Compute the
	val numberOfSafeReport = computeNumberOfSafeReport(inputReports)
	
	println(numberOfSafeReport)
}
