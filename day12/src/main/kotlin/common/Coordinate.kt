package common

data class Coordinate(val x: Int, val y: Int)

fun Coordinate.compareTo(other: Coordinate): Int {
	return when {
		this.x != other.x -> this.x - other.x
		else -> this.y - other.y
	}
}
