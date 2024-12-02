package part1

import common.Lists

fun orderLists(inputs: Lists): Lists {
	return Lists.create(
		list1 = orderList(inputs.leftList),
		list2 = orderList(inputs.rightList)
	)
}

fun orderList(list: List<Int>): List<Int> {
	return list.sorted()
}
