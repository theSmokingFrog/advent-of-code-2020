package dev.nilshoffmann.day6

import dev.nilshoffmann.load

fun solveDay6PartOne(lines: List<String>): Int {
    return lines.joinToString("\n")
        .splitToSequence("\n\n")
        .map { group -> group.filter { Regex("\\w").matches(it.toString()) }.toCharArray().distinct().count() }
        .sum()
}

fun solveDay6PartTwo(lines: List<String>): Int {
    return lines.joinToString("\n")
        .splitToSequence("\n\n")
        .map { group ->
            group.lines()
                .map { it.toSet() }
                .reduce { acc, c -> acc.intersect(c) }
                .size
        }
        .sum()
}

fun main() {
    val customsDeclarationLines = load("/inputs/day-6.txt")
    println("Solution to Day 6, Part 1 is '${solveDay6PartOne(customsDeclarationLines)}'")
    println("Solution to Day 6, Part 2 is '${solveDay6PartTwo(customsDeclarationLines)}'")
}