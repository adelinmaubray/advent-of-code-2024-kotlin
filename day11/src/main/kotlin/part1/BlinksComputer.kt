package part1

import common.computeNewStone

fun computeBlinks(initialStones: List<Long>): Int {
	
	var currentStones = initialStones.map { it.toLong() }
	
	repeat(25) {
		val newStones = mutableListOf<Long>()
		currentStones.forEach { stone ->
			newStones.addAll(computeNewStone(stone))
		}
		
		currentStones = newStones
	}
	return currentStones.size
}
