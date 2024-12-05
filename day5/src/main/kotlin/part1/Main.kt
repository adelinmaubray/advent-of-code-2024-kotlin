package part1

import common.PrintInput
import common.extractOrders
import common.extractUpdate

fun main() {
	
	// Get inputs
//	val input = PrintInput(examplesUpdates, examplesOrders)
	val input = PrintInput(extractUpdate(), extractOrders())
	
	// Check print rules
	val filteredPrinting = applyRules(input)
	
	// Get the middle page number
	val res = computeSum(filteredPrinting)
	
	println(res)
}


