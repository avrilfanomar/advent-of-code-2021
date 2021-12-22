import java.io.File

val daysToLive = 256

var fishAgeToQuantity = HashMap<Int, Long>()
File("input.txt").readLines()[0].split(",").forEach {
    fishAgeToQuantity.compute(it.toInt()) { _, v -> v?.plus(1) ?: 1 }
}
for (i in 1..daysToLive) {
    val newFishAgeToQuantity = HashMap<Int, Long>()
    fishAgeToQuantity.forEach() {
        if (it.key == 0) {
            newFishAgeToQuantity.compute(6) { _, v -> v?.plus(it.value) ?: it.value }
            newFishAgeToQuantity.compute(8) { _, v -> v?.plus(it.value) ?: it.value }
        } else {
            newFishAgeToQuantity.compute(it.key - 1) { _, v -> v?.plus(it.value) ?: it.value }
        }
    }
    fishAgeToQuantity = newFishAgeToQuantity
}

println(fishAgeToQuantity.map { it.value }.sum())
