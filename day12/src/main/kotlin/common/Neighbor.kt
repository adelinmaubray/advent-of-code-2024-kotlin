package common


enum class Neighbor(val coordinate: Coordinate) {
	UP(Coordinate(0, -1)),
	DOWN(Coordinate(0, 1)),
	RIGHT(Coordinate(1, 0)),
	LEFT(Coordinate(-1, 0));
}

fun getNeighbors(coordinate: Coordinate): Set<Coordinate> {
	return Neighbor.entries.map { neighbour ->
		Coordinate(coordinate.x + neighbour.coordinate.x, coordinate.y + neighbour.coordinate.y)
	}.toSet()
}
