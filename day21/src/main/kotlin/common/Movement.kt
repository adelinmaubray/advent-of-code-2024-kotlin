package common

import kotlin.math.abs

fun oneMovement(touches: Map<Char, Coordinate>, movement: Pair<Char, Char>): String {
	
	val coordinate1 = touches[movement.first] ?: throw Exception("Touch ${movement.first} does not exists")
	val coordinate2 = touches[movement.second] ?: throw Exception("Touch ${movement.second} does not exists")
	
	val sequence = mutableListOf<Char>()
	
	sequence.addAll(tryPath(coordinate1, coordinate2, touches))
	if (sequence.contains('.')) {
		sequence.clear()
		println("Path error")
		sequence.addAll(tryPath(coordinate1, coordinate2, touches, false))
	}
	
	sequence.add('A')
	return sequence.joinToString("")
}

fun tryPath(coordinate1: Coordinate, coordinate2: Coordinate, touches: Map<Char, Coordinate>, xFirst: Boolean = true): List<Char> {
	
	val sequence = mutableListOf<Char>()
	
	val xGap = coordinate2.x - coordinate1.x
	val yGap = coordinate2.y - coordinate1.y
	if (xFirst) {
		sequence.addAll(addX(xGap, coordinate1, touches))
		sequence.addAll(addY(yGap, Coordinate(coordinate2.x, coordinate1.y), touches))
	} else {
		sequence.addAll(addY(yGap, coordinate1, touches))
		sequence.addAll(addX(xGap, Coordinate(coordinate1.x, coordinate2.y), touches))
	}
	return sequence
}

private fun addX(xGap: Int, initialCoordinate: Coordinate, touches: Map<Char, Coordinate>): List<Char> {
	val sequence = mutableListOf<Char>()
	var coordinateToCheck = initialCoordinate
	when {
		xGap < 0 -> repeat(abs(xGap)) {
			coordinateToCheck = Coordinate(coordinateToCheck.x - 1, coordinateToCheck.y)
			if (touches.entries.find { it.value == coordinateToCheck }?.key == '.') sequence.add('.')
			sequence.add('<')
		}
		
		xGap > 0 -> repeat(xGap) {
			coordinateToCheck = Coordinate(coordinateToCheck.x + 1, coordinateToCheck.y)
			if (touches.entries.find { it.value == coordinateToCheck }?.key == '.') sequence.add('.')
			sequence.add('>')
		}
	}
	return sequence
}

private fun addY(yGap: Int, initialCoordinate: Coordinate, touches: Map<Char, Coordinate>): List<Char> {
	val sequence = mutableListOf<Char>()
	var coordinateToCheck = initialCoordinate
	when {
		yGap < 0 -> repeat(abs(yGap)) {
			coordinateToCheck = Coordinate(coordinateToCheck.x, coordinateToCheck.y - 1)
			if (touches.entries.find { it.value == coordinateToCheck }?.key == '.') sequence.add('.')
			sequence.add('^')
		}
		
		yGap > 0 -> repeat(yGap) {
			coordinateToCheck = Coordinate(coordinateToCheck.x, coordinateToCheck.y + 1)
			if (touches.entries.find { it.value == coordinateToCheck }?.key == '.') sequence.add('.')
			sequence.add('v')
		}
	}
	return sequence
}
