package common

typealias Region = Set<Coordinate>

// Disjoint Set class
class UnionFind(size: Int) {
	
	/**
	 * Array that stores the parent of each element
	 * At the beginning, each element is its own parent
	 */
	private val parent = IntArray(size) { it }
	
	/**
	 * Array that stores the rank of each subtree
	 * Maintain the balance of the tree during unions
	 **/
	private val rank = IntArray(size)
	
	/**
	 * Find the root of a group
	 * Use compression for optimization
	 */
	fun find(x: Int): Int {
		if (parent[x] != x) {
			// If the element is not the root, then attached the element to the root
			parent[x] = find(parent[x])
		}
		return parent[x]
	}
	
	/**
	 * Merge two groups
	 */
	fun union(x: Int, y: Int) {
		// Find the root of x
		val rootX = find(x)
		// Find the root of y
		val rootY = find(y)
		
		// Union by rank
		// Attach lower rank tree to higher rank tree
		when {
			rank[rootX] < rank[rootY] -> parent[rootX] = rootY
			rank[rootX] > rank[rootY] -> parent[rootY] = rootX
			else -> {
				// If the rank are equal, arbitrary choose x as parent
				parent[rootY] = rootX
				rank[rootX]++
			}
		}
	}
}
