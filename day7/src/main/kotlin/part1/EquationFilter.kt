package part1

import com.google.common.collect.Sets
import common.Equation
import org.mariuszgromada.math.mxparser.Expression

fun computeEquations(equations: List<Equation>): Double {
	return equations.fold(0.0) equationFiltering@{ sum, equation ->
		
		val result = equation.result
		val numbers = equation.numbers
		
		val combinaisons = Sets.cartesianProduct(
			List(numbers.size - 1) {
				setOf("+", "*")
			}
		)
		
		combinaisons.forEach { operators ->
			
			var tempCalculationResult = 0L
			numbers.forEachIndexed { index, number ->
				
				val expression = if (index == 0) "$number"
				else "$tempCalculationResult${operators[index - 1]}$number"
				
				tempCalculationResult = Expression(expression).calculate().toLong()
			}
			
			if (tempCalculationResult == result) {
				return@equationFiltering sum + result
			}
		}
		
		return@equationFiltering sum
	}
}


