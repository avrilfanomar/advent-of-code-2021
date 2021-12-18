import  java.io.File

var totalArray = Array(100) { 0 };
var len = 0;
File("input.txt").forEachLine { line ->
    var idx = 0
    line.split("").forEach {
        when (it) {
            "0" -> totalArray[idx]--
            "1" -> totalArray[idx]++
            else -> idx--
        }
        idx++
    }
    len = idx
}

var epsilon = Array(len) { 0 };
var gamma = Array(len) { 0 };

for ((index, total) in totalArray.withIndex()) {
    if (total == 0) {
        break
    }
    if (total > 0) {
        gamma[index] = 1
        epsilon[index] = 0
    } else {
        gamma[index] = 0
        epsilon[index] = 1
    }
}

println(epsilon.joinToString("").toInt(2) * gamma.joinToString("").toInt(2));
