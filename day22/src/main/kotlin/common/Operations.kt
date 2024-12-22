package common

import kotlin.math.floor

internal fun step1(secretNumber: Long): Long = (secretNumber * 64).mix(secretNumber).prune()
internal fun step2(secretNumber: Long): Long = floor(secretNumber.toFloat() / 32.toFloat()).toLong().mix(secretNumber).prune()
internal fun step3(secretNumber: Long): Long = (secretNumber * 2048).mix(secretNumber).prune()

private fun Long.mix(secretNumber: Long): Long = this xor secretNumber

private fun Long.prune(): Long = this % 16777216
