package part2

import common.computeNextPositions

fun computeScores(heads: List<Pair<Int, Int>>, hikingMap: List<List<Int>>): List<Int> {
	
	return heads.map { head ->
		getNextPositions(head, hikingMap)
	}
}

private fun getNextPositions(currentPosition: Pair<Int, Int>, hikingMap: List<List<Int>>): Int {
	var score = 0
	computeNextPositions(currentPosition, hikingMap).forEach { newPosition ->
		if (hikingMap[newPosition.first][newPosition.second] == 9) {
			score++
		} else {
			score += getNextPositions(newPosition, hikingMap)
		}
	}
	return score
}
