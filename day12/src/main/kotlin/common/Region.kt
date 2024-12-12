package common

fun getRegions(garden: List<Pair<Char, Coordinate>>): List<Set<Coordinate>> {
	
	val alreadyVisited = mutableSetOf<Coordinate>()
	val plantAreas = mutableListOf<Set<Coordinate>>()
	
	val allPlantTypes = findAllPlantsType(garden)
	println(allPlantTypes)
	
	val allAreas = findAreasForPlant(allPlantTypes.find { it == 'I' }!!, garden)
	plantAreas.addAll(splitAreaForPlantType(allAreas))

//	allPlantTypes.forEach { plantType ->
//		val allAreas = findAreasForPlant(plantType, garden)
//		plantAreas.addAll(splitAreaForPlantType(allAreas))
//	}
	
	return plantAreas
}

fun splitAreaForPlantType(allAreas: List<Coordinate>): List<Set<Coordinate>> {
	
	val groupedArea = listOf<Set<Coordinate>>()
	
	val alreadyVisited = mutableSetOf<Coordinate>()
	val currentPosition = allAreas.fi
	
	allAreas.forEach { area ->
	
	}
	
	return groupedArea
}

fun findAllPlantsType(garden: List<Pair<Char, Coordinate>>): Set<Char> {
	return garden.map { it.first }.toSet()
}

fun findAreasForPlant(plantType: Char, garden: List<Pair<Char, Coordinate>>): List<Coordinate> {
	return garden
		.filter { plant -> plant.first == plantType }
		.map { it.second }
}

//fun findArea(garden: List<List<Char>>, initialCoordinate: Coordinate): Pair<Set<Coordinate>, Set<Coordinate>> {
//
//	var currentCoordinate = initialCoordinate
//	val currentPlant = garden[initialCoordinate.x][initialCoordinate.y]
//
//	val newVisited = mutableSetOf<Coordinate>()
//	val foundArea = mutableSetOf<Coordinate>()
//
//	(initialCoordinate.x..garden.lastIndex).forEach { rowIndex ->
//		(initialCoordinate.y..garden[rowIndex].lastIndex).forEach colIteration@ { colIndex ->
//			if (garden[rowIndex][colIndex] == currentPlant) {
//				foundArea.add(Coordinate(rowIndex, colIndex))
//			} else {
//				return@colIteration
//			}
//		}
//	}
//
//	return newVisited to foundArea
//
//}
