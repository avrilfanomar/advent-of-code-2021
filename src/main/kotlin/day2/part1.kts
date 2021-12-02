import  java.io.File

var depth = 0
var length = 0
File("input.txt").forEachLine { line ->
    val split = line.split(" ")
    if (split[0].equals("forward")) {
        length += split[1].toInt()
    } else if (split[0].equals("up")) {
        depth -= split[1].toInt()
    } else if (split[0].equals("down")) {
        depth += split[1].toInt()
    }
}
println(depth * length)
