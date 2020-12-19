object Day10 {
    private val input = listOf(
        47,
        99,
        115,
        65,
        10,
        55,
        19,
        73,
        80,
        100,
        71,
        110,
        64,
        135,
        49,
        3,
        1,
        98,
        132,
        2,
        38,
        118,
        66,
        116,
        104,
        87,
        79,
        114,
        40,
        37,
        44,
        97,
        4,
        140,
        60,
        86,
        56,
        133,
        7,
        146,
        85,
        111,
        134,
        53,
        121,
        77,
        117,
        21,
        12,
        81,
        145,
        129,
        107,
        93,
        22,
        48,
        11,
        54,
        92,
        78,
        67,
        20,
        138,
        125,
        57,
        96,
        26,
        147,
        124,
        34,
        74,
        143,
        13,
        28,
        126,
        50,
        29,
        70,
        39,
        63,
        41,
        91,
        32,
        84,
        144,
        27,
        139,
        33,
        88,
        72,
        23,
        103,
        16
    )

    fun part1(): Int {
        val chain = listOf(0) + input.sorted() + listOf(input.max()!! + 3)
        val jmp1 = chain.zipWithNext().filter { (i1, i2) -> i2 - i1 == 1 }.count()
        val jmp3 = chain.zipWithNext().filter { (i1, i2) -> i2 - i1 == 3 }.count()
        return jmp1 * jmp3
    }

    fun part2(): Long {
        val chain = listOf(0) + input.sorted() + listOf(input.max()!! + 3)
        var total = 1L
        val curPart = mutableListOf<Int>()
        chain.forEach { a ->
            if (curPart.isEmpty() || a - curPart.last() < 3) {
                curPart.add(a)
            } else {
                total *= combinations(curPart)
                curPart.clear()
                curPart.add(a)
            }
        }
        return total
    }

    private fun combinations(chain: List<Int>): Long {
        if (chain.size <= 1) {
            return 1L
        }
        val next = chain.first()
        val thens = chain.drop(1).takeWhile { it - next <= 3 }
        return thens.map { then ->
            combinations(chain.dropWhile { it < then })
        }.sum()
    }
}