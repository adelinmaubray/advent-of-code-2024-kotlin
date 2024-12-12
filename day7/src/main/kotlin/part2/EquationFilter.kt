package part2

import com.google.common.collect.Sets
import common.Equation
import org.mariuszgromada.math.mxparser.Expression

fun computeEquations(equations: List<Equation>): Double {
	return equations.fold(0.0) equationFiltering@{ sum, equation ->
		
		println("Evaluating equation $equation")
		
		val result = equation.result
		val numbers = equation.numbers
		
		val combinaisons = Sets.cartesianProduct(
			List(numbers.size - 1) {
				setOf("+", "*", "||")
			}
		)
		
		combinaisons.forEach { operators ->
			
			var tempCalculationResult = numbers[0]
			
			(0 until numbers.lastIndex).forEach { index ->
				val operator = operators[index]
				if (operator == "||") {
					tempCalculationResult = "$tempCalculationResult${numbers[index + 1]}".toLong()
				} else {
					val expression = "$tempCalculationResult$operator${numbers[index + 1]}"
					tempCalculationResult = Expression(expression).calculate().toLong()
				}
			}
			
			if (tempCalculationResult == result) {
				return@equationFiltering sum + result
			}
		}
		
		return@equationFiltering sum
	}
}


