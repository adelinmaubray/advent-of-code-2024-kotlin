package common

fun typeOnDirectionalKeypad(inputs: Map<String, String>): Map<String, String> {
	return inputs.mapValues { typeOnKeypad("A${it.value}") }
}

private fun typeOnKeypad(input: String): String {
	return ((0 until input.lastIndex).fold("") { sequence, index ->
		val manipulation = input[index] to input[index + 1]
		sequence.plus(oneMovement(manipulation))
	})
}

private fun oneMovement(manipulation: Pair<Char, Char>): String {
	return when (manipulation) {
		
		// from ^
		'^' to '^' -> "A"
		'^' to 'A' -> ">A"
		'^' to '<' -> "v<A"
		'^' to 'v' -> "vA"
		'^' to '>' -> "v>A"
		
		// from A
		'A' to '^' -> "<A"
		'A' to 'A' -> "A"
		'A' to '<' -> "v<<A"
		'A' to 'v' -> "v<A"
		'A' to '>' -> "vA"
		
		// from <
		'<' to '^' -> ">^A"
		'<' to 'A' -> ">>^A"
		'<' to '<' -> "A"
		'<' to 'v' -> ">A"
		'<' to '>' -> ">>A"
		
		// from v
		'v' to '^' -> "^A"
		'v' to 'A' -> "^>A"
		'v' to '<' -> "<A"
		'v' to 'v' -> "A"
		'v' to '>' -> ">A"
		
		// from >
		'>' to '^' -> "^<A"
		'>' to 'A' -> "^A"
		'>' to '<' -> "<<A"
		'>' to 'v' -> "<A"
		'>' to '>' -> "A"
		
		else -> throw Exception("Manipulation $manipulation is not supported")
	}
}
