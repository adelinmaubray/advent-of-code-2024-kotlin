package part2

import common.RobotInformation
import common.computeRobotNewPosition
import common.getBathroomHeight
import common.getBathroomWidth
import java.io.File

const val MAX_NUMBER_OF_SECONDS = 10000

fun moveRobots(initialRobotPosition: List<RobotInformation>): List<RobotInformation> {
	
	val tempFolder = File("target/prints")
	tempFolder.mkdirs()
	
	var robots = initialRobotPosition
	(1..MAX_NUMBER_OF_SECONDS).forEachIndexed { iteration, second ->
		robots.forEach { robot ->
			robot.position = computeRobotNewPosition(robot)
		}
		printRobots(robots, iteration, tempFolder)
	}
	return robots
}

fun printRobots(robots: List<RobotInformation>, iteration: Int, tempFolder: File) {
	
	val listToPrint = MutableList(getBathroomWidth()) {
		MutableList(getBathroomHeight()) {
			'.'
		}
	}
	
	robots.forEach { (position, _) -> listToPrint[position.first][position.second] = '#' }
	
	val fileToWrite = File(tempFolder, "$iteration.txt")
	fileToWrite.createNewFile()
	
	listToPrint.forEach { row ->
		row.forEach { char ->
			fileToWrite.appendText(char.toString())
		}
		fileToWrite.appendText("\n")
	}
	
	println("${fileToWrite.path} written")
}
