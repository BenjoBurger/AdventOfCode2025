package day8

import java.io.File
import kotlin.math.sqrt

fun find(value: Int, parents: MutableList<Int>): Int {
    if (value != parents[value]) {
        parents[value] = find(parents[value], parents)
    }
    return parents[value]
}

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
    val parents = MutableList(newInput.size) { it }
    for (i in 0 until 1000) {
        val edge = edges[i].second
        val parent1 = find(edge.first, parents)
        val parent2 = find(edge.second, parents)
        parents[parent1] = parent2
    }
    val sizes = MutableList(newInput.size) { 0 }
    for (i in 0 until newInput.size) {
        sizes[find(i, parents)]++
    }
    sizes.sortDescending()
    println(sizes)
    println((sizes[0] * sizes[1] * sizes[2]).toLong())
}
