package part1

import common.parseInput

fun main(args: Array<String>) {
	
	// Get the report
//	val inputReports = common.exampleInputs.map { list -> common.Report.create(list.map { it.toString() }) }
	val inputReports = parseInput()
	
	// Compute the number of reports
	val numberOfSafeReport = computeNumberOfSafeReport(inputReports)
	
	println(numberOfSafeReport)
}
