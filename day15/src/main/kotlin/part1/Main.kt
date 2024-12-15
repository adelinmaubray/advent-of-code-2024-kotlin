package part1

import common.getCurrentPosition
import common.makeMoves
import common.parseInput
import common.removeCurrentPosition
import kotlin.math.sqrt

fun main() {
	val (warehouse, moves) = parseInput(true)
	
	val warehouseSize = sqrt(warehouse.size.toFloat()).toInt()
	val initialPosition = getCurrentPosition(warehouse)
	val warehouseWithCurrentPosition = removeCurrentPosition(warehouse, initialPosition)
	
	val warehouseAfterMoves = makeMoves(warehouseWithCurrentPosition, moves, initialPosition, warehouseSize)
}
