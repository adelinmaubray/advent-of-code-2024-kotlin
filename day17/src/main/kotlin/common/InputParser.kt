package common

import java.io.File

fun parseInput(path: String): Computer {
	val registerARegex = """Register A: (.*)""".toRegex()
	val registerBRegex = """Register B: (.*)""".toRegex()
	val registerCRegex = """Register C: (.*)""".toRegex()
	val program = """Program: (.*)""".toRegex()
	
	val input = File("src/main/resources/$path").readLines().filter { it.isNotBlank() }
	
	return Computer(
		registerARegex.find(input[0])!!.groupValues[1].toLong(),
		registerBRegex.find(input[1])!!.groupValues[1].toLong(),
		registerCRegex.find(input[2])!!.groupValues[1].toLong(),
		program.find(input[3])!!.groupValues[1].split(",").map { it.toLong() }
	)
}
