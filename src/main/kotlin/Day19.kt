import org.clechasseur.adventofcode2020.Day19Data

object Day19 {
    private val rules = Day19Data.rules
    private val messages = Day19Data.messages

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

    private interface Rule {
        fun matches(message: String, rules: Map<Int, Rule>): Int?
        fun toString(rules: Map<Int, Rule>): String
    }

    private class LetterRule(val letter: Char) : Rule {
        override fun matches(message: String, rules: Map<Int, Rule>): Int? =
            if (message.isNotEmpty() && message[0] == letter) 1 else null

        override fun toString(rules: Map<Int, Rule>): String = letter.toString()
    }

    private class MultiRule(val multi: List<Int>) : Rule {
        override fun matches(message: String, rules: Map<Int, Rule>): Int? {
            return multi.map { rules[it]!! }.fold(0) { acc, rule ->
                rule.matches(message.substring(acc), rules)?.plus(acc) ?: return null
            }
        }

        override fun toString(rules: Map<Int, Rule>): String =
            multi.joinToString("") { rules[it]!!.toString(rules) }
    }

    private class OrRule(val eitherThis: Rule, val orThat: Rule) : Rule {
        override fun matches(message: String, rules: Map<Int, Rule>): Int? =
            eitherThis.matches(message, rules) ?: orThat.matches(message, rules)

        override fun toString(rules: Map<Int, Rule>): String =
            "${eitherThis.toString(rules)} | ${orThat.toString(rules)}"
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
