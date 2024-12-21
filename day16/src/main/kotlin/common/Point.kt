package common

data class Point(val x: Int, val y: Int)

operator fun Point.minus(otherPoint: Point): Point = Point(x - otherPoint.x, y - otherPoint.y)

fun Point.directionTo(other: Point): Direction {
	return Direction.from(other - this) ?: throw Exception("Difference between $this and $other is not equal to a Direction")
}
