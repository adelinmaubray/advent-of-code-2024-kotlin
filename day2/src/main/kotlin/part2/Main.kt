package part2

import parseInput

fun main(args: Array<String>) {
	
	// Get the report
//	val inputReports = exampleInputs.map { list -> Report.create(list.map { it.toString() }) }
	val inputReports = parseInput()
	
	// Compute the number of reports with tolerance
	val numberOfSafeReport = computeNumberOfSafeReportWithTolerance(inputReports)
	
	println(numberOfSafeReport)
}
