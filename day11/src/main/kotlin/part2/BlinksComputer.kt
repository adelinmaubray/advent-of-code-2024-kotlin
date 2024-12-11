package part2

import common.computeNewStone
import java.io.File

fun computeBlinks(initialStones: List<Int>, numberOfIterations: Int) {
	
	tempFolder.mkdirs()
	
	var currentFolder = File(tempFolder, "0")
	currentFolder.mkdir()
	writeToFile(currentFolder, 0, initialStones.map { it.toLong() })
	
	(1..numberOfIterations).forEach { stoneId ->
		
		var newFolder = File(tempFolder, stoneId.toString())
		newFolder.mkdir()
		
		var fileWritingIndex = 0L
		
		currentFolder.walkTopDown().forEachIndexed fileListing@{ fileIndex, stoneFile ->
			
			if (!stoneFile.path.endsWith(".txt")) return@fileListing
			
			val stonesForFile = getStones(stoneFile)
			
			val stoneToWrite = mutableListOf<Long>()
			stonesForFile.forEach { stone ->
				stoneToWrite.addAll(computeNewStone(stone.toLong()))
			}
			
			stoneToWrite.chunked(1000).forEach { chunk ->
				fileWritingIndex++
				writeToFile(newFolder, fileWritingIndex, chunk)
			}
		}
		
		currentFolder = newFolder
	}
}
