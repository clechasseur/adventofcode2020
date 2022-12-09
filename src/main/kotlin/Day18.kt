import org.clechasseur.adventofcode2020.Day18Data

object Day18 {
    private val input = Day18Data.input

    fun part1(): Long = input.lines().map { line ->
        line.withoutWhitespace.compute()
    }.sum()

    private val String.withoutWhitespace: String
        get() = "\\s".toRegex().replace(this, "")

    private fun String.compute(): Long {
        var (left, pos) = readValue(0)
        var op = this[pos++]
        val (right, newPos) = readValue(pos)
        pos = newPos
        var value = when (op) {
            '+' -> left + right
            '*' -> left * right
            else -> error("Wrong operator: $op")
        }
        while (pos < length) {
            op = this[pos++]
            val (newRight, newNewPos) = readValue(pos)
            pos = newNewPos
            value = when (op) {
                '+' -> value + newRight
                '*' -> value * newRight
                else -> error("Wrong operator: $op")
            }
        }
        return value
    }

    private fun String.readValue(pos: Int): Pair<Long, Int> = if (this[pos] == '(') {
        var lastPos = pos + 1
        var depth = 1
        while (depth > 0) {
            depth += when (this[lastPos]) {
                '(' -> 1
                ')' -> -1
                else -> 0
            }
            lastPos++
        }
        substring(pos + 1 until lastPos - 1).compute() to lastPos
    } else {
        this[pos].toString().toLong() to pos + 1
    }
}
