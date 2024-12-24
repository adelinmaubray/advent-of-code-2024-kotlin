import common.Direction
import help.Box
import help.Position

class GameMovement(internal var playerPosition: Position,
				   internal val boxes: MutableList<Box>,
				   internal val grid: MutableMap<Position, Char>) {
	
	fun move(direction: Direction): Boolean {
		return when (direction) {
			Direction.UP, Direction.DOWN -> moveVertical(direction)
			Direction.LEFT, Direction.RIGHT -> moveHorizontal(direction)
		}
	}
	
	private fun moveVertical(direction: Direction): Boolean {
		val deltaY = when (direction) {
			Direction.UP -> -1
			Direction.DOWN -> 1
			else -> throw IllegalArgumentException("Invalid vertical direction")
		}
		
		val newPosition = Position(playerPosition.x, playerPosition.y + deltaY)
		
		// Vérifier si la nouvelle position est libre
		if (isPositionFree(newPosition)) {
			playerPosition = newPosition
			return true
		}
		
		// Vérifier si on pousse une boîte
		val boxToPush = boxes.find { box ->
			newPosition == box.leftPos || newPosition == box.rightPos
		} ?: return false
		
		// Trouver toutes les boîtes empilées
		val stackedBoxes = findStackedBoxes(boxToPush, direction)
		
		// Vérifier si le mouvement est possible pour toutes les boîtes
		val canMove = stackedBoxes.all { box ->
			val newLeftPos = Position(box.leftPos.x, box.leftPos.y + deltaY)
			val newRightPos = Position(box.rightPos.x, box.rightPos.y + deltaY)
			
			isPositionFree(newLeftPos, excludedBoxes = stackedBoxes) &&
				isPositionFree(newRightPos, excludedBoxes = stackedBoxes)
		}
		
		if (canMove) {
			// Déplacer toutes les boîtes
			moveBoxes(stackedBoxes, deltaY = deltaY)
			playerPosition = newPosition
			return true
		}
		
		return false
	}
	
	private fun moveHorizontal(direction: Direction): Boolean {
		val deltaX = when (direction) {
			Direction.LEFT -> -1
			Direction.RIGHT -> 1
			else -> throw IllegalArgumentException("Invalid horizontal direction")
		}
		
		val newPosition = Position(playerPosition.x + deltaX, playerPosition.y)
		
		// Vérifier si la nouvelle position est libre
		if (isPositionFree(newPosition)) {
			playerPosition = newPosition
			return true
		}
		
		// Vérifier si on pousse une boîte
		val boxToPush = boxes.find { box ->
			newPosition == box.leftPos || newPosition == box.rightPos
		} ?: return false
		
		// Pour le mouvement horizontal, on doit vérifier si on pousse la boîte dans le bon sens
		val isValidPush = when (direction) {
			Direction.LEFT -> newPosition == boxToPush.rightPos
			Direction.RIGHT -> newPosition == boxToPush.leftPos
			else -> false
		}
		
		if (!isValidPush) return false
		
		// Vérifier si la nouvelle position de la boîte est libre
		val newLeftPos = Position(boxToPush.leftPos.x + deltaX, boxToPush.leftPos.y)
		val newRightPos = Position(boxToPush.rightPos.x + deltaX, boxToPush.rightPos.y)
		
		if (isPositionFree(newLeftPos, excludedBoxes = listOf(boxToPush)) &&
			isPositionFree(newRightPos, excludedBoxes = listOf(boxToPush))
		) {
			// Déplacer la boîte
			boxes.remove(boxToPush)
			boxes.add(Box(newLeftPos, newRightPos))
			playerPosition = newPosition
			return true
		}
		
		return false
	}
	
	private fun findStackedBoxes(startBox: Box, direction: Direction): List<Box> {
		val stackedBoxes = mutableListOf(startBox)
		var currentBox = startBox
		val goingUp = direction == Direction.UP
		
		while (true) {
			val nextBox = if (goingUp) {
				boxes.find { box ->
					box != currentBox && (
						(box.leftPos.y == currentBox.leftPos.y - 1 &&
							box.leftPos.x == currentBox.leftPos.x) ||
							(box.rightPos.y == currentBox.rightPos.y - 1 &&
								box.rightPos.x == currentBox.rightPos.x)
						)
				}
			} else {
				boxes.find { box ->
					box != currentBox && (
						(box.leftPos.y == currentBox.leftPos.y + 1 &&
							box.leftPos.x == currentBox.leftPos.x) ||
							(box.rightPos.y == currentBox.rightPos.y + 1 &&
								box.rightPos.x == currentBox.rightPos.x)
						)
				}
			}
			
			if (nextBox != null) {
				stackedBoxes.add(nextBox)
				currentBox = nextBox
			} else {
				break
			}
		}
		
		return stackedBoxes
	}
	
	private fun moveBoxes(boxesToMove: List<Box>, deltaX: Int = 0, deltaY: Int = 0) {
		boxesToMove.forEach { box ->
			// Effacer l'ancienne position de la boîte
			grid[box.leftPos] = ' '
			grid[box.rightPos] = ' '
			
			// Calculer la nouvelle position
			val newLeftPos = Position(box.leftPos.x + deltaX, box.leftPos.y + deltaY)
			val newRightPos = Position(box.rightPos.x + deltaX, box.rightPos.y + deltaY)
			
			// Mettre à jour la grille avec la nouvelle position
			grid[newLeftPos] = '['
			grid[newRightPos] = ']'
			
			// Mettre à jour la liste des boxes
			boxes.remove(box)
			boxes.add(Box(newLeftPos, newRightPos))
		}
	}
	
	private fun isPositionFree(position: Position, excludedBoxes: List<Box> = emptyList()): Boolean {
		// Vérifier si la position est valide (n'est pas un mur ou hors limites)
		val cell = grid[position] ?: return false
		if (cell == '#') return false
		
		// Vérifier si la position n'est pas occupée par une boîte non exclue
		return !boxes.any { box ->
			box !in excludedBoxes && (position == box.leftPos || position == box.rightPos)
		}
	}
}
