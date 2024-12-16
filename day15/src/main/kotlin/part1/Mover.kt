package part1

import common.*
import kotlin.math.sqrt

fun makeMoves(warehouse: Warehouse, moves: Moves, initialPosition: Coordinate): Warehouse {
	
	var modifiedWarehouse = warehouse.toMutableMap()
	var currentPosition = initialPosition
	
	moves.forEach forEachMove@{ move ->
		
		val direction = Direction.Companion.from(move) ?: return@forEachMove
		
		if (isWall(currentPosition, direction, modifiedWarehouse)) return@forEachMove
		if (isBox(currentPosition, direction, modifiedWarehouse)) {
			
			val firstSignificantSymbolPosition = findFirstSignificantSymbol(currentPosition, direction, modifiedWarehouse)
			
			if (modifiedWarehouse[firstSignificantSymbolPosition] == WALL_SYMBOL) return@forEachMove
			
			if (modifiedWarehouse[firstSignificantSymbolPosition] == FREE_SPACE_SYMBOL) {
				modifiedWarehouse = moveBoxes(modifiedWarehouse, currentPosition, firstSignificantSymbolPosition, direction).toMutableMap()
				currentPosition = applyCurrentPosition(currentPosition, direction)
			}
		} else {
			currentPosition = applyCurrentPosition(currentPosition, direction)
		}
		
		modifiedWarehouse[currentPosition] = FREE_SPACE_SYMBOL
	}
	
	return modifiedWarehouse.toMap()
}

private fun moveBoxes(warehouse: Warehouse, currentPosition: Coordinate, untilPosition: Coordinate, direction: Direction): Warehouse {
	val mutableWarehouse = warehouse.toMutableMap()
	when (direction) {
		Direction.UP -> {
			for (i in currentPosition.first - 1 downTo untilPosition.first) {
				mutableWarehouse[Coordinate(i, currentPosition.second)] = BOX_SYMBOL
			}
		}
		
		Direction.DOWN -> {
			for (i in currentPosition.first + 1..untilPosition.first) {
				mutableWarehouse[Coordinate(i, currentPosition.second)] = BOX_SYMBOL
			}
		}
		
		Direction.LEFT -> {
			for (i in currentPosition.second - 1 downTo untilPosition.second) {
				mutableWarehouse[Coordinate(currentPosition.first, i)] = BOX_SYMBOL
			}
		}
		
		Direction.RIGHT -> {
			for (i in currentPosition.second + 1..untilPosition.second) {
				mutableWarehouse[Coordinate(currentPosition.first, i)] = BOX_SYMBOL
			}
		}
	}
	mutableWarehouse[currentPosition] = FREE_SPACE_SYMBOL
	return mutableWarehouse
}

private fun findFirstSignificantSymbol(position: Coordinate, direction: Direction, warehouse: Warehouse): Coordinate {
	
	val warehouseSize = sqrt(warehouse.size.toFloat()).toInt()
	
	when (direction) {
		Direction.UP -> {
			for (i in position.first - 1 downTo 0) {
				val nextPositionToCheck = Pair(i, position.second)
				return when (warehouse[nextPositionToCheck]) {
					WALL_SYMBOL, FREE_SPACE_SYMBOL -> nextPositionToCheck
					else -> continue
				}
			}
		}
		
		Direction.DOWN -> {
			for (i in position.first + 1 until warehouseSize) {
				val nextPositionToCheck = Pair(i, position.second)
				return when (warehouse[nextPositionToCheck]) {
					WALL_SYMBOL, FREE_SPACE_SYMBOL -> nextPositionToCheck
					else -> continue
				}
			}
		}
		
		Direction.LEFT -> {
			for (i in position.second - 1 downTo 0) {
				val nextPositionToCheck = Pair(position.first, i)
				return when (warehouse[nextPositionToCheck]) {
					WALL_SYMBOL, FREE_SPACE_SYMBOL -> nextPositionToCheck
					else -> continue
				}
			}
		}
		
		Direction.RIGHT -> {
			for (i in position.second + 1 until warehouseSize) {
				val nextPositionToCheck = Pair(position.first, i)
				return when (warehouse[nextPositionToCheck]) {
					WALL_SYMBOL, FREE_SPACE_SYMBOL -> nextPositionToCheck
					else -> continue
				}
			}
		}
	}
	
	// Should return a wall since the warehouse is surrounded by walls
	throw Exception("The warehouse is probably not correct")
}
