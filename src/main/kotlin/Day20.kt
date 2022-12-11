import org.clechasseur.adventofcode2020.Day20Data

object Day20 {
    private val input = Day20Data.input

    private val idRegex = """^Tile (\d+):$""".toRegex()

    fun part1(): Long = input.toTiles().size.toLong()

    private data class Tile(val id: Long, val data: String)

    private fun String.toTiles(): List<Tile> {
        val tiles = mutableListOf<Tile>()
        val toParse = lines()
        var i = 0
        while (i < toParse.size) {
            val match = idRegex.matchEntire(toParse[i]) ?: error("Wrong tile ID: ${toParse[i]}")
            val id = match.groupValues[1].toLong()
            var j = i + 1
            while (j < toParse.size && toParse[j].isNotEmpty()) {
                j++
            }
            val data = toParse.subList(i + 1, j).joinToString("\n")
            tiles.add(Tile(id, data))
            i = j + 1
        }
        return tiles
    }
}
