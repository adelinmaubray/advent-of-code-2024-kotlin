package common

fun computeSum(inputs: Map<String, String>): Long {
	var sum = 0L
	inputs.forEach { (code, sequence) ->
		val numericPart = code.replace("""\D""".toRegex(), "").toLong()
		println(sequence.length to numericPart)
		sum += sequence.length * numericPart
		
	}
	return sum
}
