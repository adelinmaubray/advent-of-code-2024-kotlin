package part1

import common.getInitialSecretNumberForEachBuyer
import common.getSecretNumbersForOneBuyerAfterOneDay

fun main() {

//	val initialSecretNumbers = getInitialSecretNumberForEachBuyer("example.txt")
	val initialSecretNumbers = getInitialSecretNumberForEachBuyer("puzzle_input.txt")
	val total = initialSecretNumbers.sumOf { getSecretNumbersForOneBuyerAfterOneDay(it).last() }
	println(total)

}
