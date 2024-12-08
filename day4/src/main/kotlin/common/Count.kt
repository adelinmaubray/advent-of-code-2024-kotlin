package common

const val wordToFind = "XMAS"
const val wordSize = wordToFind.length

// Absolutely not optimized... but tired
fun countOccurrence(grid: List<List<Char>>): Int {
	
	var counter = 0
	grid.forEachIndexed { rowIndex, row ->
		// can check here if the rowIndex is too big
		row.forEachIndexed { colIndex, _ ->
			// can check here if the colIndex is too big
			if (getHorizontal(row, colIndex) == wordToFind) counter++
			if (getHorizontalBackward(row, colIndex) == wordToFind) counter++
			if (getVertical(grid, rowIndex, colIndex) == wordToFind) counter++
			if (getVerticalBackward(grid, rowIndex, colIndex) == wordToFind) counter++
			if (getDiagonal(grid, rowIndex, colIndex) == wordToFind) counter++
			if (getDiagonalBackward(grid, rowIndex, colIndex) == wordToFind) counter++
		}
	}
	return counter
}

fun getHorizontal(row: List<Char>, colIndex: Int): String {
	return try {
		(0 until wordSize).map { row[colIndex + it] }.joinToString("")
	} catch (_: Exception) {
		""
	}
}

fun getHorizontalBackward(row: List<Char>, colIndex: Int): String {
	return try {
		(0 until wordSize).map { row[colIndex - it] }.joinToString("")
	} catch (_: Exception) {
		""
	}
}

fun getVertical(grid: List<List<Char>>, rowIndex: Int, colIndex: Int): String {
	return try {
		(0 until wordSize).map { grid[rowIndex + it][colIndex] }.joinToString("")
	} catch (_: Exception) {
		""
	}
}

fun getVerticalBackward(grid: List<List<Char>>, rowIndex: Int, colIndex: Int): String {
	return try {
		(0 until wordSize).map { grid[rowIndex - it][colIndex] }.joinToString("")
	} catch (_: Exception) {
		""
	}
}

fun getDiagonal(grid: List<List<Char>>, rowIndex: Int, colIndex: Int): String {
	return try {
		(0 until wordSize).map { grid[rowIndex + it][colIndex + it] }.joinToString("")
	} catch (_: Exception) {
		""
	}
}

fun getDiagonalBackward(grid: List<List<Char>>, rowIndex: Int, colIndex: Int): String {
	return try {
		(0 until wordSize).map { grid[rowIndex - it][colIndex - it] }.joinToString("")
	} catch (_: Exception) {
		""
	}
}



