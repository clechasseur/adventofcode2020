object Day25 {
    private val publicKeys = listOf(
        8987316L,
        14681524L
    )

    fun part1(): Long {
        val loopSize = findLoopSize(7L, publicKeys.first())
        return transform(publicKeys.last(), loopSize)
    }

    private fun transformSequence(subjectNumber: Long): Sequence<Long> = generateSequence(1L) { value ->
        (value * subjectNumber) % 20201227L
    }

    private fun transform(subjectNumber: Long, loopSize: Int): Long = transformSequence(subjectNumber).elementAt(loopSize)

    private fun findLoopSize(subjectNumber: Long, target: Long): Int = transformSequence(subjectNumber).indexOfFirst {
        it == target
    }
}
