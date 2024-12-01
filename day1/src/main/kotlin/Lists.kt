@ConsistentCopyVisibility
data class Lists private constructor(val leftList: List<Int>,
									 val rightList: List<Int>) {
	
	companion object {
		fun create(list1: List<Int>, list2: List<Int>): Lists {
			if (list1.size != list2.size) {
				throw IllegalArgumentException("The list should have the same size !")
			}
			return Lists(leftList = list1, rightList = list2)
		}
	}
}
