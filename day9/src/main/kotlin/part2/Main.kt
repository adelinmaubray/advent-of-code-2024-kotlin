package part2

import common.computeChecksum
import common.getDiskMap
import common.getDiskMapRepresentation

// Almost there but not the correct result
fun main() {
	
	// Get the diskmap
	val diskMap = getDiskMap("example.txt")
//	val diskMap = getDiskMap("puzzle_input.txt")
	
	// Compute the file ID and empty spaces
	val representationWithEmptySpace = getDiskMapRepresentation(diskMap)
//	println(representationWithEmptySpace.map { it.first }.joinToString(""))
//	println(representationWithEmptySpace.map { it.second }.joinToString("."))
	
	// Move file to suitable empty space
	val compressMapDisk = moveFiles(representationWithEmptySpace)
//	println(compressMapDisk.map { it.first }.joinToString(""))
//	println(compressMapDisk.map { it.second }.joinToString("."))
	
	// Compute the checksum
	val checksum = computeChecksum(compressMapDisk)
	println(checksum)
	
	// got 6273752818414
}
