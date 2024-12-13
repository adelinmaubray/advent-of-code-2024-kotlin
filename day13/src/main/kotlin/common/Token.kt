package common

fun computeTotalNumberOfTokens(behaviors: List<MachineBehavior>): Int {
	
	return behaviors.foldIndexed(0) computedTokenSum@{ index, sumOfToken, behavior ->
		
		/* Resolve the Cramer equations
			
			Given:
			ax + by = c
			dx + ey = f
			
			Compute:
			determinant = a * e - b * d
			val x = (c * e - b * f) / determinant
			val y = (a * f - c * d) / determinant
		*/
		
		val a = behavior.buttonA.x
		val b = behavior.buttonB.x
		val c = behavior.prize.x
		
		val d = behavior.buttonA.y
		val e = behavior.buttonB.y
		val f = behavior.prize.y
		
		val determinant = a * e - b * d
		
		// If the determinant is null, then no usable result
		if (determinant == 0F) return@computedTokenSum sumOfToken
		
		// Compute x and y
		val x = (c * e - b * f) / determinant
		val y = (a * f - c * d) / determinant
		
		// Vérifier si x et y sont des entiers
		if (x.rem(1) != 0F || y.rem(1) != 0F) return@computedTokenSum sumOfToken
		
		return@computedTokenSum sumOfToken + (3 * x + y).toInt()
		
	}
}
