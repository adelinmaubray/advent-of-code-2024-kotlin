package common

const val NUMBER_OF_SECONDS = 100

fun moveRobots(initialRobotPosition: List<RobotInformation>): List<RobotInformation> {
	
	var robots = initialRobotPosition
	(1..NUMBER_OF_SECONDS).forEach { second ->
		robots.forEach { robot ->
			robot.position = computeRobotNewPosition(robot)
		}
	}
	return robots
}

fun computeRobotNewPosition(robot: RobotInformation): Coordinate {
	
	var x = robot.position.first + robot.velocity.first
	if (x >= getBathroomWidth()) x = x - getBathroomWidth()
	if (x < 0) x = x + getBathroomWidth()
	
	var y = robot.position.second + robot.velocity.second
	if (y >= getBathroomHeight()) y = y - getBathroomHeight()
	if (y < 0) y = y + getBathroomHeight()
	
	return Coordinate(x, y)
}
