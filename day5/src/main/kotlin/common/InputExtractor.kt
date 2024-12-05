package common

import java.io.File

fun extractUpdate(): List<List<Int>> {
	return File("src/main/resources/printing.txt").readLines().map { printing -> printing.split(",").map { it.toInt() } }
}

fun extractOrders(): List<Pair<Int, Int>> {
	return File("src/main/resources/orders.txt").readLines().map { order ->
		val split = order.split("|")
		Pair(split[0].toInt(), split[1].toInt())
	}
}
