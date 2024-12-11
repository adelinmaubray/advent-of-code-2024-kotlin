package part2

import common.parseInput
import org.mariuszgromada.math.mxparser.License

fun main() {
	
	License.iConfirmNonCommercialUse("Adelin Rommes")
	
	// Parse input
	val equations = parseInput("example.txt")
//	val equations = parseInput("puzzle_input.txt")
	
	// Find the resolvable equation
	val sumOfPossibleEquations = computeEquations(equations)
	println(sumOfPossibleEquations.toLong())
}
