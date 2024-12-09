package common

fun getDiskMapRepresentation(diskMap: List<Int>): List<Pair<Char, Int>> {
	
	val diskMapRepresentation = mutableListOf<Pair<Char, Int>>()
	diskMap.forEachIndexed { index, currentDigit ->
		if (index % 2 == 0) {
			// This is a block file - its representation is the ID
			val representation = (index / 2) % 10
			val id = index / 2
			(1..currentDigit).forEach { _ -> diskMapRepresentation.add(representation.digitToChar() to id) }
		} else {
			// This is a free space - its representation is '.'
			(1..currentDigit).forEach { _ -> diskMapRepresentation.add('.' to 0) }
		}
	}
	return diskMapRepresentation
}
