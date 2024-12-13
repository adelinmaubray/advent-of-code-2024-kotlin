package part2

import common.*

fun main() {
	
	// Parse Input
//	val mazeWithSituation = parseMaze("example_input.txt")
	val mazeWithSituation = parseMaze("input.txt")
	
	// Compute the current situation before moving
	val initialSituation = Situation(Direction.UP, getCurrentPosition(mazeWithSituation))
	val maze = maskCurrentPosition(mazeWithSituation, initialSituation)
	
	// Compte the number of possibilities
	val numberOfWays = placeObstacles(initialSituation, maze)
	
	println(numberOfWays)
}
