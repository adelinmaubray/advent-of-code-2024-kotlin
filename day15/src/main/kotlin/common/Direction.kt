package common

import common.Direction.entries


enum class Direction(val symbol: Char) {
	
	UP('^'),
	DOWN('v'),
	LEFT('<'),
	RIGHT('>');
	
	companion object {
		fun from(symbol: Char): Direction? = entries.find { it.symbol == symbol }
	}
}
