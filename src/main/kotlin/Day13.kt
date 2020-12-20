object Day13 {
    private const val input_earliest = 1006401
    private val input_bus_ids = listOf(17, 37, 449, 23, 13, 19, 607, 41, 29)

    fun part1(): Int {
        val (id, ts) = input_bus_ids.map { id ->
            id to busSequence(id).dropWhile { it < input_earliest }.first()
        }.minBy { it.second }!!
        return id * (ts - input_earliest)
    }

    private fun busSequence(id: Int) = generateSequence(0) { it + id }
}