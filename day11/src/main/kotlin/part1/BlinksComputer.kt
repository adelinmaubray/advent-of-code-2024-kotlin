package part1

import common.computeNewStone

fun computeBlinks(initialStones: List<Int>): Int {
	
	var currentStones = initialStones.map { it.toLong() }
	var newStones = mutableListOf<Long>()
	
	val numberOfIterations = 25
	(1..numberOfIterations).forEach { _ ->
		
		currentStones.forEach { stone ->
			newStones.addAll(computeNewStone(stone))
		}
		
		currentStones = newStones
		newStones = mutableListOf()
	}
	return currentStones.size
}
