import org.clechasseur.adventofcode2020.Day19Data

object Day19 {
//    private val rules = Day19Data.rules
//    private val messages = Day19Data.messages

    private val rules = """
        42: 9 14 | 10 1
        9: 14 27 | 1 26
        10: 23 14 | 28 1
        1: "a"
        11: 42 31
        5: 1 14 | 15 1
        19: 14 1 | 14 14
        12: 24 14 | 19 1
        16: 15 1 | 14 14
        31: 14 17 | 1 13
        6: 14 14 | 1 14
        2: 1 24 | 14 4
        0: 8 11
        13: 14 3 | 1 12
        15: 1 | 14
        17: 14 2 | 1 7
        23: 25 1 | 22 14
        28: 16 1
        4: 1 1
        20: 14 14 | 1 15
        3: 5 14 | 16 1
        27: 1 6 | 14 18
        14: "b"
        21: 14 1 | 1 14
        25: 1 1 | 1 14
        22: 14 14
        8: 42
        26: 14 22 | 1 20
        18: 15 15
        7: 14 5 | 1 21
        24: 14 1
    """.trimIndent()

    private val messages = """
        abbbbbabbbaaaababbaabbbbabababbbabbbbbbabaaaa
        bbabbbbaabaabba
        babbbbaabbbbbabbbbbbaabaaabaaa
        aaabbbbbbaaaabaababaabababbabaaabbababababaaa
        bbbbbbbaaaabbbbaaabbabaaa
        bbbababbbbaaaaaaaabbababaaababaabab
        ababaaaaaabaaab
        ababaaaaabbbaba
        baabbaaaabbaaaababbaababb
        abbbbabbbbaaaababbbbbbaaaababb
        aaaaabbaabaaaaababaa
        aaaabbaaaabbaaa
        aaaabbaabbaaaaaaabbbabbbaaabbaabaaa
        babaaabbbaaabaababbaabababaaab
        aabbbbbaabbbaaaaaabbbbbababaaaaabbaaabba
    """.trimIndent()

    private val letterRuleRegex = """^(\d+): "(\w)"$""".toRegex()
    private val multiRuleRegex = """^(\d+): (\d+(?: \d+)*)$""".toRegex()
    private val orRuleRegex = """^(\d+): (\d+(?: \d+)*) \| (\d+(?: \d+)*)$""".toRegex()

    fun part1(): Int {
        val rulesMap = rules.toRules()
        val rule0 = rulesMap[0]!!
        return messages.lines().count {
            val match = rule0.matches(it, rulesMap)
            match != null && match == it.length
        }
    }

    fun part2(): Int {
        val rulesMap = rules.toRules().toMutableMap()
        rulesMap[8] = OrRule(MultiRule(listOf(42)), MultiRule(listOf(42, 8)))
        rulesMap[11] = OrRule(MultiRule(listOf(42, 31)), MultiRule(listOf(42, 11, 31)))
        val rule0 = rulesMap[0]!!
        return messages.lines().count {
            val match = rule0.matches(it, rulesMap)
            match != null && match == it.length
        }
    }

    private interface Rule {
        fun matches(message: String, rules: Map<Int, Rule>): Int?
    }

    private class LetterRule(val letter: Char) : Rule {
        override fun matches(message: String, rules: Map<Int, Rule>): Int? =
            if (message.isNotEmpty() && message[0] == letter) 1 else null
    }

    private class MultiRule(val multi: List<Int>) : Rule {
        override fun matches(message: String, rules: Map<Int, Rule>): Int? {
            return multi.map { rules[it]!! }.fold(0) { acc, rule ->
                rule.matches(message.substring(acc), rules)?.plus(acc) ?: return null
            }
        }
    }

    private class OrRule(val eitherThis: Rule, val orThat: Rule) : Rule {
        override fun matches(message: String, rules: Map<Int, Rule>): Int? =
            eitherThis.matches(message, rules) ?: orThat.matches(message, rules)
    }

    private fun String.toRules(): Map<Int, Rule> = lines().associate { line -> when {
        letterRuleRegex.matches(line) -> line.toLetterRule()
        multiRuleRegex.matches(line) -> line.toMultiRule()
        orRuleRegex.matches(line) -> line.toOrRule()
        else -> error("Not a valid rule: $line")
    } }

    private fun String.toLetterRule(): Pair<Int, Rule> {
        val match = letterRuleRegex.matchEntire(this) ?: error("Not a letter rule: $this")
        val (rule, letter) = match.destructured
        return rule.toInt() to LetterRule(letter.single())
    }

    private fun String.toMultiRule(): Pair<Int, Rule> {
        val match = multiRuleRegex.matchEntire(this) ?: error("Not a multi rule: $this")
        val (rule, multi) = match.destructured
        return rule.toInt() to MultiRule(multi.split(' ').map { it.toInt() })
    }

    private fun String.toOrRule(): Pair<Int, Rule> {
        val match = orRuleRegex.matchEntire(this) ?: error("Not an OR rule: $this")
        val (rule, eitherThisMulti, orThatMulti) = match.destructured
        return rule.toInt() to OrRule(
            MultiRule(eitherThisMulti.split(' ').map { it.toInt() }),
            MultiRule(orThatMulti.split(' ').map { it.toInt() })
        )
    }
}
