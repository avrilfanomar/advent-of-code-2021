package day5

import java.io.File
import kotlin.math.abs
import kotlin.math.max

val resultMap = HashMap<String, Int>()
File("input.txt").forEachLine { line ->
    val parts = line.split("->")
    val x1y1 = parts[0].trim().split(",").map { it.trim().toInt() }
    val x2y2 = parts[1].trim().split(",").map { it.trim().toInt() }
    val x1 = x1y1[0]
    val y1 = x1y1[1]
    val x2 = x2y2[0]
    val y2 = x2y2[1]

    val incrementX = when {
        x1 < x2 -> 1
        x1 > x2 -> -1
        else -> 0
    }
    val incrementY = when {
        y1 < y2 -> 1
        y1 > y2 -> -1
        else -> 0
    }
    for (i in 0..max(abs(x1 - x2), abs(y1 - y2))) {
        resultMap.compute("${x1 + incrementX * i},${y1 + incrementY * i}") { _, v -> v?.plus(1) ?: 1 }
    }

}
println(resultMap.filter { it.value > 1 }.size)
