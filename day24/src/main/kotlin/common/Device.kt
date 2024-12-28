package common

typealias Start = Map<String, Int>

enum class Operator {
	AND, OR, XOR
}

data class Gate(val input1: String,
				val input2: String,
				val operation: Operator,
				val output: String,
				var executed: Boolean = false) {
	
	override fun toString(): String {
		return """$input1 ${operation.name.uppercase()} $input2 → $output"""
	}
}

data class Device(val start: Start,
				  val gates: List<Gate>)
