package part1

import Lists
import list1
import list2
import part1.utils.computeDistance
import part1.utils.orderLists

fun main(args: Array<String>) {
	
	// Get the inputs
//	val lists = Lists.create(exampleList1, exampleList2)
	val lists = Lists.create(list1, list2)
	
	// Sort the list in order to properly compare them
	val sortedList = orderLists(lists)
	
	// Compute the distance
	val distance = computeDistance(sortedList)
	
	print(distance)
}
