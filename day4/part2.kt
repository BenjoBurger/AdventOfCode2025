package day4

import java.io.File

// Extension for Array<CharArray>
class CharArrayGrid(private val data: Array<CharArray>) : Grid {
    override val height: Int get() = data.size
    override val width: Int get() = data[0].size
    override fun get(x: Int, y: Int): Char = data[x][y]
}

fun main() {
    val input: Array<CharArray> = File("day4/input.txt").readLines()
        .map { it.toCharArray() }
        .toTypedArray()
    val height = input.size
    val length = input[0].size
    var ans = 0
    while (true) {
        var curr = 0
        for (i in 0..< height) {
            for (j in 0..<length) {
                if (input[i][j] == '@') {
                    if (checkAccess(CharArrayGrid(input), i, j)) {
                        input[i][j] = '.'
                        curr++
                    }
                }
            }
        }
        println("curr: $curr")
        if (curr == 0) break
        ans += curr
    }
    println(ans)
}
