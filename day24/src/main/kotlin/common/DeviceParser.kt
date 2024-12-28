package common

import java.io.File

fun getDeviceInitialState(isExample: Boolean): Device {
	
	val extraPath = if (isExample) "example/" else ""
	
	val start = File("src/main/resources/$extraPath/start.txt").readLines().associate { start ->
		val input = start.split(":")[0]
		val initialState = start.split(":")[1].trim().toInt()
		input to initialState
	}
	
	val gateRegex = """(\S{3})\s(\S{2,3})\s(\S{3})\s->\s(\S{3})""".toRegex()
	val gates = File("src/main/resources/$extraPath/connections.txt").readLines().map { gate ->
		val match = gateRegex.find(gate)!!
		val input1 = match.groupValues[1]
		val operation = Operator.valueOf(match.groupValues[2])
		val input2 = match.groupValues[3]
		val output = match.groupValues[4]
		
		Gate(
			input1 = input1,
			input2 = input2,
			operation = operation,
			output = output
		)
	}
	
	return Device(start, gates)
}
