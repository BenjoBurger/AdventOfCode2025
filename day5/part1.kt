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
    i++
    rangeList.sortBy { it.first }
    var ans = 0
    while (i < input.size) {
        val curr = input[i].trim().toLong()
        for (range in rangeList) {
            if (curr < range.first) {
                break
            } else if (curr <= range.second) {
                ans += 1
                break
            }
        }
        i++
    }
    println(ans)
}