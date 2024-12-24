package help

import GameMovement
import common.Direction

fun main() {
	val (warehouse, moves) = parseInput(true)
//	val (warehouse, moves) = parseInput()
	
	val initialPosition = getCurrentPosition(warehouse)
	val warehouseWithoutCurrentPosition = removeCurrentPosition(warehouse, initialPosition)
	val boxes = getBoxesPosition(warehouseWithoutCurrentPosition)
	
	printWarehouse(warehouseWithoutCurrentPosition, initialPosition)
	
	val game = GameMovement(
		playerPosition = initialPosition,
		boxes = boxes.toMutableList(),
		grid = warehouseWithoutCurrentPosition.toMutableMap(),
	)
	
	moves.forEach { move ->
		val direction = Direction.from(move)
		game.move(direction)
		println(game.boxes)
		printWarehouse(game.grid, game.playerPosition)
	}


//	printWarehouse(warehouseAfterMoves, initialPosition)

//	val gpsCoordinates = computeGpsCoordinates(warehouseAfterMoves)

//	println(gpsCoordinates)
}
