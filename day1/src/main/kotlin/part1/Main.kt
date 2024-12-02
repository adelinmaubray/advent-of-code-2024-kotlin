package part1

import common.Lists
import common.list1
import common.list2

fun main(args: Array<String>) {
	
	// Get the inputs
//	val lists = common.Lists.create(common.exampleList1, common.exampleList2)
	val lists = Lists.create(list1, list2)
	
	// Sort the list in order to properly compare them
	val sortedList = orderLists(lists)
	
	// Compute the distance
	val distance = computeDistance(sortedList)
	
	print(distance)
}
