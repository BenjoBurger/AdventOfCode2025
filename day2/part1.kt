@file:Suppress("DuplicatedCode")

package day2
import java.io.File

fun main() {
    val rangeArr = File("day2/input.txt").readText().split(',')
    val rangeIntArr = mutableListOf<Pair<Long, Long>>()
    for (range in rangeArr) {
        val split = range.trim().split("-")
        val start = split[0].toLong()
        val end = split[1].toLong()
        rangeIntArr.add(Pair(start, end))
    }
    val sortedRange = rangeIntArr.sortedBy { pair -> pair.first }
//    println(sortedRange)
    var curr = 1
    var sum = 0L
    for (range in sortedRange) {
        val start = range.first
        val end = range.second
//        println("$start --> $end")

        while (true) {
            val currVal = (curr.toString() + curr.toString()).toLong()
            if (currVal < start) {
                curr++
                continue
            } else if (currVal > end) {
                break
            }
//            println("$start | $end : $currVal")
            sum += currVal
            curr++
        }
    }
    println(sum)
}