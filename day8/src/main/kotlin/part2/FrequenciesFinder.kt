package part2

fun foundFrequencies(areaMap: List<List<Char>>): Set<Char> {
	val allFrequencies = areaMap.flatten().filterNot { it == '.' }
	return allFrequencies.filter { frequency ->
		allFrequencies.count { it == frequency } > 1
	}.toSet()
}
