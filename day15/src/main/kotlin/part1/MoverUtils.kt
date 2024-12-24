package part1

import common.*

fun applyCurrentPosition(position: Coordinate, direction: Direction): Coordinate {
	return when (direction) {
		Direction.UP -> Pair(position.first - 1, position.second)
		Direction.RIGHT -> Pair(position.first, position.second + 1)
		Direction.DOWN -> Pair(position.first + 1, position.second)
		Direction.LEFT -> Pair(position.first, position.second - 1)
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
			Direction.UP -> warehouse[Pair(position.first - 1, position.second)]
			Direction.RIGHT -> warehouse[Pair(position.first, position.second + 1)]
			Direction.DOWN -> warehouse[Pair(position.first + 1, position.second)]
			Direction.LEFT -> warehouse[Pair(position.first, position.second - 1)]
		}!!
	)
}
