package common

import java.io.File

val xRegex = Regex("""X.(\d+),""")
val yRegex = Regex("""Y.(\d+)$""")

fun parseInput(path: String): List<MachineBehavior> {
	val lines = File("src/main/resources/$path").readLines().filterNot { it.isEmpty() }
	
	val behaviors = mutableListOf<MachineBehavior>()
	for (i in 0..lines.lastIndex step 3) {
		
		val buttonA = getAxisForLine(lines[i])
		val buttonB = getAxisForLine(lines[i + 1])
		val prize = getAxisForLine(lines[i + 2])
		behaviors.add(MachineBehavior(buttonA, buttonB, prize))
	}
	
	return behaviors
}

fun getAxisForLine(line: String): Axis {
	return Axis(
		xRegex.find(line)!!.groupValues[1].toFloat(),
		yRegex.find(line)!!.groupValues[1].toFloat()
	)
}
