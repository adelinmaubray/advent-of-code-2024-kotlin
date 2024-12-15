package common

import java.io.File

fun parseInput(isExample: Boolean = false): Pair<Warehouse, Moves> {
	
	val extraPath = if (isExample) "/example" else ""
	
	val warehouse = File("src/main/resources$extraPath/warehouse.txt")
		.readLines()
		.flatMapIndexed { rowIndex, row ->
			row.mapIndexed { colIndex, char ->
				val coordinate = Coordinate(rowIndex, colIndex)
				coordinate to char
			}
		}
		.toMap()
	
	
	val moves = File("src/main/resources$extraPath/moves.txt").readLines().map { it.toList() }.flatten()
	
	return warehouse to moves
}

fun getCurrentPosition(warehouse: Warehouse): Coordinate {
	return warehouse.filter { (_, value) -> value == '@' }.keys.first()
}

fun removeCurrentPosition(warehouse: Warehouse, currentPosition: Coordinate): Warehouse {
	val mutableWarehouse = warehouse.toMutableMap()
	mutableWarehouse[currentPosition] = '.'
	return mutableWarehouse
}
