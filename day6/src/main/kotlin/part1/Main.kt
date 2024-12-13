package part1

import common.*

fun main() {
	
	// Parse Input
//	val mazeWithSituation = parseMaze("example_input.txt")
	val mazeWithSituation = parseMaze("input.txt")
	
	// Compute the current situation before moving
	var currentSituation = Situation(Direction.UP, getCurrentPosition(mazeWithSituation))
	val maze = maskCurrentPosition(mazeWithSituation, currentSituation)
	
	// Use set to avoid cell duplication
	val visitedCells = mutableSetOf(currentSituation.position)
	do {
		visitedCells.add(currentSituation.position)
		// One move is either a movement or a direction change
		currentSituation = makeAMove(maze, currentSituation)
	} while (isInsideTheMaze(maze, currentSituation))
	
	println(visitedCells.size)
}
