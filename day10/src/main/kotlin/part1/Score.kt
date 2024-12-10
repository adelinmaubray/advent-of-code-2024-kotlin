package part1

import common.computeNextPositions

fun computeScores(heads: List<Pair<Int, Int>>, hikingMap: List<List<Int>>): List<Int> {
	
	return heads.map { head ->
		getNextPositions(head, hikingMap).size
	}
}

private fun getNextPositions(currentPosition: Pair<Int, Int>, hikingMap: List<List<Int>>): List<Pair<Int, Int>> {
	
	val maxAltitudePoint = mutableSetOf<Pair<Int, Int>>()
	computeNextPositions(currentPosition, hikingMap).forEach { newPosition ->
		if (hikingMap[newPosition.first][newPosition.second] == 9) {
			maxAltitudePoint.add(newPosition)
		} else {
			maxAltitudePoint.addAll(getNextPositions(newPosition, hikingMap))
		}
	}
	return maxAltitudePoint.toList()
}
