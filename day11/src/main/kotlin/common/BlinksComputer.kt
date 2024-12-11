package common

fun computeBlinks(initialStones: List<Int>, numberOfIteration: Int = 25): Int {
	
	var currentStones = initialStones.map { it.toLong() }
	var newStones = mutableListOf<Long>()
	
	(1..numberOfIteration).forEach { _ ->
		
		currentStones.forEach { stone ->
			newStones.addAll(computeNewStone(stone))
		}
		
		currentStones = newStones
		newStones = mutableListOf()
	}
	return currentStones.size
}
