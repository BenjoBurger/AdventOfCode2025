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
    val largest = sortedRange.last().second.toString()
    val lengthOfLargest = largest.length
    val limit = largest.take(lengthOfLargest / 2).toLong()
    var curr = 1L
    var currVal: Long
    var i = 2
    var sum = 0L
    val visited = mutableMapOf<Long, Boolean>()
    while (curr <= limit) {
        for (range in sortedRange) {
            val start = range.first
            val end = range.second

            while (true) {
                currVal = curr.toString().repeat(i).toLong()
                if (currVal > end) {
                    break
                } else if ((currVal >= start) and !visited.contains(currVal)) {
                    visited[currVal] = true
                    sum += currVal
//                    println("Range $start -> $end | $currVal")
                }
                i++
            }
        }
        i = 2
        curr++
    }
    println(sum)
}