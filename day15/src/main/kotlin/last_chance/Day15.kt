package last_chance

class Day15 {
	companion object {
		const val DEBUG = false
		
		@JvmStatic
		fun main(args: Array<String>) {
			
			val input = readFileLines("main/kotlin/last_chance/input")
			val resultPart2 = part2(input)
			println("Result2=$resultPart2")
			
			// 1574029 too high
		}
		
		fun part1(input: List<String>): Long {
			val (map, moves) = parseInput(input)
			val warehouse = Warehouse(map)
			
			for (move in moves) {
				warehouse.moveRobot(move)
				if (DEBUG) {
					println("After move $move:")
					warehouse.printMap()
				}
			}
			
			return warehouse.calculateGPSSum()
		}
		
		fun part2(input: List<String>): Long {
			val (map, moves) = parseInput(input)
			val scaledMap = scaleMap(map)
			val warehouse = Warehouse(scaledMap)
			
			for (move in moves) {
				warehouse.moveRobot(move)
				if (DEBUG) {
					println("After move $move:")
					warehouse.printMap()
				}
			}
			
			return warehouse.calculateGPSSum()
		}
		
		private fun parseInput(input: List<String>): Pair<List<String>, List<Char>> {
			val mapEndIndex = input.indexOfFirst { it.isEmpty() }
			val map = input.subList(0, mapEndIndex)
			val moves = input.last().toList()
			return Pair(map, moves)
		}
		
		private fun scaleMap(map: List<String>): List<String> {
			return map.map { line ->
				line.map { char ->
					when (char) {
						'#' -> "##"
						'O' -> "[]"
						'.' -> ".."
						'@' -> "@."
						else -> throw IllegalArgumentException("Invalid character: $char")
					}
				}.joinToString("")
			}
		}
	}
	
	class Warehouse(map: List<String>) {
		private val width: Int = map[0].length
		private val height: Int = map.size
		private val grid: Array<CharArray> = Array(height) { y -> map[y].toCharArray() }
		private var robotX: Int = 0
		private var robotY: Int = 0
		
		init {
			for (y in 0 until height) {
				for (x in 0 until width) {
					if (grid[y][x] == '@') {
						robotX = x
						robotY = y
						break
					}
				}
			}
		}
		
		fun moveRobot(direction: Char) {
			val (dx, dy) = when (direction) {
				'>' -> Pair(1, 0)
				'<' -> Pair(-1, 0)
				'^' -> Pair(0, -1)
				'v' -> Pair(0, 1)
				else -> throw IllegalArgumentException("Invalid direction: $direction")
			}
			
			val newX = robotX + dx
			val newY = robotY + dy
			
			if (canMove(newX, newY)) {
				grid[robotY][robotX] = '.'
				grid[newY][newX] = '@'
				robotX = newX
				robotY = newY
			} else if (isBox(newX, newY)) {
				pushBoxes(newX, newY, dx, dy)
			}
		}
		
		private fun canMove(x: Int, y: Int): Boolean {
			return x in 0 until width && y in 0 until height && grid[y][x] == '.'
		}
		
		private fun isBox(x: Int, y: Int): Boolean {
			return x in 0 until width && y in 0 until height && (grid[y][x] == 'O' || grid[y][x] == '[')
		}
		
		private fun pushBoxes(startX: Int, startY: Int, dx: Int, dy: Int) {
			val boxesToPush = mutableListOf<Pair<Int, Int>>()
			var x = startX
			var y = startY
			
			while (isBox(x, y)) {
				boxesToPush.add(Pair(x, y))
				x += dx
				y += dy
			}
			
			if (canMove(x, y)) {
				for (i in boxesToPush.size - 1 downTo 0) {
					val (bx, by) = boxesToPush[i]
					grid[by + dy][bx + dx] = grid[by][bx]
					grid[by][bx] = '.'
				}
				grid[robotY][robotX] = '.'
				robotX += dx
				robotY += dy
				grid[robotY][robotX] = '@'
			}
		}
		
		fun calculateGPSSum(): Long {
			var sum: Long = 0
			for (y in 0 until height) {
				for (x in 0 until width) {
					if (isBox(x, y)) {
						sum += (100L * (y + 1) + (x + 1))
					}
				}
			}
			return sum
		}
		
		fun printMap() {
			for (row in grid) {
				println(row.joinToString(""))
			}
			println()
		}
	}
}

