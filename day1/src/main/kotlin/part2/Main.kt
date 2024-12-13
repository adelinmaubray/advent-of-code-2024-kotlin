package part2

import common.parseInput

fun main() {
	
	// Parse inputs
//	val lists = parseInput("example.txt")
	val lists = parseInput("puzzle_input.txt")
	
	// Compute the similarity score
	val similarityScore = computeSimilarityScore(lists)
	
	print(similarityScore)
}
