package part2

import common.*

fun applyCurrentPosition(position: Coordinate, direction: Direction): Coordinate {
	return when (direction) {
		Direction.UP -> Coordinate(position.x - 1, position.y)
		Direction.RIGHT -> Coordinate(position.x, position.y + 1)
		Direction.DOWN -> Coordinate(position.x + 1, position.y)
		Direction.LEFT -> Coordinate(position.x, position.y - 1)
	}
}

fun isBox(position: Coordinate, direction: Direction, warehouse: Warehouse): Boolean {
	return funIsObstacle(position, direction, warehouse, BOX_SYMBOL, BIG_BOX_SYMBOL_RIGHT, BIG_BOX_SYMBOL_LEFT)
}

fun isWall(position: Coordinate, direction: Direction, warehouse: Warehouse): Boolean {
	return funIsObstacle(position, direction, warehouse, WALL_SYMBOL)
}

fun funIsObstacle(position: Coordinate, direction: Direction, warehouse: Warehouse, vararg symbols: Char): Boolean {
	return symbols.contains(
		when (direction) {
			Direction.UP -> warehouse[Coordinate(position.x - 1, position.y)]
			Direction.RIGHT -> warehouse[Coordinate(position.x, position.y + 1)]
			Direction.DOWN -> warehouse[Coordinate(position.x + 1, position.y)]
			Direction.LEFT -> warehouse[Coordinate(position.x, position.y - 1)]
		}!!
	)
}
