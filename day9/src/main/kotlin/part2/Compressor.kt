package part2

import java.util.*

fun moveFiles(mapDiskWithEmptySpace: List<Pair<Char, Int>>): List<Pair<Int, Int>> {
	
	println(mapDiskWithEmptySpace.map { it.first }.joinToString(""))
	
	var listWithModification = mapDiskWithEmptySpace
	
	// Go through the list backward
	var index = mapDiskWithEmptySpace.lastIndex
	do {
		
		// From last index, get all the same file
		val numberOfSameElement = getNumberOfIdenticalElements(listWithModification, index)
		if (numberOfSameElement == null) {
			index--
			continue
		}
		
		// find the first index with at least the needed space
		val firstIndexOfSuitableEmptySpace = findSuitableEmptySpace(listWithModification, numberOfSameElement)
		
		if (firstIndexOfSuitableEmptySpace != null && firstIndexOfSuitableEmptySpace < index) {
			listWithModification = swapDataAndEmptySpaces(listWithModification, index, firstIndexOfSuitableEmptySpace, numberOfSameElement)
		}
		
		index = index - numberOfSameElement
	} while (index > 0)
	
	println(listWithModification.map { it.first }.joinToString(""))
	
	return listWithModification.map { pair ->
		if (pair.first == '.') 0 to pair.second else pair.first.digitToInt() to pair.second
	}
}

fun getNumberOfIdenticalElements(currentList: List<Pair<Char, Int>>, index: Int): Int? {
	
	val currentElement = currentList[index]
	
	if (currentElement.first == '.') return null
	
	var reversedIndex = index
	var numberOfElements = 0
	
	do {
		numberOfElements++
		reversedIndex--
	} while (reversedIndex >= 0 && currentElement == currentList[reversedIndex])
	
	return numberOfElements
}

fun findSuitableEmptySpace(mapDisk: List<Pair<Char, Int>>, spaceNeeded: Int): Int? {
	
	var spaceFound = 0
	mapDisk.map { it.first }.forEachIndexed { index, char ->
		spaceFound = if (char == '.') spaceFound.inc() else 0
		if (spaceFound == spaceNeeded) return index - spaceNeeded + 1
	}
	return null
}

fun swapDataAndEmptySpaces(diskMap: List<Pair<Char, Int>>,
						   currentIndex: Int,
						   firstIndexOfSuitableEmptySpace: Int,
						   numberOfElements: Int): List<Pair<Char, Int>> {
	val mutableList = diskMap.toMutableList()
	for (i in 0 until numberOfElements) {
		Collections.swap(mutableList, firstIndexOfSuitableEmptySpace + i, currentIndex - i)
	}
	return mutableList
}
