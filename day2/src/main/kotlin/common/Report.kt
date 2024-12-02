package common

@ConsistentCopyVisibility
data class Report private constructor(val levels: List<Int>) {
	
	companion object {
		fun create(levels: List<String>): Report {
			return Report(levels.map { it.toInt()  })
		}
	}
}
