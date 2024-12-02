package part1

import Report
import kotlin.math.abs

/**
 * Increase a compter when
 * - The elements in the list are increasing or decreasing
 * - The max range between consecutive element is 3
 */
fun computeNumberOfSafeReport(reports: List<Report>): Int {
	
	var numberOfSafeReport = 0
	reports.forEach { report ->
		if (checkIncreasingOrDecreasing(report) && checkRange(report)) {
			numberOfSafeReport++
		}
	}
	return numberOfSafeReport
}

/**
 * Compare with the sorted list
 */
private fun checkIncreasingOrDecreasing(report: Report): Boolean {
	
	val levels = report.levels
	val sortedLevels = if (levels[0] > levels[1]) levels.sortedDescending() else levels.sorted()
	return levels == sortedLevels
}

/**
 * Go through the levels and check that the max interval between consecutive elements is 3
 */
private fun checkRange(report: Report): Boolean {
	val levels = report.levels
	for (i in 0..(report.levels.lastIndex - 1)) {
		val difference = abs(levels[i] - levels[i + 1])
		if (difference !in 1..3) {
			return false
		}
	}
	return true
}
