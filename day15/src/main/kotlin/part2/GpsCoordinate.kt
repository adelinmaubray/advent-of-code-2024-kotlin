package part2

import common.BOX_SYMBOL

fun computeGpsCoordinates(warehouseAfterMoves: Warehouse): Long {
	var sum = 0L
	warehouseAfterMoves
		.filter { (_, value) -> value == BOX_SYMBOL }
		.map { (key, _) -> key }
		.forEach { (x, y) -> sum += (x * 100 + y) }
	return sum
}
