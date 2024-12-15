package common


fun makeMoves(warehouse: Warehouse, moves: Moves, initialPosition: Coordinate, warehouseSize: Int): Warehouse {
	
	val mutableWarehouse = warehouse.toMutableMap()
	var currentPosition = initialPosition
	
	moves.forEach forEachMove@{ move ->
		
		val direction = Direction.from(move) ?: return@forEachMove
		
		if (isWall(currentPosition, direction, mutableWarehouse)) return@forEachMove
		if (isBox(currentPosition, direction, mutableWarehouse)) {
			// go to end of warehouse
			// until:
			// '.' → push all boxes
			// '#' → do nothing
		} else {
			currentPosition = when (direction) {
				Direction.UP -> Coordinate(currentPosition.first - 1, currentPosition.second)
				Direction.RIGHT -> Coordinate(currentPosition.first, currentPosition.second + 1)
				Direction.DOWN -> Coordinate(currentPosition.first + 1, currentPosition.second)
				Direction.LEFT -> Coordinate(currentPosition.first, currentPosition.second - 1)
			}
		}
	}
	
	return mutableWarehouse.toMap()
}

private fun isBox(position: Coordinate, direction: Direction, warehouse: Warehouse): Boolean {
	return funIsObstacle(position, direction, warehouse, 'O')
}

private fun isWall(position: Coordinate, direction: Direction, warehouse: Warehouse): Boolean {
	return funIsObstacle(position, direction, warehouse, '#')
}

private fun funIsObstacle(position: Coordinate, direction: Direction, warehouse: Warehouse, symbol: Char): Boolean {
	return when (direction) {
		Direction.UP -> warehouse[Coordinate(position.first - 1, position.second)]
		Direction.RIGHT -> warehouse[Coordinate(position.first, position.second + 1)]
		Direction.DOWN -> warehouse[Coordinate(position.first + 1, position.second)]
		Direction.LEFT -> warehouse[Coordinate(position.first, position.second - 1)]
	} == symbol
}
