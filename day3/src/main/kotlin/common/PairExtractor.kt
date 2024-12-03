package common

val dontOperations = Regex("""don't\(\).*?do\(\)""")
val pattern = Regex("""mul\((\d+),(\d+)\)""")

fun extractMultiplicatorPair(input: String, filtering: Boolean? = false): List<Pair<Int, Int>> {
	
	var instruction = input
	if (filtering == true)
		instruction = dontOperations.replace(input, "")
	
	return pattern.findAll(instruction).map { multiplication ->
		Pair(multiplication.groupValues[1].toInt(), multiplication.groupValues[2].toInt())
	}.toList()
}
