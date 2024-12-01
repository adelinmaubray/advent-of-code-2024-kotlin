package part1.utils

import Lists
import kotlin.math.abs

fun computeDistance(sortedLists: Lists): Int {
	
	var distance = 0
	sortedLists.leftList.forEachIndexed { index, list1Value ->
		
		val list2Value = sortedLists.rightList[index]
		distance += abs(list1Value - list2Value)
	}
	return distance
}
