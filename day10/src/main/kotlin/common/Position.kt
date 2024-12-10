package common

fun computeNextPositions(currentPosition: Pair<Int, Int>, hikingMap: List<List<Int>>): List<Pair<Int, Int>> {
	
	val nextPositions = mutableListOf<Pair<Int, Int>>()
	val nextAltitude = hikingMap[currentPosition.first][currentPosition.second] + 1
	
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
	
	return nextPositions
}
