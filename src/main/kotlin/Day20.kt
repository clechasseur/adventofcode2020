import org.clechasseur.adventofcode2020.Day20Data
import org.clechasseur.adventofcode2020.Direction
import org.clechasseur.adventofcode2020.Pt
import org.clechasseur.adventofcode2020.move

object Day20 {
    private val input = Day20Data.input

    private val idRegex = """^Tile (\d+):$""".toRegex()

    fun part1(): Long {
        val tiles = input.toTiles()
        val corners = tiles.map { tile ->
            tile to Direction.values().mapNotNull { direction ->
                tiles.asSequence().filter {
                    it != tile
                }.flatMap {
                    it.orientationSequence()
                }.firstOrNull {
                    tile.canConnect(it, direction)
                }
            }.count()
        }.filter { (_, neighbours) ->
            neighbours == 2
        }.map { (tile, _) ->
            tile
        }
        require(corners.size == 4) { "There's ${corners.size} corners?!?" }
        return corners.fold(1L) { acc, tile -> acc * tile.id }
    }

    fun part2(): Int {
        var tiles = input.toTiles()
        var quilts = listOf(Quilt(tiles.first()))
        tiles = tiles.drop(1)
        while (tiles.isNotEmpty()) {
            val nextTile = tiles.first()
            tiles = tiles.drop(1)
            quilts = quilts.asSequence().flatMap { quilt ->
                quilt.edges.asSequence().flatMap { pt ->
                    nextTile.orientationSequence().mapNotNull { orientedTile ->
                        quilt.trySew(pt, orientedTile)
                    }
                }
            }.toList()
        }
        val quilt = quilts.first { it.square }
        quilt.yIndices.forEach { y ->
            val firstTile = quilt.tiles[Pt(quilt.xIndices.first, y)]!!
            firstTile.lines.indices.forEach { tileY ->
                println(quilt.xIndices.joinToString(" ") { x ->
                    quilt.tiles[Pt(x, y)]!!.lines[tileY]
                })
            }
            println()
        }
        return -1
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
    }

    private class Quilt(val tiles: Map<Pt, Tile>) {
        constructor(firstTile: Tile) : this(mapOf(Pt.ZERO to firstTile))

        val edges: List<Pt>
            get() = tiles.keys.flatMap { pt ->
                Direction.values().map { pt.move(it) }
            }.filter {
                it !in tiles
            }

        val xIndices: IntRange
            get() = tiles.keys.minBy { it.x }!!.x..tiles.keys.maxBy { it.x }!!.x
        val yIndices: IntRange
            get() = tiles.keys.minBy { it.y }!!.y..tiles.keys.maxBy { it.y }!!.y
        val square: Boolean
            get() = (xIndices.last - xIndices.first) == (yIndices.last - yIndices.first)

        fun trySew(pt: Pt, tile: Tile): Quilt? {
            val fits = Direction.values().map { direction ->
                pt.move(direction) to direction
            }.filter { (existingPt, _) ->
                existingPt in tiles
            }.all { (existingPt, direction) ->
                tile.canConnect(tiles[existingPt]!!, direction)
            }
            return if (fits) Quilt(tiles + (pt to tile)) else null
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
