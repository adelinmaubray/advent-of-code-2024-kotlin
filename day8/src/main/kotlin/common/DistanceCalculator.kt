package common

fun computeDifference(antenna1: Pair<Int, Int>, antenna2: Pair<Int, Int>): Pair<Int, Int> {
	return antenna2.first - antenna1.first to antenna2.second - antenna1.second
}

fun northerAntiNode(antenna: Pair<Int, Int>, difference: Pair<Int, Int>): Pair<Int, Int> {
	return antenna.first - difference.first to antenna.second - difference.second
}

fun southernAntiNode(antenna: Pair<Int, Int>, difference: Pair<Int, Int>): Pair<Int, Int> {
	return antenna.first + difference.first to antenna.second + difference.second
}

fun isInBound(antiNode: Pair<Int, Int>, rowMaxSize: Int, colMaxSize: Int): Boolean {
	return antiNode.first in 0..rowMaxSize
		&& antiNode.second in 0..colMaxSize
}
