package part2

import common.computeNewStone

fun computeBlinks(initialStones: List<Long>): Map<Long, Long> {
	
	var stoneCounts = initialStones.groupingBy { it }.eachCount().mapValues { it.value.toLong() } // represent how many times a number is present
	
	repeat(75) {
		stoneCounts = processStoneMap(stoneCounts)
	}
	
	return stoneCounts
}

fun processStoneMap(stoneCounts: Map<Long, Long>): Map<Long, Long> {
	
	val newCounts = mutableMapOf<Long, Long>()
	stoneCounts.forEach { stone, count ->
		val newStones = computeNewStone(stone)
		newStones.forEach { newStone ->
			newCounts[newStone] = newCounts.getOrDefault(newStone, 0L) + count // increment the number of presence for the number
		}
	}
	return newCounts
}
