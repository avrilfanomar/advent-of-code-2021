import  java.io.File


val lines = File("input.txt").readLines()
val oxygen = findOxygen(lines)
val co2 = findCo2(lines)

println(oxygen.toInt(2) * co2.toInt(2));

fun findOxygen(lines: List<String>, index: Int = 0): String {
    if (lines.size == 1) {
        return lines[0]
    }
    var sum = calculateSumForIndex(lines, index)

    val dominant = if (sum >= lines.size / 2 + lines.size % 2) '1' else '0'
    return findOxygen(lines.filter { s -> s[index] == dominant }, index + 1)
}

fun findCo2(lines: List<String>, index: Int = 0): String {
    if (lines.size == 1) {
        return lines[0]
    }
    var sum = calculateSumForIndex(lines, index)

    val dominant = if (sum >= lines.size / 2 + lines.size % 2) '0' else '1'
    return findCo2(lines.filter { s -> s[index] == dominant }, index + 1)
}


fun calculateSumForIndex(lines: List<String>, index: Int): Int {
    var sum = 0
    lines.forEach { line -> sum += line.get(index).digitToInt(2) }
    return sum
}