package part2

import common.Report
import common.checkIncreasingOrDecreasing
import common.checkRange

/**
 * Increase a compter when
 * - The elements in the list are increasing or decreasing
 * - The max range between consecutive element is 3
 * - An element is removed and the previous conditions are met
 */
fun computeNumberOfSafeReportWithTolerance(reports: List<Report>): Int {
	
	var numberOfSafeReport = 0
	
	reports.forEach { report ->
		val levels = report.levels
		if (checkIncreasingOrDecreasing(levels) && checkRange(levels)) {
			numberOfSafeReport++
		} else {
			if (checkWithRemoval(report)) numberOfSafeReport++
		}
	}
	
	return numberOfSafeReport
}

private fun checkWithRemoval(report: Report): Boolean {

//	var numberOfTolerance = 0
//
//	for (i in 0..report.levels.lastIndex) {
//		val levels = report.levels.toMutableList()
//		levels.removeAt(i)
//		println("trying removal - $levels")
//		if (common.checkIncreasingOrDecreasing(levels) && common.checkRange(levels)) {
//			println("true")
//			numberOfTolerance++
//		}
//	}
//
//	return numberOfTolerance == 1
	
	for (i in 0..report.levels.lastIndex) {
		val levels = report.levels.toMutableList()
		levels.removeAt(i)
		if (checkIncreasingOrDecreasing(levels) && checkRange(levels)) {
			return true
		}
	}
	
	return false
}
