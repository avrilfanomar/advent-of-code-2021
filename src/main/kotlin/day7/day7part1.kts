import java.io.File

var crabPositions = mutableListOf<Long>()
File("input.txt").readLines()[0].split(",").map { it.toLong() }.forEach {
    crabPositions.add(it)
}
var currentBestFuel = crabPositions.map { Math.abs(it) }.sum()
for (i in 1L..(crabPositions.maxOrNull() ?: 0L)) {
    val nextPositionFuel = crabPositions.map { Math.abs(it - i) }.sum()
    if (currentBestFuel > nextPositionFuel) {
        currentBestFuel = nextPositionFuel
    }
}

println(currentBestFuel)
