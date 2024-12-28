package part1

import common.getDeviceInitialState

fun main() {

//	val device = getDeviceInitialState(true)
	val device = getDeviceInitialState(false)
	val finalState = runProgram(device)
	val output = finalState.joinToString(separator = "").toLong(2)
	println(output)
}
