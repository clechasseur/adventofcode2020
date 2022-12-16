object Day22 {
    private val deck1 = listOf(
        24,
        22,
        26,
        6,
        14,
        19,
        27,
        17,
        39,
        34,
        40,
        41,
        23,
        30,
        36,
        11,
        28,
        3,
        10,
        21,
        9,
        50,
        32,
        25,
        8
    )
    private val deck2 = listOf(
        48,
        49,
        47,
        15,
        42,
        44,
        5,
        4,
        13,
        7,
        20,
        43,
        12,
        37,
        29,
        18,
        45,
        16,
        1,
        46,
        38,
        35,
        2,
        33,
        31
    )

    fun part1(): Int = playGame(Player(1, deck1), Player(2, deck2)).first().score

    private data class Player(val id: Int, val deck: List<Int>) {
        val score: Int
            get() = deck.reversed().withIndex().sumBy { (it.index + 1) * it.value }

        fun winCards(cards: List<Int>): Player = copy(deck = deck.drop(1) + cards)
        fun loseTopCard(): Player = copy(deck = deck.drop(1))
    }

    private fun playOneRound(vararg players: Player): List<Player> {
        val winnerLosers = players.sortedByDescending { it.deck.first() }
        return listOf(winnerLosers.first().winCards(winnerLosers.map { it.deck.first() })) +
                winnerLosers.drop(1).map { it.loseTopCard() }
    }

    private fun playGame(vararg players: Player): List<Player> = generateSequence(players.toList()) { prevPlayers ->
        if (prevPlayers.all { it.deck.isNotEmpty() }) playOneRound(*prevPlayers.toTypedArray()) else null
    }.last()
}
