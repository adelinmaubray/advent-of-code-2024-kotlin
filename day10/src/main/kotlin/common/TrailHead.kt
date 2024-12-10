package common

fun getTrailHeads(hikingMap: List<List<Int>>): List<Pair<Int, Int>> {
	return hikingMap.flatMapIndexed { rowIndex, line ->
		line.mapIndexed { colIndex, cell -> if (cell == 0) rowIndex to colIndex else null }
	}.filterNotNull()
}
