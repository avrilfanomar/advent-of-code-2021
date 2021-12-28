import java.io.File
import kotlin.math.abs

var crabPositions = mutableListOf<Long>()
File("input.txt").readLines()[0].split(",").map { it.toLong() }.forEach {
    crabPositions.add(it)
}
var currentBestFuel = crabPositions.sumOf { it * (it + 1) / 2 }
for (i in 1L..(crabPositions.maxOrNull() ?: 0L)) {
    val nextPositionFuel = crabPositions.sumOf { abs((it - i)) * (abs(it - i) + 1) / 2 }
    if (currentBestFuel > nextPositionFuel) {
        currentBestFuel = nextPositionFuel
    }
}

println(currentBestFuel)
