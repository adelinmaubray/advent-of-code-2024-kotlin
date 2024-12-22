package part2

import common.Coordinate
import common.Region
import common.compareTo
import common.getNeighbors

fun computeCosts(garden: List<List<Char>>, regions: List<Region>): Long {
	return regions.sumOf { region ->
		computeCostForOneRegion(garden, region)
	}
}

fun computeCostForOneRegion(garden: List<List<Char>>, region: Region): Long {
	val area = region.size
	val perimeter = countGroupSides(garden, region)
	return area * perimeter
}

fun countGroupSides(garden: List<List<Char>>, region: Region): Long {
	
	val height = garden.size
	val width = garden[0].size
	var sides = 0L
	
	// On crée une grille de booléens pour marquer les côtés déjà comptés
	val visitedEdges = mutableSetOf<Pair<Coordinate, Coordinate>>()
	
	for (pos in region) {
		val neighbors = getNeighbors(pos)
		
		for (neighbor in neighbors) {
			// Si le voisin est hors grille ou n'appartient pas au groupe
			if (neighbor.x < 0 || neighbor.x >= height ||
				neighbor.y < 0 || neighbor.y >= width ||
				neighbor !in region
			) {
				
				// On crée une paire ordonnée pour représenter ce côté
				val edge = if (pos.compareTo(neighbor) < 0) pos to neighbor else neighbor to pos
				
				// Si on n'a pas encore compté ce côté
				if (edge !in visitedEdges) {
					sides++
					visitedEdges.add(edge)
				}
			}
		}
	}
	
	return sides
}
