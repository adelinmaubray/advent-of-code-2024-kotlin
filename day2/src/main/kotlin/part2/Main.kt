package part2

import common.parseInput

fun main(args: Array<String>) {
	
	// Get the report
//	val inputReports = common.exampleInputs.map { list -> common.Report.create(list.map { it.toString() }) }
	val inputReports = parseInput()
	
	// Compute the number of reports with tolerance
	val numberOfSafeReport = computeNumberOfSafeReportWithTolerance(inputReports)
	
	println(numberOfSafeReport)
}
