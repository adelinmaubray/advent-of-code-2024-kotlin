package part2

import common.PrintInput
import common.examplesOrders
import common.examplesUpdates
import part1.computeSum

fun main() {
	
	val input = PrintInput(examplesUpdates, examplesOrders)
//	val input = PrintInput(extractUpdate(), extractOrders())
	
	// Check print rules
	val filteredPrinting = applyRulesForIncorrectUpdate(input)
	
	// Get the middle page number
	val res = computeSum(filteredPrinting)
	
	println(res)
}
