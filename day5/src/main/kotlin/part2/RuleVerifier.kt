package part2

import common.PrintInput
import java.util.*

fun applyRulesForIncorrectUpdate(input: PrintInput): List<List<Int>> {
	
	val orders = input.orders
	val updatesFixed = mutableListOf<List<Int>>()
	
	input.updates.forEach { updateToCheck ->
		val filteredOrders = filterUpdateContainsOrder(updateToCheck, orders)
		if (isWrongOrder(updateToCheck, filteredOrders)) {
			val fixedUpdate = fixOrderOfWrongUpdates(updateToCheck, filteredOrders)
			updatesFixed.add(fixedUpdate)
		}
	}
	
	return updatesFixed
}

fun filterUpdateContainsOrder(update: List<Int>, orders: List<Pair<Int, Int>>): List<Pair<Int, Int>> {
	return orders.filter { update.contains(it.first) && update.contains(it.second) }
}

fun isWrongOrder(update: List<Int>, orders: List<Pair<Int, Int>>): Boolean {
	orders.forEach {
		val firstIndex = update.indexOf(it.first)
		val secondIndex = update.indexOf(it.second)
		if (firstIndex > secondIndex) return true
	}
	return false
}

fun fixOrderOfWrongUpdates(wrongUpdates: List<Int>, orders: List<Pair<Int, Int>>): List<Int> {
	
	var res = wrongUpdates.toMutableList()
	
	do {
		orders.forEach {
			val firstIndex = res.indexOf(it.first)
			val secondIndex = res.indexOf(it.second)
			if (firstIndex > secondIndex) {
				Collections.swap(res, firstIndex, secondIndex)
			}
		}
	} while (isWrongOrder(res, orders))
	
	return res
}
