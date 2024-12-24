package part2

import common.*
import kotlin.math.ceil
import kotlin.math.sqrt

fun makeMoves(warehouse: Warehouse, moves: Moves, initialPosition: Position): Warehouse {
	
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

private fun findFirstSignificantSymbol(position: Position, direction: Direction, warehouse: Warehouse): Position {
	
	val rowMultiplicator = 2.toFloat() / 3.toFloat()
	val colMultiplicator = 2
	val warehouseSize = ceil((sqrt(warehouse.size.toFloat()) * rowMultiplicator)).toInt()
	
	when (direction) {
		// TODO find how to get the highest wall
		Direction.UP -> {
			for (i in position.x - 1 downTo 0) {
				val nextPositionToCheck = Position(i, position.y)
				return when (warehouse[nextPositionToCheck]) {
					WALL_SYMBOL, FREE_SPACE_SYMBOL -> nextPositionToCheck
					else -> continue
				}
			}
		}
		
		// TODO find how to get the lowest wall
		Direction.DOWN -> {
			for (i in position.x + 1 until warehouseSize) {
				val nextPositionToCheck = Position(i, position.y)
				return when (warehouse[nextPositionToCheck]) {
					WALL_SYMBOL, FREE_SPACE_SYMBOL -> findFirstSignificantSymbol(nextPositionToCheck, direction, warehouse)
					else -> continue
				}
			}
		}
		
		Direction.LEFT -> {
			for (i in position.y - 1 downTo 0) {
				val nextPositionToCheck = Position(position.x, i)
				return when (warehouse[nextPositionToCheck]) {
					WALL_SYMBOL, FREE_SPACE_SYMBOL -> nextPositionToCheck
					else -> continue
				}
			}
		}
		
		Direction.RIGHT -> {
			for (i in position.y + 1 until (warehouseSize * colMultiplicator)) {
				val nextPositionToCheck = Position(position.x, i)
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

private fun moveBoxes(warehouse: Warehouse, currentPosition: Position, untilPosition: Position, direction: Direction): Warehouse {
	
	var mutableWarehouse = warehouse.toMutableMap()
	when (direction) {
		
		Direction.UP -> {
			// TODO move all boxes up
			for (i in untilPosition.x until currentPosition.x) {
				val partOfTheBox = warehouse[Position(i + 1, currentPosition.y)]!!
				mutableWarehouse[Position(i, currentPosition.y)] = mutableWarehouse[Position(i + 1, currentPosition.y)]!!
				when (partOfTheBox) {
					BIG_BOX_SYMBOL_LEFT -> {
						mutableWarehouse[Position(i, currentPosition.y + 1)] =
							mutableWarehouse[Position(i + 1, currentPosition.y + 1)]!!
						moveBoxes(mutableWarehouse, Position(i, currentPosition.y + 1), untilPosition, direction)
					}
					
					BIG_BOX_SYMBOL_RIGHT -> {
						mutableWarehouse[Position(i, currentPosition.y - 1)] =
							mutableWarehouse[Position(i + 1, currentPosition.y - 1)]!!
						moveBoxes(mutableWarehouse, Position(i, currentPosition.y - 1), untilPosition, direction)
					}
					else -> continue
				}
			}
		}
		
		Direction.DOWN -> {
			// TODO move all boxes down
			for (i in currentPosition.x + 1..untilPosition.x) {
				val partOfTheBox = warehouse[Position(i, currentPosition.y)]!!
				when (partOfTheBox) {
					BIG_BOX_SYMBOL_LEFT -> {
						mutableWarehouse[Position(i, currentPosition.y)] = BIG_BOX_SYMBOL_LEFT
						
						val positionOfThePartOfTheBox = Position(i, currentPosition.y + 1)
						mutableWarehouse[positionOfThePartOfTheBox] = BIG_BOX_SYMBOL_RIGHT
						moveBoxes(mutableWarehouse, positionOfThePartOfTheBox, untilPosition, direction)
					}
					
					BIG_BOX_SYMBOL_RIGHT -> {
						mutableWarehouse[Position(i, currentPosition.y)] = BIG_BOX_SYMBOL_LEFT
						
						val positionOfThePartOfTheBox = Position(i, currentPosition.y - 1)
						mutableWarehouse[positionOfThePartOfTheBox] = BIG_BOX_SYMBOL_RIGHT
						moveBoxes(mutableWarehouse, positionOfThePartOfTheBox, untilPosition, direction)
					}
					else -> continue
				}
			}
		}
		
		Direction.LEFT -> {
			for (i in untilPosition.y until currentPosition.y) {
				mutableWarehouse[Position(currentPosition.x, i)] = mutableWarehouse[Position(currentPosition.x, i + 1)]!!
			}
		}
		
		Direction.RIGHT -> {
			for (i in untilPosition.y downTo currentPosition.y + 1) {
				mutableWarehouse[Position(currentPosition.x, i)] = mutableWarehouse[Position(currentPosition.x, i - 1)]!!
			}
		}
	}
	mutableWarehouse[currentPosition] = FREE_SPACE_SYMBOL
	return mutableWarehouse
}

fun findStackedBoxes(startBox: Box, allBoxes: List<Box>, goingUp: Boolean): List<Box> {
	val stackedBoxes = mutableListOf(startBox)
	var currentBox = startBox
	
	while (true) {
		val nextBox = if (goingUp) {
			// Chercher une boîte au-dessus
			allBoxes.find { box ->
				(box.leftPos.y == currentBox.leftPos.y - 1 &&
					box.leftPos.x == currentBox.leftPos.x) ||
					(box.rightPos.y == currentBox.rightPos.y - 1 &&
						box.rightPos.x == currentBox.rightPos.x)
			}
		} else {
			// Chercher une boîte en-dessous
			allBoxes.find { box ->
				(box.leftPos.y == currentBox.leftPos.y + 1 &&
					box.leftPos.x == currentBox.leftPos.x) ||
					(box.rightPos.y == currentBox.rightPos.y + 1 &&
						box.rightPos.x == currentBox.rightPos.x)
			}
		}
		
		if (nextBox != null) {
			stackedBoxes.add(nextBox)
			currentBox = nextBox
		} else {
			break
		}
	}
	
	return stackedBoxes
}

fun isPositionFree(position: Position, grid: Map<Position, Char>, boxes: List<Box>): Boolean {
	// Vérifier si la position est valide (n'est pas un mur ou hors limites)
	val cell = grid[position] ?: return false // Si la position n'existe pas dans la map
	if (cell == '#') return false
	
	// Vérifier si la position n'est pas occupée par une boîte
	return !boxes.any { box ->
		position == box.leftPos || position == box.rightPos
	}
}
