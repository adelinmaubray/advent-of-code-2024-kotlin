package part2

import common.*
import kotlin.math.ceil
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
		printWarehouse(modifiedWarehouse, currentPosition)
	}
	
	return modifiedWarehouse.toMap()
}

private fun findFirstSignificantSymbol(position: Coordinate, direction: Direction, warehouse: Warehouse): Coordinate {
	
	val rowMultiplicator = 2.toFloat() / 3.toFloat()
	val colMultiplicator = 2
	val warehouseSize = ceil((sqrt(warehouse.size.toFloat()) * rowMultiplicator)).toInt()
	
	when (direction) {
		// TODO find how to get the highest wall
		Direction.UP -> {
			for (i in position.first - 1 downTo 0) {
				val nextPositionToCheck = Pair(i, position.second)
				return when (warehouse[nextPositionToCheck]) {
					WALL_SYMBOL, FREE_SPACE_SYMBOL -> nextPositionToCheck
					else -> continue
				}
			}
		}
		
		// TODO find how to get the lowest wall
		Direction.DOWN -> {
			for (i in position.first + 1 until warehouseSize) {
				val nextPositionToCheck = Pair(i, position.second)
				return when (warehouse[nextPositionToCheck]) {
					WALL_SYMBOL, FREE_SPACE_SYMBOL -> findFirstSignificantSymbol(nextPositionToCheck, direction, warehouse)
					else -> continue
				}
			}
		}
		
		Direction.LEFT -> {
			for (i in position.second - 1 downTo 0) {
				val nextPositionToCheck = Coordinate(position.first, i)
				return when (warehouse[nextPositionToCheck]) {
					WALL_SYMBOL, FREE_SPACE_SYMBOL -> nextPositionToCheck
					else -> continue
				}
			}
		}
		
		Direction.RIGHT -> {
			for (i in position.second + 1 until (warehouseSize * colMultiplicator)) {
				val nextPositionToCheck = Coordinate(position.first, i)
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

private fun moveBoxes(warehouse: Warehouse, currentPosition: Coordinate, untilPosition: Coordinate, direction: Direction): Warehouse {
	
	var mutableWarehouse = warehouse.toMutableMap()
	when (direction) {
		
		Direction.UP -> {
			// TODO move all boxes up
			for (i in untilPosition.first until currentPosition.first) {
				val partOfTheBox = warehouse[Coordinate(i + 1, currentPosition.second)]!!
				mutableWarehouse[Coordinate(i, currentPosition.second)] = mutableWarehouse[Coordinate(i + 1, currentPosition.second)]!!
				when (partOfTheBox) {
					BIG_BOX_SYMBOL_LEFT -> {
						mutableWarehouse[Coordinate(i, currentPosition.second + 1)] =
							mutableWarehouse[Coordinate(i + 1, currentPosition.second + 1)]!!
						moveBoxes(mutableWarehouse, Coordinate(i, currentPosition.second + 1), untilPosition, direction)
					}
					
					BIG_BOX_SYMBOL_RIGHT -> {
						mutableWarehouse[Coordinate(i, currentPosition.second - 1)] =
							mutableWarehouse[Coordinate(i + 1, currentPosition.second - 1)]!!
						moveBoxes(mutableWarehouse, Coordinate(i, currentPosition.second - 1), untilPosition, direction)
					}
					else -> continue
				}
			}
		}
		
		Direction.DOWN -> {
			// TODO move all boxes down
			for (i in currentPosition.first + 1..untilPosition.first) {
				val partOfTheBox = warehouse[Coordinate(i, currentPosition.second)]!!
				when (partOfTheBox) {
					BIG_BOX_SYMBOL_LEFT -> {
						mutableWarehouse[Coordinate(i, currentPosition.second)] = BIG_BOX_SYMBOL_LEFT
						
						val positionOfThePartOfTheBox = Coordinate(i, currentPosition.second + 1)
						mutableWarehouse[positionOfThePartOfTheBox] = BIG_BOX_SYMBOL_RIGHT
						moveBoxes(mutableWarehouse, positionOfThePartOfTheBox, untilPosition, direction)
					}
					
					BIG_BOX_SYMBOL_RIGHT -> {
						mutableWarehouse[Coordinate(i, currentPosition.second)] = BIG_BOX_SYMBOL_LEFT
						
						val positionOfThePartOfTheBox = Coordinate(i, currentPosition.second - 1)
						mutableWarehouse[positionOfThePartOfTheBox] = BIG_BOX_SYMBOL_RIGHT
						moveBoxes(mutableWarehouse, positionOfThePartOfTheBox, untilPosition, direction)
					}
					else -> continue
				}
			}
		}
		
		Direction.LEFT -> {
			for (i in untilPosition.second until currentPosition.second) {
				mutableWarehouse[Coordinate(currentPosition.first, i)] = mutableWarehouse[Coordinate(currentPosition.first, i + 1)]!!
			}
		}
		
		Direction.RIGHT -> {
			for (i in untilPosition.second downTo currentPosition.second + 1) {
				mutableWarehouse[Coordinate(currentPosition.first, i)] = mutableWarehouse[Coordinate(currentPosition.first, i - 1)]!!
			}
		}
	}
	mutableWarehouse[currentPosition] = FREE_SPACE_SYMBOL
	return mutableWarehouse
}
