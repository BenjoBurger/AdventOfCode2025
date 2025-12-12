package day3

import java.io.File

fun main() {
    var sum = 0
    File("day3/input.txt").forEachLine { line ->
        val trimmed = line.trim()
        var first = trimmed[0]
        var second = '0'
        var i = 1
        while (i < trimmed.length-1) {
            if (trimmed[i].digitToInt() > first.digitToInt()) {
                first = trimmed[i]
                second = trimmed[i + 1]
            } else if (trimmed[i].digitToInt() > second.digitToInt()) {
                second = trimmed[i]
            }
            i++
        }
        if (trimmed[i].digitToInt() > second.digitToInt()) {
            second = trimmed[i]
        }
        println("$first$second")
        sum += (first.toString() + second.toString()).toInt()
    }
    println(sum)
}