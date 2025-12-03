import java.io.File

fun main() {
    var count = 0
    var curr = 50
    File("day1/input.txt").forEachLine { line ->
        val trimmed = line.trim()
        val dir = trimmed.take(1)
        val value = trimmed.filter{ it.isDigit() }.toInt()
        if (dir == "L") {
            curr -= value
            while (curr < 0) {
                curr += 100
            }
        } else if (dir == "R") {
            curr += value
            while (curr > 99) {
                curr -= 100
            }
        }
        if (curr == 0) {
            count++
        }
    }
    println(count)
}
