package part2

import common.Design
import common.Pattern
import common.PatternAssociation

fun getPossiblePattern(patterns: Pattern, designs: Design): Sequence<Int> {
	
	// Filter each design
	return designs.map designMapping@{ design ->
		
		println("Checking $design")
		
		var count = 0
		val initialState = PatternAssociation(design, mutableListOf())
		
		// Create a queue and initialize it with the design
		val remainingDesigns = ArrayDeque<PatternAssociation>()
		remainingDesigns.add(initialState)
		
		val seenCombinaisons = mutableSetOf<PatternAssociation>()
		seenCombinaisons.add(initialState)
		
		var currentDesign = PatternAssociation(design, mutableListOf())
		
		// While the queue is not empty
		while (remainingDesigns.isNotEmpty()) {
			
			// Take the first element of the queue
			currentDesign = remainingDesigns.removeFirst()
			
			// Loop over all patterns
			patterns.forEach { pattern ->
				
				// Check if the design starts with the pattern
				if (currentDesign.first.startsWith(pattern)) {
					
					// Remove the pattern from the design
					val designWithoutPattern = currentDesign.first.replace("""^$pattern""".toRegex(), "")
					
					// If the design is empty, then it is a match !
					if (designWithoutPattern.isEmpty()) count++
					
					// Add to queue
					val listOfPatterns = currentDesign.second.toMutableList()
					listOfPatterns.add(pattern)
					val nextPatterAssociation = PatternAssociation(designWithoutPattern, listOfPatterns)
					if (nextPatterAssociation !in seenCombinaisons) {
						remainingDesigns.addLast(nextPatterAssociation)
						seenCombinaisons.add(nextPatterAssociation)
					}
				}
			}
		}
		
		return@designMapping count.also(::println)
	}
}
