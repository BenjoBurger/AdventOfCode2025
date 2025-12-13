package day6

import java.io.File

fun main() {
    val input = File("day6/input.txt").readLines()
    val operationLine = input.last()
    val numberLines = input.size - 1
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
//        println("end: $end")
        for (j in start until end-1) {
            var currNumberString = ""
            for (k in 0 until numberLines) {
                currNumberString += input[k][j]
            }
//            println("currNumber: $currNumberString")
            currProblem.add(currNumberString.trim().toLong())
        }
        ans += solveProblem(currProblem, currOp)
        i = end
    }
    val currOp = operationLine[i]
    val currProblem: MutableList<Long> = mutableListOf()
    val currNumbers: MutableMap<Int, String> = mutableMapOf()
    var numberExist = BooleanArray(numberLines) { true }
    while (numberExist.any { it }) {
        numberExist = BooleanArray(numberLines) { false }
        for (j in 0 until numberLines) {
            if (i < input[j].length) {
                currNumbers[i] = currNumbers.getOrDefault(i, "") + input[j][i]
                numberExist[j] = true
            }
        }
        i++
    }
    for ((_, v) in currNumbers) {
//        println("number: $v")
        currProblem.add(v.toLong())
    }
    ans += solveProblem(currProblem, currOp)
    println(ans)
}

private fun solveProblem(
    currProblem: MutableList<Long>,
    currOp: Char,
): Long {
    var ans = 0L
//    println("currProblem: $currProblem")
    if (currOp == '+') {
//        print("Sum: ")
//        println(currProblem.sum())
        ans += currProblem.sum()
    } else if (currOp == '*') {
//        print("Multiply: ")
//        println(currProblem.reduce { curr, next -> curr * next })
        ans += currProblem.reduce { curr, next -> curr * next }
    }
//    println("currProblem: $ans")
    return ans
}