object Day13 {
    private const val input_earliest = 1006401L
    private val input_bus_ids = listOf(17,0,0,0,0,0,0,0,0,0,0,37,0,0,0,0,0,449,0,0,0,0,0,0,0,23,0,0,0,0,13,0,0,0,0,0,19,0,0,0,0,0,0,0,0,0,0,0,607,0,0,0,0,0,0,0,0,0,41,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,29)

    fun part1(): Long {
        val (id, ts) = input_bus_ids.filter { it != 0 }.map { id ->
            id to busSequence(id).dropWhile { it < input_earliest }.first()
        }.minBy { it.second }!!
        return id.toLong() * (ts - input_earliest)
    }

    fun part2(): Long {
        val seqs = input_bus_ids.map { id -> if (id != 0) busSequence(id).iterator() else null }
        val cur = MutableList(input_bus_ids.size) { 0L }
        while (true) {
            cur[0] = seqs[0]!!.next()
            var match = true
            cur.indices.drop(1).forEach { pos ->
                if (seqs[pos] != null) {
                    while (cur[pos] <= cur[0]) {
                        cur[0] = seqs[pos]!!.next()
                    }
                    match = match && cur[pos] - pos == cur[0]
                }
            }
            if (match) {
                return cur[0]
            }
        }
    }

    private fun busSequence(id: Int) = generateSequence(0L) { it + id.toLong() }
}