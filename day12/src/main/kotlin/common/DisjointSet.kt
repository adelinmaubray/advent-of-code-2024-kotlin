package common

fun findRegions(garden: List<List<Char>>): List<Region> {
	
	// Initialization
	val height = garden.size
	val width = garden[0].size
	val uf = UnionFind(height * width)
	
	// Phase 1: Union constructions
	for (row in 0 until height) {
		for (col in 0 until width) {
			
			// From 2D to 1D
			val current = row * width + col
			
			// Check right cell
			if (col + 1 < width && garden[row][col] == garden[row][col + 1]) {
				uf.union(current, current + 1)
			}
			
			// Check lower cell
			if (row + 1 < height && garden[row][col] == garden[row + 1][col]) {
				uf.union(current, current + width)
			}
		}
	}
	
	// Phase 2: group construction
	// Map → key: the root | value: all points from the group
	val groups = mutableMapOf<Int, MutableSet<Coordinate>>()
	for (row in 0 until height) {
		for (col in 0 until width) {
			val current = row * width + col
			val root = uf.find(current)
			groups.getOrPut(root) { mutableSetOf() }.add(Coordinate(row, col))
		}
	}
	
	return groups.values.toList()
}
