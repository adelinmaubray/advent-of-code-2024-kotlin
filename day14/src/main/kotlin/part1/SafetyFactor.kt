package part1

import common.RobotInformation
import common.getBathroomHeight
import common.getBathroomWidth

fun computeSafetyFactor(robots: List<RobotInformation>): Int {
	
	val widthLowerLimit = (getBathroomWidth() / 2 - 1)
	val widthUpperLimit = (widthLowerLimit + 2)
	
	val heightLowerLimit = (getBathroomHeight() / 2 - 1)
	val heightUpperLimit = (heightLowerLimit + 2)
	
	val quadrants = listOf(
		0..widthLowerLimit to 0..heightLowerLimit,
		widthUpperLimit..getBathroomWidth() - 1 to 0..heightLowerLimit,
		0..widthLowerLimit to heightUpperLimit..getBathroomHeight() - 1,
		widthUpperLimit..getBathroomWidth() - 1 to heightUpperLimit..getBathroomHeight() - 1
	)
	
	return quadrants.fold(1) { factor, (xRange, yRange) ->
		factor * robots.count { (robotPosition, _) -> robotPosition.first in xRange && robotPosition.second in yRange }
	}
}
