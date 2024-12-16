package part1

fun main() {
//	val (warehouse, moves) = parseInput(true)
	val (warehouse, moves) = parseInput()
	
	val initialPosition = getCurrentPosition(warehouse)
	val warehouseWithCurrentPosition = removeCurrentPosition(warehouse, initialPosition)
	
	val warehouseAfterMoves = makeMoves(warehouseWithCurrentPosition, moves, initialPosition)

//	printWarehouse(warehouseAfterMoves, initialPosition)
	
	val gpsCoordinates = computeGpsCoordinates(warehouseAfterMoves)
	
	println(gpsCoordinates)
}
