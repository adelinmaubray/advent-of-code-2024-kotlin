package part2

import common.Computer
import common.runSoftware

fun runSpecificSoftware(computer: Computer): Long {
	
	val program = computer.program
	
	fun decipher(subA: Long, left: Int): Long {
		if (left < 0) return subA
		for (i in 0..7) {
			// This is the key pattern of the algo (thanks for help !)
			val a = subA * 8 + i
			val computer = Computer(a, 0, 0, program)
			val outputs = runSoftware(computer)
			if (outputs == program.subList(left, program.size)) {
				val result = decipher(a, left - 1)
				if (result != 0L) return result
			}
		}
		return 0L
	}
	
	return decipher(0, program.lastIndex)
}
