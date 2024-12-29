package part1

import common.computeSum
import common.typeOnDirectionalKeypad
import common.typeOnNumericKeypad

fun main() {
	
	val example = listOf(
		"029A",
		"980A",
		"179A",
		"456A",
		"379A"
	)
	
	val puzzleInput = listOf(
		"149A",
		"582A",
		"540A",
		"246A",
		"805A"
	)
	
	val firstRobot = typeOnNumericKeypad(example)
	println(firstRobot)
	
	val secondRobot = typeOnDirectionalKeypad(firstRobot)
	println(secondRobot)
	
	val thirdRobot = typeOnDirectionalKeypad(secondRobot)
	println(thirdRobot)
	
	val sum = computeSum(thirdRobot)
	println(sum)

//	val sequence = typeOnDirectionalKeypad(typeOnDirectionalKeypad(typeOnNumericKeypad(example)))
//	sequence.forEach(::println)
//	val sum = computeSum(sequence)
//	println(sum)
	
	// 180'989 too high
	// 170'508 too high
	// 169'912 too high
}
