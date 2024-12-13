package common

import java.io.File

val xRegex = Regex("""X.(\d+),""")
val yRegex = Regex("""Y.(\d+)$""")

const val NUMBER_TO_ADD = 10000000000000.0

fun parseInput(path: String, addNumber: Boolean = false): List<MachineBehavior> {
	val lines = File("src/main/resources/$path").readLines().filterNot { it.isEmpty() }
	
	val behaviors = mutableListOf<MachineBehavior>()
	for (i in 0..lines.lastIndex step 3) {
		
		val buttonA = getAxisForLine(lines[i])
		val buttonB = getAxisForLine(lines[i + 1])
		val prize = getAxisForLine(lines[i + 2], addNumber)
		behaviors.add(MachineBehavior(buttonA, buttonB, prize))
	}
	
	return behaviors
}

fun getAxisForLine(line: String, addNumber: Boolean = false): Axis {
	return if (addNumber) Axis(
		NUMBER_TO_ADD + xRegex.find(line)!!.groupValues[1].toDouble(),
		NUMBER_TO_ADD + yRegex.find(line)!!.groupValues[1].toDouble()
	) else Axis(
		xRegex.find(line)!!.groupValues[1].toDouble(),
		yRegex.find(line)!!.groupValues[1].toDouble()
	)
}
