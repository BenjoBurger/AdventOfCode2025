package day3

import java.io.File

fun main() {
    var sum = 0L
    File("day3/input.txt").forEachLine { line ->
        val trimmed = line.trim()
        val length = trimmed.length
        var numberString = ""
        var prev = -1
        for (idx in 1..12) {
            val last = length - 12 + idx
            var i = prev + 1
            var curr = prev + 1
            while (i < last) {
                if (trimmed[i] > trimmed[curr]) {
                    curr = i
                }
                i++
            }
            prev = curr
            numberString += trimmed[curr]
        }
//        println("numberString: $numberString")
        sum += numberString.toLong()
    }
    println(sum)
}