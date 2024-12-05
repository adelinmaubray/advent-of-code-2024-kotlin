package part1

import kotlin.math.ceil

fun computeSum(prints: List<List<Int>>): Int {
	return prints.fold(0) { accumulator, updates ->
		val index = ceil(updates.size.toFloat() / 2).toInt() - 1
		accumulator + updates[index]
	}
}
