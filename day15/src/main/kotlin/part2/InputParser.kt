package part2

import common.*
import java.io.File
import kotlin.math.ceil
import kotlin.math.sqrt

fun parseInput(isExample: Boolean = false): Pair<Warehouse, Moves> {
	
	val extraPath = if (isExample) "/example" else ""
	
	val warehouse = mutableMapOf<Position, Char>()
	File("src/main/resources$extraPath/warehouse.txt")
		.readLines()
		.forEachIndexed { rowIndex, row ->
			row.forEachIndexed { colIndex, char ->
				
				val position1 = Position(rowIndex, 2 * colIndex)
				val position2 = Position(rowIndex, 2 * colIndex + 1)
				
				when (char) {
					WALL_SYMBOL -> {
						warehouse.put(position1, WALL_SYMBOL)
						warehouse.put(position2, WALL_SYMBOL)
					}
					
					BOX_SYMBOL -> {
						warehouse.put(position1, BIG_BOX_SYMBOL_LEFT)
						warehouse.put(position2, BIG_BOX_SYMBOL_RIGHT)
					}
					
					FREE_SPACE_SYMBOL -> {
						warehouse.put(position1, FREE_SPACE_SYMBOL)
						warehouse.put(position2, FREE_SPACE_SYMBOL)
					}
					
					CURRENT_POSITION -> {
						warehouse.put(position1, CURRENT_POSITION)
						warehouse.put(position2, FREE_SPACE_SYMBOL)
					}
					
					else -> throw Exception("Map input contains unknown symbol: $char")
				}
			}
		}
	
	
	val moves = File("src/main/resources$extraPath/moves.txt").readLines().map { it.toList() }.flatten()
	
	return warehouse to moves
}

fun getCurrentPosition(warehouse: Warehouse): Position {
	return warehouse.filter { (_, value) -> value == CURRENT_POSITION }.keys.first()
}

fun removeCurrentPosition(warehouse: Warehouse, currentPosition: Position): Warehouse {
	val mutableWarehouse = warehouse.toMutableMap()
	mutableWarehouse[currentPosition] = '.'
	return mutableWarehouse
}

fun printWarehouse(warehouse: Warehouse, curentPosition: Position) {
	
	val rowMultiplicator = 2.toFloat() / 3.toFloat()
	val colMultiplicator = 2
	val mutableWarehouse = warehouse.toMutableMap()
	
	val size = ceil((sqrt(warehouse.size.toFloat()) * rowMultiplicator)).toInt()
	val list = MutableList(size) {
		MutableList(size * colMultiplicator) {
			'.'
		}
	}
	
	mutableWarehouse[curentPosition] = CURRENT_POSITION
	mutableWarehouse.entries.forEach { (key, value) ->
		list[key.x][key.y] = value
	}
	
	list.forEach { lines ->
		lines.forEach(::print)
		println()
	}
	
	println()
	println()
}
