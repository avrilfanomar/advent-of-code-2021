import  java.io.File

val batchSize = 3

val valueList = ArrayList<Int>()
var counter = 0
File("input.txt").forEachLine { line ->
    valueList.add(line.toInt())

    if (valueList.size > batchSize + 1) {
        valueList.removeAt(0)
    }
    if (valueList.size == batchSize + 1) {
        val sum = valueList.sum()
        if (sum - valueList[0] > sum - valueList[batchSize]) {
            counter++
        }
    }
}
println(counter)
