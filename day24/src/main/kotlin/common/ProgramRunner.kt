package common

fun runProgram(device: Device): List<Int> {
	
	val gates = device.gates
	val finalValues = device.start.toMutableMap()
	
	while (gates.any { !it.executed }) {
		
		gates.forEach forEachGate@{ gate ->
			
			// check if the operation has been executed
			if (gate.executed) return@forEachGate
			
			// check that both inputs have value
			if (!finalValues.containsKey(gate.input1) || !finalValues.containsKey(gate.input2)) return@forEachGate
			
			val outputValue = when (gate.operation) {
				Operator.AND -> finalValues[gate.input1]!! and finalValues[gate.input2]!!
				Operator.OR -> finalValues[gate.input1]!! or finalValues[gate.input2]!!
				Operator.XOR -> finalValues[gate.input1]!! xor finalValues[gate.input2]!!
			}
			
			finalValues[gate.output] = outputValue
			
			gate.executed = true
		}
	}
	
	return finalValues
		.filter { it.key.startsWith("z") }
		.toSortedMap()
		.reversed()
		.values.toList()
}
