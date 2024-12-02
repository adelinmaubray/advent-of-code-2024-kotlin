package part2

import common.Lists
import common.list1
import common.list2

fun main() {
	// Get the inputs
//	val lists = common.Lists.create(common.exampleList1, common.exampleList2)
	val lists = Lists.create(list1, list2)
	
	// Compute the similarity score
	val similarityScore = computeSimilarityScore(lists)
	
	print(similarityScore)
}
