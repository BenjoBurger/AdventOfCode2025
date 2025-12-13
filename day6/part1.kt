package day6

import java.io.File

fun main() {
    val input = File("day6/input.txt").readLines()
    val operationLine = input.last()
    var i = 0
    var ans = 0L
    while (i < operationLine.lastIndex) {
        val currOp = operationLine[i]
        val start = i
        var end = start + 1
        while ((end < operationLine.lastIndex) && (operationLine[end] == ' ')) {
            end++
        }
        val currProblem: MutableList<Long> = mutableListOf()
        for (j in 0 until input.lastIndex) {
            currProblem.add(input[j].substring(start, end).trim().toLong())
        }
        ans += solveProblem(currProblem, currOp)
        i = end
    }
    val currOp = operationLine[i]
    val start = i
    val currProblem: MutableList<Long> = mutableListOf()
    for (j in 0 until input.lastIndex) {
        currProblem.add(input[j].substring(start, input[j].lastIndex+1).trim().toLong())
    }
    ans += solveProblem(currProblem, currOp)
    println(ans)
}

private fun solveProblem(
    currProblem: MutableList<Long>,
    currOp: Char,
): Long {
    var ans = 0L
    println("currProblem: $currProblem")
    if (currOp == '+') {
        print("Sum: ")
        println(currProblem.sum())
        ans += currProblem.sum()
    } else if (currOp == '*') {
        print("Multiply: ")
        println(currProblem.reduce { curr, next -> curr * next })
        ans += currProblem.reduce { curr, next -> curr * next }
    }
    return ans
}