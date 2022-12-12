import org.clechasseur.adventofcode2020.Day20Data
import org.clechasseur.adventofcode2020.Direction

object Day20 {
    private val input = Day20Data.input

    private val idRegex = """^Tile (\d+):$""".toRegex()

    fun part1(): Long {
        val tiles = input.toTiles()
        val firstTile = tiles.first()
        tiles.asSequence().drop(1).flatMap { tile ->
            tile.orientationSequence()
        }.mapNotNull { tile ->
            val dir = firstTile.canConnect(tile)
            if (dir != null) tile to dir else null
        }.forEach { (tile, direction) ->
            println("${firstTile.id} -> $direction -> ${tile.id}")
            println()
            when (direction) {
                Direction.UP -> {
                    printTiles(tile)
                    printTiles(firstTile)
                }
                Direction.DOWN -> {
                    printTiles(firstTile)
                    printTiles(tile)
                }
                Direction.LEFT -> printTiles(tile, firstTile)
                Direction.RIGHT -> printTiles(firstTile, tile)
            }
        }
        return -1L
    }

    private fun printTiles(vararg tiles: Tile) {
        tiles.first().lines.indices.forEach { x ->
            println(tiles.joinToString(" ") { it.lines[x] })
        }
        println()
    }

    private data class Tile(val id: Long, val data: List<String>) {
        val lines: List<String>
            get() = data
        val columns: List<String> by lazy {
            data.indices.map { x -> data.joinToString("") { it[x].toString() } }
        }

        fun flipVertically(): Tile = Tile(id, lines.reversed())
        fun rotateClockwise(): Tile = Tile(id, lines.indices.map { x ->
            lines.indices.reversed().joinToString("") { y -> data[y][x].toString() }
        })

        fun orientationSequence(): Sequence<Tile> = generateSequence(this) { tile ->
            tile.rotateClockwise()
        }.take(4).flatMap { tile ->
            sequenceOf(tile, tile.flipVertically())
        }

        fun canConnect(tile: Tile, direction: Direction): Boolean = when (direction) {
            Direction.UP -> lines.first() == tile.lines.last()
            Direction.DOWN -> lines.last() == tile.lines.first()
            Direction.LEFT -> columns.first() == tile.columns.last()
            Direction.RIGHT -> columns.last() == tile.columns.first()
        }
        fun canConnect(tile: Tile): Direction? = Direction.values().firstOrNull { direction ->
            canConnect(tile, direction)
        }
    }

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
            val data = toParse.subList(i + 1, j)
            tiles.add(Tile(id, data))
            i = j + 1
        }
        return tiles
    }
}
