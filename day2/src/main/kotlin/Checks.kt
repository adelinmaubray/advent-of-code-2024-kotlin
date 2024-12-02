import kotlin.math.abs

/**
 * Compare with the sorted list
 */
fun checkIncreasingOrDecreasing(levels: List<Int>): Boolean {
	val sortedLevels = if (levels[0] > levels[1]) levels.sortedDescending() else levels.sorted()
	return levels == sortedLevels
}

/**
 * Go through the levels and check that the max interval between consecutive elements is 3
 */
fun checkRange(levels: List<Int>): Boolean {
	for (i in 0..(levels.lastIndex - 1)) {
		val difference = abs(levels[i] - levels[i + 1])
		if (difference !in 1..3) {
			return false
		}
	}
	return true
}
