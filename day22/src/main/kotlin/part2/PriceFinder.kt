package part2

import common.SecretNumber

fun getMaxBanana(secretNumbers: List<List<SecretNumber>>): Long {
	
	val sequencesCalculated = mutableMapOf<List<Int>, Long>()
	
	secretNumbers.forEachIndexed { i, secretNumbersForOneBuyer ->
		
		println("Compute for buyer $i")
		
		(1..secretNumbersForOneBuyer.lastIndex - 4).forEach eachSecretNumber@{ index ->
			
			val sequence = getSequence(index, secretNumbersForOneBuyer)
			
			if (sequencesCalculated.contains(sequence)) return@eachSecretNumber
			
			val numberOfBananas = getNumberOfBananasForSequence(sequence, secretNumbers)
			sequencesCalculated.put(sequence, numberOfBananas)
		}
	}
	return sequencesCalculated.values.max()
}

private fun getSequence(index: Int, secretNumbers: List<SecretNumber>): List<Int> {
	return (index.getRange()).map { secretNumbers[it].change }
}

private fun getNumberOfBananasForSequence(sequence: List<Int>, secretNumbers: List<List<SecretNumber>>): Long {
	
	return secretNumbers.fold(0L) forEachBuyer@{ sum, secretNumbersForOneBuyer ->
		(1..secretNumbersForOneBuyer.lastIndex - 3).forEach { index ->
			val sublist = secretNumbersForOneBuyer.slice(index.getRange()).map { it.change }
			if (sublist == sequence) {
				return@forEachBuyer sum + secretNumbersForOneBuyer[index.sequenceSize()].price
			}
		}
		return@forEachBuyer sum
	}
}

private fun Int.getRange(): IntRange = this..this.sequenceSize()
private fun Int.sequenceSize(): Int = this + 3
