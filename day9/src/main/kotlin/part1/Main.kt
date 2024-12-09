package part1

import common.computeChecksum
import common.getDiskMap
import common.getDiskMapRepresentation

fun main() {
	
	// Get the diskmap
//	val diskMap = getDiskMap("example.txt")
	val diskMap = getDiskMap("puzzle_input.txt")
	
	// Compute the file ID and empty spaces
	val representationWithEmptySpace = getDiskMapRepresentation(diskMap)
//	println(representationWithEmptySpace.map { it.first }.joinToString(""))
//	println(representationWithEmptySpace.map { it.second }.joinToString(""))
	
	// Move empty space to the end of the disk map
	val compressMapDisk = removeEmptySpaces(representationWithEmptySpace)
//	println(compressMapDisk.map { it.first }.joinToString(""))
//	println(compressMapDisk.map { it.second }.joinToString(""))
	
	// Compute the checksum
	val checksum = computeChecksum(compressMapDisk)
	println(checksum)
}