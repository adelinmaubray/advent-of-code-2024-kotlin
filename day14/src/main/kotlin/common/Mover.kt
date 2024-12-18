package common

fun computeRobotNewPosition(robot: RobotInformation): Coordinate {
	
	var x = robot.position.first + robot.velocity.first
	if (x >= getBathroomWidth()) x = x - getBathroomWidth()
	if (x < 0) x = x + getBathroomWidth()
	
	var y = robot.position.second + robot.velocity.second
	if (y >= getBathroomHeight()) y = y - getBathroomHeight()
	if (y < 0) y = y + getBathroomHeight()
	
	return Coordinate(x, y)
}
