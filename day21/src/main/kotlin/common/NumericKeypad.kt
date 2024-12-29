package common

private val touches = mapOf(
	'.' to Coordinate(0, 3),
	'A' to Coordinate(2, 3),
	'0' to Coordinate(1, 3),
	'1' to Coordinate(0, 2),
	'2' to Coordinate(1, 2),
	'3' to Coordinate(2, 2),
	'4' to Coordinate(0, 1),
	'5' to Coordinate(1, 1),
	'6' to Coordinate(2, 1),
	'7' to Coordinate(0, 0),
	'8' to Coordinate(1, 0),
	'9' to Coordinate(2, 0)
)

fun typeOnNumericKeypad(inputs: List<String>): Map<String, String> {
	return inputs.associate { it to typeOnKeypad("A$it") }
}

private fun typeOnKeypad(input: String): String {
	return ((0 until input.lastIndex).fold("") { sequence, index ->
		val manipulation = input[index] to input[index + 1]
		sequence.plus(oneMovement(touches, manipulation))
	})
}


