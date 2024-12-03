package common

fun computeMultiplication(multiplicatorPairs: List<Pair<Int, Int>>): Int {
	
	return multiplicatorPairs.fold(0) { acc, pair -> acc + pair.first * pair.second }
}
