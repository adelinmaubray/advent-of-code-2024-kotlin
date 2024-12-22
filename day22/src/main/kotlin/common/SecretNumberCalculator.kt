package common

import java.io.File

fun getInitialSecretNumberForEachBuyer(path: String): List<Long> {
	return File("src/main/resources/$path").readLines().map { it.toLong() }
}

fun getSecretNumbersForOneBuyerAfterOneDay(initialSecretNumberValue: Long, numberOfSecretNumberPerDay: Int = 2000): List<SecretNumber> {
	
	val secretNumbers = mutableListOf<SecretNumber>()
	
	val initialSecretNumber = SecretNumber(value = initialSecretNumberValue)
	secretNumbers.add(initialSecretNumber)
	
	var currentSecretNumber = initialSecretNumber
	
	repeat(numberOfSecretNumberPerDay) {
		
		val newSecretNumberValue = computeNextSecretNumber(currentSecretNumber.value)
		val newSecretNumber = SecretNumber(value = newSecretNumberValue)
		newSecretNumber.change = newSecretNumber.price - currentSecretNumber.price
		
		secretNumbers.add(newSecretNumber)
		currentSecretNumber = newSecretNumber
	}
	return secretNumbers
}

private fun computeNextSecretNumber(currentSecretNumber: Long): Long {
	return step3(step2(step1(currentSecretNumber)))
}
