package part2

import common.Situation
import common.isInsideTheMaze
import common.makeAMove

fun placeObstacles(initialSituation: Situation, maze: List<List<Char>>): Int {
	
	var possibleObstacles = 0
	
	maze.forEachIndexed { rowIndex, row ->
		row.forEachIndexed colGoThrough@{ colIndex, _ ->
			
			println("$rowIndex $colIndex")
			
			if (maze[rowIndex][colIndex] == '#') return@colGoThrough
			
			val mazeWithObstacles = addObstacle(maze, rowIndex, colIndex)
			var currentSituation = initialSituation
			
			var move = 0 // stop guard, better solution ? // TODO like part 1, memorize the visited cell but WITH the direction
			
			do {
				// One move is either a movement or a direction change
				currentSituation = makeAMove(mazeWithObstacles, currentSituation)
				move++
				
				if (currentSituation == initialSituation || move > maze.size * 100) { // arbitrary number
					possibleObstacles++
					return@colGoThrough
				}
			} while (isInsideTheMaze(maze, currentSituation))
		}
	}
	
	return possibleObstacles
}

fun addObstacle(maze: List<List<Char>>, originalRowIndex: Int, originalColIndex: Int): List<List<Char>> {
	
	val mazeWithObstacles = MutableList<MutableList<Char>>(maze.size) {
		MutableList<Char>(maze.size) {
			' '
		}
	}
	
	maze.forEachIndexed { rowIndex, row ->
		row.forEachIndexed { colIndex, _ ->
			if (rowIndex == originalRowIndex && colIndex == originalColIndex) {
				mazeWithObstacles[rowIndex][colIndex] = '#'
			} else {
				mazeWithObstacles[rowIndex][colIndex] = maze[rowIndex][colIndex]
			}
		}
	}
	
	return mazeWithObstacles
}
