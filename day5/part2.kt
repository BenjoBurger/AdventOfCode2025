package day5

import java.io.File

fun main() {
    val input = File("day5/input.txt").readLines()
    var i = 0
    val rangeList: MutableList<Pair<Long, Long>> = mutableListOf()
    while (i < input.size && input[i].trim() != "") {
        val curr = input[i].trim().split("-")
        rangeList.add(Pair(curr[0].toLong(), curr[1].toLong()))
        i++
    }
    rangeList.sortBy { it.first }
    var ans = 0L
    var currRange = rangeList[0]
    for (j in 1 until rangeList.size) {
        if (rangeList[j].first > currRange.second) {
            ans += currRange.second - currRange.first + 1
            currRange = rangeList[j]
        } else if (rangeList[j].first <= currRange.second && currRange.second < rangeList[j].second) {
            currRange = Pair(currRange.first, rangeList[j].second)
        }
//        println(currRange)
    }
    ans += currRange.second - currRange.first + 1
    println(ans)
}