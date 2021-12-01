import  java.io.File

var counter = 0
var currLine = "-1"
File("input.txt").forEachLine { line ->
    if (line.toInt() > currLine.toInt()) {
        counter++
    }
    currLine = line
}
println(counter - 1)
