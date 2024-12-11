package common

fun computeNewStone(stone: Long): List<Long> {
	return if (stone == 0L) computeZeroStone()
	else if (stone.toString().length % 2 == 0) computeEventStone(stone)
	else computeOtherStone(stone)
}

fun computeZeroStone(): List<Long> {
	return listOf(1)
}

fun computeEventStone(stone: Long): List<Long> {
	val stoneValue = stone.toString()
	val firstStone = stoneValue.slice(0 until stoneValue.length / 2)
	val secondStone = stoneValue.slice(stoneValue.length / 2 until stoneValue.length)
	return listOf(firstStone, secondStone).map { it.toLong() }
}

fun computeOtherStone(stone: Long): List<Long> {
	return listOf(stone * 2024)
}




