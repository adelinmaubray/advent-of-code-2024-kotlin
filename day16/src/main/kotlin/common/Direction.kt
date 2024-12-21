package common

import common.Direction.entries


enum class Direction(val point: Point) {
	UP(Point(0, -1)),
	DOWN(Point(0, 1)),
	RIGHT(Point(1, 0)),
	LEFT(Point(-1, 0));
	
	companion object {
		fun from(point: Point): Direction? = entries.find { it.point == point }
	}
}
