package part1

import common.Direction
import common.Situation

fun makeAMove(maze: List<List<Char>>, situation: Situation): Situation {
	
	// Move to one cell
	val currentPosition = situation.position
	val currentDirection = situation.direction
	
	val newPosition = when (currentDirection) {
		Direction.UP -> Pair(currentPosition.first - 1, currentPosition.second)
		Direction.RIGHT -> Pair(currentPosition.first, currentPosition.second + 1)
		Direction.DOWN -> Pair(currentPosition.first + 1, currentPosition.second)
		Direction.LEFT -> Pair(currentPosition.first, currentPosition.second - 1)
	}
	
	// Check if the new cell is an obstacle
	if (isObstacle(maze, situation.copy(position = newPosition))) {
		val newDirection = when (currentDirection) {
			Direction.UP -> Direction.RIGHT
			Direction.RIGHT -> Direction.DOWN
			Direction.DOWN -> Direction.LEFT
			Direction.LEFT -> Direction.UP
		}
		// Change the direction and not the position
		return Situation(newDirection, currentPosition)
	} else {
		// Change the direction and not the direction
		return Situation(currentDirection, newPosition)
	}
}

fun isObstacle(maze: List<List<Char>>, situation: Situation): Boolean {
	val (row, col) = situation.position
	return try {
		maze[row][col] == '#'
	} catch (_: Exception) {
		false
	}
}

fun isInsideTheMaze(maze: List<List<Char>>, currentSituation: Situation): Boolean {
	val mazeSize = Pair(maze.lastIndex, maze[0].lastIndex)
	val currentPosition = currentSituation.position
	return currentPosition.first <= mazeSize.first && currentPosition.second <= mazeSize.second
}
