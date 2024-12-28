package common

fun typeOnNumericKeypad(inputs: List<String>): Map<String, String> {
	return inputs.associate { it to typeOnKeypad("A$it") }
}

private fun typeOnKeypad(input: String): String {
	return ((0 until input.lastIndex).fold("") { sequence, index ->
		val manipulation = input[index] to input[index + 1]
		sequence.plus(oneMovement(manipulation))
	})
}

private fun oneMovement(manipulation: Pair<Char, Char>): String {
	return when (manipulation) {
		
		// from A
		'A' to 'A' -> "A"
		'A' to '0' -> "<A"
		'A' to '1' -> "^<<A"
		'A' to '2' -> "^<A"
		'A' to '3' -> "^A"
		'A' to '4' -> "^^<<A"
		'A' to '5' -> "^^<A"
		'A' to '6' -> "^^A"
		'A' to '7' -> "^^^<<A"
		'A' to '8' -> "^^^<A"
		'A' to '9' -> "^^^A"
		
		// from 0
		'0' to 'A' -> ">A"
		'0' to '0' -> "A"
		'0' to '1' -> "^<A"
		'0' to '2' -> "^A"
		'0' to '3' -> "^>A"
		'0' to '4' -> "^^<A"
		'0' to '5' -> "^^A"
		'0' to '6' -> "^^>A"
		'0' to '7' -> "^^^<A"
		'0' to '8' -> "^^^A"
		'0' to '9' -> "^^^>A"
		
		// from 1
		'1' to 'A' -> ">>vA"
		'1' to '0' -> ">vA"
		'1' to '1' -> "A"
		'1' to '2' -> ">A"
		'1' to '3' -> ">>A"
		'1' to '4' -> "^A"
		'1' to '5' -> "^>A"
		'1' to '6' -> "^>>A"
		'1' to '7' -> "^^A"
		'1' to '8' -> "^^>A"
		'1' to '9' -> "^^>>A"
		
		// from 2
		'2' to 'A' -> ">vA"
		'2' to '0' -> "vA"
		'2' to '1' -> "<A"
		'2' to '2' -> "A"
		'2' to '3' -> ">A"
		'2' to '4' -> "^<A"
		'2' to '5' -> "^A"
		'2' to '6' -> "^>A"
		'2' to '7' -> "^^<A"
		'2' to '8' -> "^^A"
		'2' to '9' -> "^^>A"
		
		// from 3
		'3' to 'A' -> "v<A"
		'3' to '0' -> "vA"
		'3' to '1' -> "<<A"
		'3' to '2' -> "<A"
		'3' to '3' -> "A"
		'3' to '4' -> "^<<A"
		'3' to '5' -> "^<A"
		'3' to '6' -> "^A"
		'3' to '7' -> "^^<<A"
		'3' to '8' -> "^^<A"
		'3' to '9' -> "^^A"
		
		// from 4
		'4' to 'A' -> ">>vvA"
		'4' to '0' -> ">vvA"
		'4' to '1' -> "vA"
		'4' to '2' -> ">vA"
		'4' to '3' -> ">>vA"
		'4' to '4' -> "A"
		'4' to '5' -> ">A"
		'4' to '6' -> ">>A"
		'4' to '7' -> "^A"
		'4' to '8' -> "^>A"
		'4' to '9' -> "^>>A"
		
		// from 5
		'5' to 'A' -> ">vvA"
		'5' to '0' -> "vvA"
		'5' to '1' -> "v<A"
		'5' to '2' -> "vA"
		'5' to '3' -> "v>A"
		'5' to '4' -> "<A"
		'5' to '5' -> "A"
		'5' to '6' -> ">A"
		'5' to '7' -> "^<A"
		'5' to '8' -> "^A"
		'5' to '9' -> "^>A"
		
		// from 6
		'6' to 'A' -> "vvA"
		'6' to '0' -> "vv<A"
		'6' to '1' -> "v<<A"
		'6' to '2' -> "v<A"
		'6' to '3' -> "vA"
		'6' to '4' -> "<<A"
		'6' to '5' -> "<A"
		'6' to '6' -> "A"
		'6' to '7' -> "^<<A"
		'6' to '8' -> "^<A"
		'6' to '9' -> "^A"
		
		// from 7
		'7' to 'A' -> ">>vvvA"
		'7' to '0' -> ">vvvA"
		'7' to '1' -> "vvA"
		'7' to '2' -> "vv>A"
		'7' to '3' -> "vv>>A"
		'7' to '4' -> "vA"
		'7' to '5' -> "v>A"
		'7' to '6' -> "v>>A"
		'7' to '7' -> "A"
		'7' to '8' -> ">A"
		'7' to '9' -> ">>A"
		
		// from 8
		'8' to 'A' -> ">vvvA"
		'8' to '0' -> "vvv>A"
		'8' to '1' -> "vv<A"
		'8' to '2' -> "vvA"
		'8' to '3' -> "vv>A"
		'8' to '4' -> "v<A"
		'8' to '5' -> "vA"
		'8' to '6' -> "v>A"
		'8' to '7' -> "<A"
		'8' to '8' -> "A"
		'8' to '9' -> ">A"
		
		// from 9
		'9' to 'A' -> "vvvA"
		'9' to '0' -> "vvv<A"
		'9' to '1' -> "vv<<A"
		'9' to '2' -> "vv<A"
		'9' to '3' -> "vvA"
		'9' to '4' -> "v<<A"
		'9' to '5' -> "v<A"
		'9' to '6' -> "vA"
		'9' to '7' -> "<<A"
		'9' to '8' -> "<A"
		'9' to '9' -> "A"
		
		else -> throw Exception("Manipulation $manipulation is not supported")
	}
}
