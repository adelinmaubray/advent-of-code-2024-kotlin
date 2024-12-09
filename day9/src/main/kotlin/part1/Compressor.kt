package part1

import java.util.*

fun removeEmptySpaces(mapDiskWithEmptySpace: List<Pair<Char, Int>>): List<Pair<Int, Int>> {
	
	val mutableMapDiskWithEmptySpace = mapDiskWithEmptySpace.toMutableList()
	val compressedMapDisk = mutableListOf<Pair<Int, Int>>()
	
	run compress@{
		mapDiskWithEmptySpace.forEachIndexed { index, _ ->
			
			if (onlyEmptySpaceLeft(index, mutableMapDiskWithEmptySpace)) {
				return@compress
			}
			
			val currentChar = mutableMapDiskWithEmptySpace[index].first
			val currentId = mutableMapDiskWithEmptySpace[index].second
			
			if (currentChar != '.') {
				compressedMapDisk.add(currentChar.digitToInt() to currentId)
			} else {
				val charToInsert = mutableMapDiskWithEmptySpace.last { it.first != '.' }
				val indexToRemove = mutableMapDiskWithEmptySpace.lastIndexOf(charToInsert)
				Collections.swap(mutableMapDiskWithEmptySpace, index, indexToRemove)
				compressedMapDisk.add(charToInsert.first.digitToInt() to charToInsert.second)
			}
		}
	}
	
	return compressedMapDisk
}

fun onlyEmptySpaceLeft(index: Int, currentList: List<Pair<Char, Int>>): Boolean {
	return currentList.subList(index, currentList.lastIndex).all { it.first == '.' }
}
