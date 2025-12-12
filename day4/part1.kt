package day4

import java.io.File

interface Grid {
    val height: Int
    val width: Int
    operator fun get(x: Int, y: Int): Char
}

// Extension for List<String>
class StringListGrid(private val data: List<String>) : Grid {
    override val height: Int get() = data.size
    override val width: Int get() = data[0].length
    override fun get(x: Int, y: Int): Char = data[x][y]
}

fun checkAccess(input: Grid, i: Int, j: Int): Boolean {
    var total = 0
    val directions = arrayOf(
        intArrayOf(0, 1),
        intArrayOf(1, 1),
        intArrayOf(-1, 1),
        intArrayOf(0, -1),
        intArrayOf(1, -1),
        intArrayOf(-1, -1),
        intArrayOf(1, 0),
        intArrayOf(-1, 0),
    )
    for (direction in directions) {
        val row = i + direction[0]
        val col = j + direction[1]
        if (row < 0 || col < 0 || row == input.height || col == input.width) continue
        if (input[row, col] == '@') total++
    }
    println("total:$total")
    return total < 4
}

fun main() {
    val input = File("day4/input.txt").readLines()
    val height = input.size
    val length = input[0].length
    var ans = 0
    for (i in 0..< height) {
        for (j in 0..< length) {
            if (input[i][j] == '@') {
                if (checkAccess(StringListGrid(input), i, j)) {
                    ans++
                }
            }
        }
    }
    println(ans)
}
