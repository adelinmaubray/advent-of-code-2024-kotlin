package part1

const val wordToFind = "XMAS"
const val wordSize = wordToFind.length

/*
 * This is quite a inefficient algorithm cause indexes are not checked, but the exception is catches
 */
fun countOccurrence(grid: List<List<Char>>): Int {
	
	var counter = 0
	grid.forEachIndexed { rowIndex, row ->
		row.forEachIndexed { colIndex, _ ->
			if (getHorizontal(row, colIndex) == wordToFind) counter++
			if (getHorizontalBackward(row, colIndex) == wordToFind) counter++
			if (getVertical(grid, rowIndex, colIndex) == wordToFind) counter++
			if (getVerticalBackward(grid, rowIndex, colIndex) == wordToFind) counter++
			if (getDiagonal(grid, rowIndex, colIndex) == wordToFind) counter++
			if (getDiagonalBackward(grid, rowIndex, colIndex) == wordToFind) counter++
			if (getOtherDiagonal(grid, rowIndex, colIndex) == wordToFind) counter++
			if (getOtherDiagonalBackward(grid, rowIndex, colIndex) == wordToFind) counter++
		}
	}
	return counter
}

fun getHorizontal(row: List<Char>, colIndex: Int): String {
	return try {
		(0 until wordSize).map { row[colIndex + it] }.joinToString("")
	} catch (_: IndexOutOfBoundsException) {
		""
	}
}

fun getHorizontalBackward(row: List<Char>, colIndex: Int): String {
	return try {
		(0 until wordSize).map { row[colIndex - it] }.joinToString("")
	} catch (_: IndexOutOfBoundsException) {
		""
	}
}

fun getVertical(grid: List<List<Char>>, rowIndex: Int, colIndex: Int): String {
	return try {
		(0 until wordSize).map { grid[rowIndex + it][colIndex] }.joinToString("")
	} catch (_: IndexOutOfBoundsException) {
		""
	}
}

fun getVerticalBackward(grid: List<List<Char>>, rowIndex: Int, colIndex: Int): String {
	return try {
		(0 until wordSize).map { grid[rowIndex - it][colIndex] }.joinToString("")
	} catch (_: IndexOutOfBoundsException) {
		""
	}
}

fun getDiagonal(grid: List<List<Char>>, rowIndex: Int, colIndex: Int): String {
	return try {
		(0 until wordSize).map { grid[rowIndex + it][colIndex + it] }.joinToString("")
	} catch (_: IndexOutOfBoundsException) {
		""
	}
}

fun getDiagonalBackward(grid: List<List<Char>>, rowIndex: Int, colIndex: Int): String {
	return try {
		(0 until wordSize).map { grid[rowIndex - it][colIndex - it] }.joinToString("")
	} catch (_: IndexOutOfBoundsException) {
		""
	}
}

fun getOtherDiagonal(grid: List<List<Char>>, rowIndex: Int, colIndex: Int): String {
	return try {
		(0 until wordSize).map { grid[rowIndex + it][colIndex - it] }.joinToString("")
	} catch (_: IndexOutOfBoundsException) {
		""
	}
}

fun getOtherDiagonalBackward(grid: List<List<Char>>, rowIndex: Int, colIndex: Int): String {
	return try {
		(0 until wordSize).map { grid[rowIndex - it][colIndex + it] }.joinToString("")
	} catch (_: IndexOutOfBoundsException) {
		""
	}
}



