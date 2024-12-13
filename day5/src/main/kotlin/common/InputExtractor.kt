package common

import java.io.File

fun extractUpdate(isExample: Boolean = false): List<List<Int>> {
	val extraDirectory = if (isExample) "/example" else ""
	return File("src/main/resources$extraDirectory/printing.txt").readLines().map { printing -> printing.split(",").map { it.toInt() } }
}

fun extractOrders(isExample: Boolean = false): List<Pair<Int, Int>> {
	val extraDirectory = if (isExample) "/example" else ""
	return File("src/main/resources$extraDirectory/orders.txt").readLines().map { order ->
		val split = order.split("|")
		Pair(split[0].toInt(), split[1].toInt())
	}
}
