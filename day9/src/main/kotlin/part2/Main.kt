package part2

import common.computeChecksum
import common.getDiskMap
import common.getDiskMapRepresentation

fun main() {
	
	// Get the diskmap
//	val diskMap = getDiskMap("example.txt")
	val diskMap = getDiskMap("puzzle_input.txt")
	
	// Compute the file ID and empty spaces
	val representationWithEmptySpace = getDiskMapRepresentation(diskMap)
	
	// Move file to suitable empty space
	val compressMapDisk = moveFiles(representationWithEmptySpace)
	
	// Compute the checksum
	val checksum = computeChecksum(compressMapDisk)
	println(checksum)
}
