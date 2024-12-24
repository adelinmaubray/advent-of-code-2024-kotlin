package help

data class Position(val x: Int, val y: Int)

typealias Warehouse = Map<Position, Char>
typealias Moves = List<Char>
