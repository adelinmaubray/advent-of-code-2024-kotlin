package part2

import common.PrintInput
import common.extractOrders
import common.extractUpdate
import part1.computeSum

fun main() {

//	val input = PrintInput(extractUpdate(true), extractOrders(true))
	val input = PrintInput(extractUpdate(), extractOrders())
	
	// Check print rules
	val filteredPrinting = applyRulesForIncorrectUpdate(input)
	
	// Get the middle page number
	val res = computeSum(filteredPrinting)
	
	println(res)
}
