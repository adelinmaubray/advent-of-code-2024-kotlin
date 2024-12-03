package part1

val pattern = Regex("""mul\((\d+),(\d+)\)""")

fun extractMultiplicatorPair(input: String): List<Pair<Int, Int>> {
	return pattern.findAll(input).map { multiplication ->
		Pair(multiplication.groupValues[1].toInt(), multiplication.groupValues[2].toInt())
	}.toList()
}
