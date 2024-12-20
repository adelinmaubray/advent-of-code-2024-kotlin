package part1

import common.Design
import common.Pattern

fun filterPattern(patterns: Pattern, designs: Design): Design {
	
	// Filter each design
	return designs.filter designFilter@{ design ->
		
		// Create a queue and initialize it with the design
		val remainingDesigns = ArrayDeque<String>()
		remainingDesigns.add(design)
		var currentDesign = design
		
		// While the queue is not empty
		while (remainingDesigns.isNotEmpty()) {
			
			// Take the first element of the queue
			currentDesign = remainingDesigns.removeFirst()
			
			// Loop over all pattern
			patterns.forEach { pattern ->
				
				// Check if the design starts with the pattern
				if (currentDesign.startsWith(pattern)) {
					// Remove the pattern from the design
					val designWithoutPattern = currentDesign.replace("""^$pattern""".toRegex(), "")
					// If the design is empty, then it is a match !
					if (designWithoutPattern.isEmpty()) return@designFilter true
					// Add the remaining design only if not exists in the queue
					if (!remainingDesigns.contains(designWithoutPattern)) remainingDesigns.addLast(designWithoutPattern)
				}
			}
		}
		
		return@designFilter false
	}
}
