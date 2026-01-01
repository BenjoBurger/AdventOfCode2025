package day8

import java.io.File
import kotlin.math.sqrt

fun main() {
    val input = File("day8/input.txt").readLines()
    val newInput = mutableListOf<Triple<Long, Long, Long>>()
    input.forEach { line ->
        val coordinates = line.split(',')
        newInput.add(Triple(coordinates[0].toLong(), coordinates[1].toLong(), coordinates[2].toLong()))
    }
    val edges = mutableListOf<Pair<Double, Pair<Int, Int>>>()
    for (i in 0 until newInput.size) {
        for (j in i+1 until newInput.size) {
            val x = newInput[i].first - newInput[j].first
            val y = newInput[i].second - newInput[j].second
            val z = newInput[i].third - newInput[j].third
            val length = sqrt((x * x + y * y + z * z).toDouble())
            edges.add(Pair(length, Pair(i, j)))
        }
    }
    edges.sortBy { it.first }
    val visited = mutableSetOf<Int>()
    var lastNodes = Pair(0, 0)
    for (i in 0 until edges.size) {
        val nodes = edges[i].second
        if (visited.contains(nodes.first) && visited.contains(nodes.second)) {
            if (visited.size >= newInput.size) {
                break
            }
        } else {
            visited.add(nodes.first)
            visited.add(nodes.second)
            lastNodes = nodes
//            println("$i: $lastNodes")
        }
//        println("Visited $visited")
    }
//    println(lastNodes)
//    println(newInput[lastNodes.first])
//    println(newInput[lastNodes.second])
    val ans = (newInput[lastNodes.first].first * newInput[lastNodes.second].first)
    println(ans)
}
