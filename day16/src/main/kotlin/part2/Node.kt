package part2

import common.Point

data class Node(val state: State,
				val score: Long = 0,
				val path: List<Point>)
