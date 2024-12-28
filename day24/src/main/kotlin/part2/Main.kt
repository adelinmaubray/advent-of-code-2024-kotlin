package part2

import common.getDeviceInitialState
import part1.runProgram

fun main() {
	val device = getDeviceInitialState(true)
//	val device = getDeviceInitialState(false)
	
	val x = device.start
		.filter { it.key.startsWith("x") }
		.toSortedMap()
		.reversed()
		.values
		.joinToString("")
	
	println("x: ${x.toLong(2)}")
	
	val y = device.start
		.filter { it.key.startsWith("y") }
		.toSortedMap()
		.reversed()
		.values
		.joinToString("")
	
	println("y: ${y.toLong(2)}")
	
	println("z: ${x.toLong(2) + y.toLong(2)}")
	println(Integer.toBinaryString((x.toInt(2) + y.toInt(2))))
	
	val finalState = runProgram(device)
	val output = finalState.joinToString(separator = "").toLong(2)
	println(output)
}
