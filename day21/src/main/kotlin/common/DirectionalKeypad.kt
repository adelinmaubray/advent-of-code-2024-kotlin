package common

private val touches = mapOf(
	'.' to Coordinate(0, 0),
	'^' to Coordinate(1, 0),
	'A' to Coordinate(2, 0),
	'<' to Coordinate(0, 1),
	'v' to Coordinate(1, 1),
	'>' to Coordinate(2, 1)
)

fun typeOnDirectionalKeypad(inputs: Map<String, String>): Map<String, String> {
	return inputs.mapValues { typeOnKeypad("A${it.value}") }
}

private fun typeOnKeypad(input: String): String {
	return ((0 until input.lastIndex).fold("") { sequence, index ->
		val manipulation = input[index] to input[index + 1]
		sequence.plus(oneMovement(touches, manipulation))
	})
}
