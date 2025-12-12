package day4

import java.io.File

// Extension for List<String>
private class StringListGrid(private val data: List<String>) : Grid {
    override val height: Int get() = data.size
    override val width: Int get() = data[0].length
    override fun get(x: Int, y: Int): Char = data[x][y]
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
