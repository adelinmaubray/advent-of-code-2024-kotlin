package common

import java.io.File

fun getInitialSecretNumberForEachBuyer(path: String): List<Long> {
	return File("src/main/resources/$path").readLines().map { it.toLong() }
}

fun getSecretNumbersForOneBuyerAfterOneDay(initialSecretNumber: Long, numberOfSecretNumberPerDay: Int = 2000): List<Long> {
	
	val secretNumbers = mutableListOf<Long>()
	var currentSecretNumber = initialSecretNumber
	repeat(numberOfSecretNumberPerDay) {
		currentSecretNumber = computeNextSecretNumber(currentSecretNumber)
		secretNumbers.add(currentSecretNumber)
	}
	return secretNumbers
}

private fun computeNextSecretNumber(currentSecretNumber: Long): Long {
	return step3(step2(step1(currentSecretNumber)))
}
