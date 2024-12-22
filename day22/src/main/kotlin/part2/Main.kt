package part2

import common.getInitialSecretNumberForEachBuyer
import common.getSecretNumbersForOneBuyerAfterOneDay

fun main() {

//	val initialSecretNumbers = getInitialSecretNumberForEachBuyer("example_part2.txt")
	val initialSecretNumbers = getInitialSecretNumberForEachBuyer("puzzle_input.txt")
	
	val secretNumbersForAllBuyers = initialSecretNumbers.map { getSecretNumbersForOneBuyerAfterOneDay(it) }
	val bananas = getMaxBanana(secretNumbersForAllBuyers)
	
	println(bananas)
	
	// 2512 too high
	// 2378 too high
	
	// 2242 too low
}
