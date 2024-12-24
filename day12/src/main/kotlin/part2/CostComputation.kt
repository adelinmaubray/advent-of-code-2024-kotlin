package part2

import common.Coordinate
import common.Region

fun computeCosts(regions: List<Region>): Int {
	return regions.sumOf { region ->
		computeCostForOneRegion(region)
	}
}

fun computeCostForOneRegion(region: Region): Int {
	val area = region.size
	val perimeter = countGroupSides(region)
	return area * perimeter
}

// Function from claude-3.5-sonnet
fun countGroupSides(group: Set<Coordinate>): Int {
	
	// Split horizontal and vertical segments
	val horizontalSegments = mutableSetOf<Pair<Int, IntRange>>()
	val verticalSegments = mutableSetOf<Pair<IntRange, Int>>()
	
	group.forEach { slot ->
		// Upper side
		if (Coordinate(slot.x - 1, slot.y) !in group) {
			var startCol = slot.y
			while (startCol > 0 && Coordinate(slot.x, startCol - 1) in group &&
				Coordinate(slot.x - 1, startCol - 1) !in group
			) {
				startCol--
			}
			var endCol = slot.y
			while (Coordinate(slot.x, endCol + 1) in group &&
				Coordinate(slot.x - 1, endCol + 1) !in group
			) {
				endCol++
			}
			horizontalSegments.add(slot.x to startCol..endCol)
		}
		
		// Right side
		if (Coordinate(slot.x + 1, slot.y) !in group) {
			var startCol = slot.y
			while (startCol > 0 && Coordinate(slot.x, startCol - 1) in group &&
				Coordinate(slot.x + 1, startCol - 1) !in group
			) {
				startCol--
			}
			var endCol = slot.y
			while (Coordinate(slot.x, endCol + 1) in group &&
				Coordinate(slot.x + 1, endCol + 1) !in group
			) {
				endCol++
			}
			horizontalSegments.add((slot.x + 1) to startCol..endCol)
		}
		
		// Left side
		if (Coordinate(slot.x, slot.y - 1) !in group) {
			var startRow = slot.x
			while (startRow > 0 && Coordinate(startRow - 1, slot.y) in group &&
				Coordinate(startRow - 1, slot.y - 1) !in group
			) {
				startRow--
			}
			var endRow = slot.x
			while (Coordinate(endRow + 1, slot.y) in group &&
				Coordinate(endRow + 1, slot.y - 1) !in group
			) {
				endRow++
			}
			verticalSegments.add(startRow..endRow to slot.y)
		}
		
		// Lower side
		if (Coordinate(slot.x, slot.y + 1) !in group) {
			var startRow = slot.x
			while (startRow > 0 && Coordinate(startRow - 1, slot.y) in group &&
				Coordinate(startRow - 1, slot.y + 1) !in group
			) {
				startRow--
			}
			var endRow = slot.x
			while (Coordinate(endRow + 1, slot.y) in group &&
				Coordinate(endRow + 1, slot.y + 1) !in group
			) {
				endRow++
			}
			verticalSegments.add(startRow..endRow to (slot.y + 1))
		}
	}
	
	return horizontalSegments.size + verticalSegments.size
}
