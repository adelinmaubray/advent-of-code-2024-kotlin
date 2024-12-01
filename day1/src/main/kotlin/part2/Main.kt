package part2

import Lists
import list1
import list2
import part2.utils.computeSimilarityScore

fun main() {
	// Get the inputs
//	val lists = Lists.create(exampleList1, exampleList2)
	val lists = Lists.create(list1, list2)
	
	// Compute the similarity score
	val similarityScore = computeSimilarityScore(lists)
	
	print(similarityScore)
}
