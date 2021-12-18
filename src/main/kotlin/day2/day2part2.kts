import  java.io.File

var aim = 0
var depth = 0
var length = 0
File("input.txt").forEachLine { line ->
    val split = line.split(" ")
    val x = split[1].toInt()
    if (split[0].equals("forward")) {
        length += x
        depth += x * aim
    } else if (split[0].equals("up")) {
        aim -= x
    } else if (split[0].equals("down")) {
        aim += x
    }
}
println(depth * length)
