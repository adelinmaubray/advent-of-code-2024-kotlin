package part2

fun main() {
	val (warehouse, moves) = parseInput(true)
//	val (warehouse, moves) = parseInput()
	
	val initialPosition = getCurrentPosition(warehouse)
	val warehouseWithoutCurrentPosition = removeCurrentPosition(warehouse, initialPosition)
	
	printWarehouse(warehouseWithoutCurrentPosition, initialPosition, true)

//	val warehouseAfterMoves = makeMoves(warehouseWithoutCurrentPosition, moves, initialPosition)

//	printWarehouse(warehouseAfterMoves, initialPosition)

//	val gpsCoordinates = computeGpsCoordinates(warehouseAfterMoves)

//	println(gpsCoordinates)
}
