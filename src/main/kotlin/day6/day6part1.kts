import java.io.File

val daysToLive = 80

var fishAgeList = mutableListOf<Int>()
File("input.txt").readLines()[0].split(",").map { it.toInt() }.forEach { fishAgeList.add(it) }
for (i in 1..daysToLive) {
    val newFishAgeList = mutableListOf<Int>()
    fishAgeList.forEach() {
        if (it == 0) {
            newFishAgeList.add(8)
            newFishAgeList.add(6)
        } else {
            newFishAgeList.add(it - 1)
        }
    }
    fishAgeList = newFishAgeList
}

println(fishAgeList.size)
