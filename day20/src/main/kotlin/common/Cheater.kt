package common

import kotlin.math.abs

fun computeSaveTimeForEachCheats(maze: List<Point>,
								 pathWithoutCheat: List<Point>,
								 size: Int): Map<Long, Long> {
	
	val timesSavedMap = mutableMapOf<Long, Long>()
	maze.forEach forEachWall@{ wallToRemove ->
		
		if (wallToRemove.x !in 1 until size || wallToRemove.y !in 1 until size) {
			return@forEachWall
		}
		
		val neighbours = wallNextToPath(wallToRemove, pathWithoutCheat)
		if (neighbours.size == 3) {
			timesSavedMap.incrementMap(2)
		}
		if (neighbours.size == 2) {
			val firstIndex = pathWithoutCheat.indexOf(neighbours.elementAt(0))
			val lastIndex = pathWithoutCheat.indexOf(neighbours.elementAt(1))
			val difference = (abs(firstIndex - lastIndex) - 2).toLong()
			timesSavedMap.incrementMap(difference)
		}
	}
	return timesSavedMap
}

fun wallNextToPath(wallToRemove: Point, pathWithoutCheat: List<Point>): Set<Point> {
	val neighbours = listOf(
		Point(wallToRemove.x + 1, wallToRemove.y),
		Point(wallToRemove.x - 1, wallToRemove.y),
		Point(wallToRemove.x, wallToRemove.y + 1),
		Point(wallToRemove.x, wallToRemove.y - 1),
	)
	
	return neighbours.intersect(pathWithoutCheat)
}

private fun MutableMap<Long, Long>.incrementMap(keyToIncrement: Long) {
	if (keyToIncrement != 0L) this[keyToIncrement] = this.getOrDefault(keyToIncrement, 0) + 1
}
