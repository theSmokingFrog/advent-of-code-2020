package dev.nilshoffmann.day3

import dev.nilshoffmann.load

class Slope(val right: Int, val down: Int)

fun countTreesBySlope(slope: Slope, localMap: List<String>): Int {
    var xCoord = 0
    var yCoord = 0
    var treeCount = 0

    while (yCoord < localMap.lastIndex) {
        xCoord += slope.right
        yCoord += slope.down

        val mapLine = localMap[yCoord]
        val element = mapLine[xCoord % mapLine.length]
        if (element == '#') {
            treeCount++
        }
    }
    return treeCount
}

fun solveDay3PartOne(localMap: List<String>): Int {
    return countTreesBySlope(Slope(3, 1), localMap)
}

fun solveDay3PartTwo(localMap: List<String>): Long {
    val slopes = listOf(
        Slope(1, 1),
        Slope(3, 1),
        Slope(5, 1),
        Slope(7, 1),
        Slope(1, 2)
    )

    return slopes.map { countTreesBySlope(it, localMap) }
        .map { it.toLong() }
        .reduce { acc, i -> acc * i }
}

fun main() {
    val localMap = load("/inputs/day-3.txt")
    println("Solution to Day 3, Part 1 is '${solveDay3PartOne(localMap)}'")
    println("Solution to Day 3, Part 1 is '${solveDay3PartTwo(localMap)}'")
}
