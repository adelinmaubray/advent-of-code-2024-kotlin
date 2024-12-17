package common

import java.io.File

val positionRegex = Regex("""p=(\d+),(\d+)\s""")
val velocityRegex = Regex("""v=(-?\d+),(-?\d+)""")

fun parseInput(path: String): List<RobotInformation> {
	return File("src/main/resources/$path").readLines().map { robot ->
		
		val positionMatcherValues = positionRegex.find(robot)!!.groupValues
		val position = Coordinate(positionMatcherValues[1].toInt(), positionMatcherValues[2].toInt())
		
		val velocityMatherValues = velocityRegex.find(robot)!!.groupValues
		val velocity = Coordinate(velocityMatherValues[1].toInt(), velocityMatherValues[2].toInt())
		
		RobotInformation(position, velocity)
	}
}
