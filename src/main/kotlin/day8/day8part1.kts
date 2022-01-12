package day8

import java.io.File

var count = 0
File("input.txt").readLines().forEach {
    it.split("|")[1].split(" ").forEach {
        if (setOf(2, 3, 4, 7).contains(it.length)) count++
    }
}

println(count)
