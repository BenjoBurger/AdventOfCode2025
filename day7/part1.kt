package day7

import java.io.File

fun main() {
    val input = File("day7/input.txt").readLines()
    var pos = -1
    for (i in input[0].indices) {
        if (input[0][i] == 'S') {
            pos = i
            break
        }
    }
    var ans = 0
    var currBeams: MutableSet<Int> = mutableSetOf()
    currBeams.add(pos)
    for (level in 1..< input.size) {
        val newBeams: MutableSet<Int> = mutableSetOf()
        for (beamPos in currBeams) {
            if (input[level][beamPos] == '^') {
                newBeams.add(beamPos+1)
                newBeams.add(beamPos-1)
                ans += 1
            } else {
                newBeams.add(beamPos)
            }
        }
        currBeams = newBeams
    }
    println(ans)
}