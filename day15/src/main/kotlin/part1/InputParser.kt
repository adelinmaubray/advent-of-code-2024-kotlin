package part1

import common.CURRENT_POSITION
import common.Coordinate
import common.Moves
import common.Warehouse
import java.io.File
import kotlin.math.sqrt

fun parseInput(isExample: Boolean = false): Pair<Warehouse, Moves> {
	
	val extraPath = if (isExample) "/example" else ""
	
	val warehouse = File("src/main/resources$extraPath/warehouse.txt")
		.readLines()
		.flatMapIndexed { rowIndex, row ->
			row.mapIndexed { colIndex, char ->
				val coordinate = Pair(rowIndex, colIndex)
				coordinate to char
			}
		}
		.toMap()
	
	
	val moves = File("src/main/resources$extraPath/moves.txt").readLines().map { it.toList() }.flatten()
	
	return warehouse to moves
}

fun getCurrentPosition(warehouse: Warehouse): Coordinate {
	return warehouse.filter { (_, value) -> value == CURRENT_POSITION }.keys.first()
}

fun removeCurrentPosition(warehouse: Warehouse, currentPosition: Coordinate): Warehouse {
	val mutableWarehouse = warehouse.toMutableMap()
	mutableWarehouse[currentPosition] = '.'
	return mutableWarehouse
}

fun printWarehouse(warehouse: Warehouse, curentPosition: Coordinate) {
	
	val mutableWarehouse = warehouse.toMutableMap()
	
	val size = sqrt(warehouse.size.toFloat()).toInt()
	var list = MutableList(size) {
		MutableList(size) {
			'.'
		}
	}
	
	mutableWarehouse[curentPosition] = CURRENT_POSITION
	mutableWarehouse.entries.forEach { (key, value) -> list[key.first][key.second] = value }
	
	list.forEach { lines ->
		lines.forEach(::print)
		println()
	}
	
	println()
	println()
}
