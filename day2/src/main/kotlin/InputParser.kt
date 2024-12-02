import java.io.File

fun parseInput(): List<Report> {
	return File("day2/src/main/resources/puzzle-input.txt").readLines().map { line ->
		Report.create(line.split(" "))
	}
}
