package part1

import common.Region
import common.getNeighbors

fun computeCosts(regions: List<Region>): Long {
	return regions.sumOf { region ->
		computeCostForOneRegion(region)
	}
}

fun computeCostForOneRegion(region: Region): Long {
	val area = region.size
	val perimeter = region.fold(0L) { perimeter, plant ->
		perimeter + (4 - (getNeighbors(plant) intersect region).size)
	}
	return area * perimeter
}
