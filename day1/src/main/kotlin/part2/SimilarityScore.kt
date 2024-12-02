package part2

import Lists

fun computeSimilarityScore(input: Lists): Int {
	
	var score = 0
	input.leftList.forEach { leftListValue ->
		val numberOfOccurrence = input.rightList.count { it == leftListValue }
		score += leftListValue * numberOfOccurrence
	}
	return score
}
