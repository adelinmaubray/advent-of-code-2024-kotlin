package part2

val wordsToFind = listOf("MAS", "SAM")
const val centerChar = 'A'

/*
 * This is quite a inefficient algorithm cause indexes are not checked, but the exception is catches
 */
fun countOccurrence(grid: List<List<Char>>): Int {
	
	var counter = 0
	grid.forEachIndexed { rowIndex, row ->
		row.forEachIndexed { colIndex, letter ->
			if (
				letter == centerChar &&
				wordsToFind.contains(getDiagonal(grid, rowIndex, colIndex)) &&
				wordsToFind.contains(getOppositeDiagonal(grid, rowIndex, colIndex))
			) {
				counter++
			}
		}
	}
	return counter
}

fun getDiagonal(grid: List<List<Char>>, rowIndex: Int, colIndex: Int): String {
	return try {
		return "${grid[rowIndex - 1][colIndex - 1]}$centerChar${grid[rowIndex + 1][colIndex + 1]}";
	} catch (_: IndexOutOfBoundsException) {
		return ""
	}
}

fun getOppositeDiagonal(grid: List<List<Char>>, rowIndex: Int, colIndex: Int): String {
	return try {
		return "${grid[rowIndex - 1][colIndex + 1]}$centerChar${grid[rowIndex + 1][colIndex - 1]}";
	} catch (_: IndexOutOfBoundsException) {
		return ""
	}
}



