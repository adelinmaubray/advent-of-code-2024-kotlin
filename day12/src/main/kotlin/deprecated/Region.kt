package deprecated

import common.Coordinate
import common.Region
import common.getNeighbors

fun getRegions(garden: List<PlantInformation>): List<Region> {
	
	val regions = mutableListOf<Region>()
	val visited = mutableSetOf<PlantInformation>()
	
	garden.forEach regionCreation@{ plantToClass ->
		
		if (visited.contains(plantToClass)) return@regionCreation
		
		visited.add(plantToClass)
		
		val region = mutableSetOf<Coordinate>()
		region.add(plantToClass.coordinate)
		
		val plantType = plantToClass.plantType
		
		garden.forEach regionPopulation@{ plantToCheck ->
			
			if (visited.contains(plantToCheck)) return@regionPopulation
			if (plantType != plantToCheck.plantType) return@regionPopulation
			
			if ((getNeighbors(plantToCheck.coordinate) intersect region).isNotEmpty()) {
				visited.add(plantToCheck)
				region.add(plantToCheck.coordinate)
			}
		}
		
		regions.add(region)
	}
	
	return regions

//	return garden.flatMap { plantInformations ->
//		getAllRegionForPlantType(plantInformations)
//	}
}

private fun getAllRegionForPlantType(allPlants: List<Coordinate>): List<Region> {
	
	val regions = mutableListOf<Region>()
	val plantsToClass = allPlants.toMutableList()
	
	while (plantsToClass.isNotEmpty()) {
		
		val region = mutableSetOf<Coordinate>()
		
		region.add(plantsToClass[0])
		(1..plantsToClass.lastIndex).forEach { index ->
			val plantToClass = plantsToClass[index]
			if ((getNeighbors(plantToClass) intersect region).isNotEmpty()) {
				region.add(plantToClass)
			}
		}
		
		plantsToClass.removeAll(region)
		regions.add(region)
	}
	
	return regions
}
