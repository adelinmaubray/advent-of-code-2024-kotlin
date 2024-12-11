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
		
		val numbersToUse = numbers.toMutableList()
		combinaisons.forEach { operators ->
			
			var tempCalculationResult = 0L
			var indexToReduce = 0
			numbers.forEachIndexed { index, number ->
				
				// TODO change last index concatenate
				val expression = if (index == numbersToUse.lastIndex) "$number"
				else {
					// TODO rework on this operator
					if (operators[index - 1] == "||") {
						numbersToUse[index - indexToReduce] =
							"${numbersToUse[index - indexToReduce]}${numbersToUse[index - indexToReduce + 1]}".toLong()
						"$tempCalculationResult${operators[index - 1]}${numbersToUse[index - indexToReduce]}"
							.also {
								println("index changed")
								indexToReduce--
							}
					} else {
						"$tempCalculationResult${operators[index - 1]}${numbersToUse[index - indexToReduce]}"
					}
				}
				
				println(expression)
				tempCalculationResult = Expression(expression).calculate().toLong()
			}
			
			if (tempCalculationResult == result) {
				println("FOUND!")
				return@equationFiltering sum + result
			}
		}
		
		return@equationFiltering sum
	}
}


