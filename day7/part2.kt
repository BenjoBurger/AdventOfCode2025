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
    var currBeams: MutableMap<Int, Int> = mutableMapOf(pos to 1)
    for (level in 1..< input.size) {
        val newBeams = mutableMapOf<Int, Int>()
        for (beamPos in currBeams.keys) {
            if (input[level][beamPos] == '^') {
                newBeams[beamPos+1] = newBeams.getOrDefault(beamPos+1, 0) + currBeams[beamPos]!!
                newBeams[beamPos-1] = newBeams.getOrDefault(beamPos-1, 0) + currBeams[beamPos]!!
            } else {
                newBeams[beamPos] = newBeams.getOrDefault(beamPos, 0) + currBeams[beamPos]!!
            }
        }
//        println(newBeams)
        currBeams = newBeams
    }
    val ans = currBeams.values.sum()
    println(ans)
}

// too low 489421843