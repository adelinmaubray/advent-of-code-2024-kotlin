package part1

import common.RobotInformation
import common.computeRobotNewPosition

const val NUMBER_OF_SECONDS = 100

fun moveRobots(initialRobotPosition: List<RobotInformation>): List<RobotInformation> {
	
	var robots = initialRobotPosition
	
	repeat(NUMBER_OF_SECONDS) {
		robots.forEach { robot ->
			robot.position = computeRobotNewPosition(robot)
		}
	}
	return robots
}
