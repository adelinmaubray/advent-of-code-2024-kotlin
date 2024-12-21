package common

data class PathState(val point: Point,
					 val score: Long = 0,
					 val visitedCells: List<Point> = listOf(point),
					 val direction: Direction = Direction.RIGHT)
