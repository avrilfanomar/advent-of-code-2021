import  java.io.File
import kotlin.math.max
import kotlin.math.min

val resultMap = HashMap<String, Int>()
File("input.txt").forEachLine { line ->
    val parts = line.split("->")
    val x1y1 = parts[0].trim().split(",").map { it.trim().toInt() }
    val x2y2 = parts[1].trim().split(",").map { it.trim().toInt() }
    if (x1y1[0] == x2y2[0]) {
        val min = min(x1y1[1], x2y2[1])
        val max = max(x1y1[1], x2y2[1])
        for (i in min..max) {
            resultMap.compute("${x1y1[0]},$i") { _, v -> v?.plus(1) ?: 1 }
        }
    } else if (x1y1[1] == x2y2[1]) {
        val min = min(x1y1[0], x2y2[0])
        val max = max(x1y1[0], x2y2[0])
        for (i in min..max) {
            resultMap.compute("$i,${x1y1[1]}") { _, v -> v?.plus(1) ?: 1 }
        }
    }
}
println(resultMap.filter { it.value > 1 }.size)
