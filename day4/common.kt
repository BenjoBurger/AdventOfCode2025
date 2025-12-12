package day4

internal interface Grid {
    val height: Int
    val width: Int
    operator fun get(x: Int, y: Int): Char
}

internal fun checkAccess(input: Grid, i: Int, j: Int): Boolean {
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