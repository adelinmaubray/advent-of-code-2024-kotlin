package part1

import common.getDeviceInitialState
import common.runProgram

fun main() {

//	val device = getDeviceInitialState(true)
	val device = getDeviceInitialState(false)
	val finalState = runProgram(device)
	val output = finalState.joinToString(separator = "").toLong(2)
	println(output)
}
