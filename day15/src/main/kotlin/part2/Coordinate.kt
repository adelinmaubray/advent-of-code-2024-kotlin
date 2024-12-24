package part2

data class Coordinate(val x: Int, val y: Int)

typealias Warehouse = Map<Coordinate, Char>
typealias Moves = List<Char>
