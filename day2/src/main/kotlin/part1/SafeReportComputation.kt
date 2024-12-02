package part1

import Report
import checkIncreasingOrDecreasing
import checkRange

/**
 * Increase a compter when
 * - The elements in the list are increasing or decreasing
 * - The max range between consecutive element is 3
 */
fun computeNumberOfSafeReport(reports: List<Report>): Int {
	
	var numberOfSafeReport = 0
	reports.forEach { report ->
		val levels = report.levels
		if (checkIncreasingOrDecreasing(levels) && checkRange(levels)) {
			numberOfSafeReport++
		}
	}
	return numberOfSafeReport
}
