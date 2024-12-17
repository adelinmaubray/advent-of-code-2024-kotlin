package part1

import common.BOX_SYMBOL
import common.Warehouse

fun computeGpsCoordinates(warehouseAfterMoves: Warehouse): Long {
	var sum = 0L
	warehouseAfterMoves
		.filter { (_, value) -> value == BOX_SYMBOL }
		.map { (key, _) -> key }
		.forEach { (x, y) -> sum += (x * 100 + y) }
	return sum
}