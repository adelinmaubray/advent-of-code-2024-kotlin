package part2

import java.io.File

val tempFolder = File("target/temp")

fun getStones(file: File): List<Long> {
	return file.readLines()[0].split(" ").map { it.toLong() }
}

fun writeToFile(folder: File, fileNumber: Long, stones: List<Long>) {
	File(folder, "$fileNumber.txt").writeText(stones.joinToString(" "))
}

fun getNumberOfStones(numberOfIterations: Int): Long {
	return File(tempFolder, numberOfIterations.toString()).walk().fold(0L) { accumulator, file ->
		if (!file.path.endsWith(".txt")) accumulator
		else accumulator + file.readLines()[0].split(" ").size.toLong()
	}
}
