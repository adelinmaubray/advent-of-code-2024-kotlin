package part1

import common.PrintInput

fun applyRules(input: PrintInput): List<List<Int>> {
	
	val orders = input.orders
	val updatesFiltered = mutableListOf<List<Int>>()
	
	input.updates.forEach { updateToCheck ->
		val filteredOrders = filterUpdateContainsOrder(updateToCheck, orders)
		if (checkUpdateInRightOrder(updateToCheck, filteredOrders))
			updatesFiltered.add(updateToCheck)
	}
	
	return updatesFiltered
}

fun filterUpdateContainsOrder(update: List<Int>, orders: List<Pair<Int, Int>>): List<Pair<Int, Int>> {
	return orders.filter { update.contains(it.first) && update.contains(it.second) }
}

fun checkUpdateInRightOrder(update: List<Int>, orders: List<Pair<Int, Int>>): Boolean {
	orders.forEach {
		val firstValue = update.indexOf(it.first)
		val secondValue = update.indexOf(it.second)
		if (firstValue > secondValue) return false
	}
	return true
}
