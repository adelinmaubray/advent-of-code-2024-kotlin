package common

fun getAntennaLocation(frequency: Char, areaMap: List<List<Char>>): List<Pair<Int, Int>> {
	val frequencyLocations = mutableListOf<Pair<Int, Int>>()
	areaMap.forEachIndexed { rowIndex, row ->
		row.forEachIndexed { colIndex, location ->
			if (location == frequency) frequencyLocations.add(rowIndex to colIndex)
		}
	}
	return frequencyLocations
}
