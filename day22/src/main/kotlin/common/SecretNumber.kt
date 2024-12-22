package common

data class SecretNumber(val value: Long,
						val price: Int = value.toString().last().digitToInt(),
						var change: Int = 0)
