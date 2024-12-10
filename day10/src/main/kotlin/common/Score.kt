package common

fun computeScores(heads: List<Pair<Int, Int>>, hikingMap: List<List<Int>>): List<Int> {
	
	return heads.map { head ->
		getNextPositions(head, hikingMap).size
	}
}

private fun getNextPositions(currentPosition: Pair<Int, Int>, hikingMap: List<List<Int>>): List<Pair<Int, Int>> {
	
	val maxAltitudePoint = mutableSetOf<Pair<Int, Int>>()
	val nextAltitude = hikingMap[currentPosition.first][currentPosition.second] + 1
	val nextPositions = mutableListOf<Pair<Int, Int>>()
	
	// upper position
	try {
		if (hikingMap[currentPosition.first - 1][currentPosition.second] == nextAltitude) nextPositions.add(currentPosition.first - 1 to currentPosition.second)
	} catch (_: IndexOutOfBoundsException) {
	}
	
	
	// righter position
	try {
		if (hikingMap[currentPosition.first][currentPosition.second + 1] == nextAltitude) nextPositions.add(currentPosition.first to currentPosition.second + 1)
	} catch (_: IndexOutOfBoundsException) {
	}
	
	
	// downer position
	try {
		if (hikingMap[currentPosition.first + 1][currentPosition.second] == nextAltitude) nextPositions.add(currentPosition.first + 1 to currentPosition.second)
	} catch (_: IndexOutOfBoundsException) {
	}
	
	// lefter position
	try {
		if (hikingMap[currentPosition.first][currentPosition.second - 1] == nextAltitude) nextPositions.add(currentPosition.first to currentPosition.second - 1)
	} catch (_: IndexOutOfBoundsException) {
	}
	
	nextPositions.forEach { newPosition ->
		if (hikingMap[newPosition.first][newPosition.second] == 9) {
			maxAltitudePoint.add(newPosition)
		} else {
			maxAltitudePoint.addAll(getNextPositions(newPosition, hikingMap))
		}
	}
	
	return maxAltitudePoint.toList()
}
