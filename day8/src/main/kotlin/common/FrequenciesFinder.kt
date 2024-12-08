package common

fun foundFrequencies(areaMap: List<List<Char>>): Set<Char> {
	return areaMap.flatten().filterNot { it == '.' }.toSet()
}
