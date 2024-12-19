package common

import java.io.File

fun parseInput(isExample: Boolean = false): Pair<Pattern, Design> {
	
	val extraPath = if (isExample) "/example" else ""
	
	val patterns = File("src/main/resources$extraPath/patterns.txt").readLines().flatMap { it.split(", ") }
	val designs = File("src/main/resources$extraPath/designs.txt").readLines().flatMap { it.split(", ") }
	
	return patterns.asSequence() to designs.asSequence()
}
