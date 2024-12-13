package common

import java.io.File

val delimiter = Regex("""\s{3}""")

fun parseInput(path: String): Lists {
	val list1 = mutableListOf<Int>()
	val list2 = mutableListOf<Int>()
	
	File("src/main/resources/$path")
		.readLines()
		.forEach {
			list1.add(it.split(delimiter)[0].toInt())
			list2.add(it.split(delimiter)[1].toInt())
		}
	
	return Lists.create(list1, list2)
}
