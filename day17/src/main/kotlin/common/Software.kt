package common

fun runSoftware(computer: Computer): List<Long> {
	
	val program = computer.program
	
	var registerA = computer.registerA
	var registerB = computer.registerB
	var registerC = computer.registerC
	
	val output = mutableListOf<Long>()
	
	var pointer = 0
	
	while (pointer < program.size) {
		
		val opcode = program[pointer++]
		val operand = program[pointer++]
		val combo = getComboValue(operand, listOf(registerA, registerB, registerC))
		
		when (opcode) {
			0L -> registerA = registerA / (1L shl combo.toInt())
			1L -> registerB = registerB xor operand
			2L -> registerB = combo % 8
			3L -> if (registerA != 0L) pointer = operand.toInt() else continue
			4L -> registerB = registerB xor registerC
			5L -> output.add(combo % 8)
			6L -> registerB = (registerA / (1L shl combo.toInt()))
			7L -> registerC = (registerA / (1L shl combo.toInt()))
		}
	}
	
	return output
}

private fun getComboValue(operand: Long, registers: List<Long>): Long {
	return when (operand) {
		in 0L..3L -> operand.toLong()
		4L -> registers[0]
		5L -> registers[1]
		6L -> registers[2]
		else -> throw Exception("Wrong operand $operand")
	}
}
