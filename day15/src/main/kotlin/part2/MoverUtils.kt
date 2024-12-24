package part2

import common.*

fun applyCurrentPosition(position: Position, direction: Direction): Position {
	return when (direction) {
		Direction.UP -> Position(position.x - 1, position.y)
		Direction.RIGHT -> Position(position.x, position.y + 1)
		Direction.DOWN -> Position(position.x + 1, position.y)
		Direction.LEFT -> Position(position.x, position.y - 1)
	}
}

fun isBox(position: Position, direction: Direction, warehouse: Warehouse): Boolean {
	return funIsObstacle(position, direction, warehouse, BOX_SYMBOL, BIG_BOX_SYMBOL_RIGHT, BIG_BOX_SYMBOL_LEFT)
}

fun isWall(position: Position, direction: Direction, warehouse: Warehouse): Boolean {
	return funIsObstacle(position, direction, warehouse, WALL_SYMBOL)
}

fun funIsObstacle(position: Position, direction: Direction, warehouse: Warehouse, vararg symbols: Char): Boolean {
	return symbols.contains(
		when (direction) {
			Direction.UP -> warehouse[Position(position.x - 1, position.y)]
			Direction.RIGHT -> warehouse[Position(position.x, position.y + 1)]
			Direction.DOWN -> warehouse[Position(position.x + 1, position.y)]
			Direction.LEFT -> warehouse[Position(position.x, position.y - 1)]
		}!!
	)
}
