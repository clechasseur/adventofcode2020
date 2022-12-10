import org.clechasseur.adventofcode2020.Day19Data

object Day19 {
    private val rules = Day19Data.rules
    private val messages = Day19Data.messages

    private val letterRuleRegex = """^(\d+): "(\w)"$""".toRegex()
    private val proxyRuleRegex = """^(\d): (\d+)$""".toRegex()
    private val dualRuleRegex = """^(\d+): (\d+) (\d+)$""".toRegex()
    private val singleOrRuleRegex = """^(\d+): (\d+) \| (\d+)$""".toRegex()
    private val dualOrRuleRegex = """^(\d+): (\d+) (\d+) \| (\d+) (\d+)$""".toRegex()

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

    private class ProxyRule(val sub: Int) : Rule {
        override fun matches(message: String, rules: Map<Int, Rule>): Int? =
            rules[sub]!!.matches(message, rules)

        override fun toString(rules: Map<Int, Rule>): String = rules[sub]!!.toString(rules)
    }

    private class DualRule(val left: Int, val right: Int) : Rule {
        override fun matches(message: String, rules: Map<Int, Rule>): Int? {
            val leftRule = rules[left]!!
            val rightRule = rules[right]!!
            val leftMatch = leftRule.matches(message, rules) ?: return null
            return rightRule.matches(message.substring(leftMatch), rules)?.plus(leftMatch)
        }

        override fun toString(rules: Map<Int, Rule>): String =
            "${rules[left]!!.toString(rules)}${rules[right]!!.toString(rules)}"
    }

    private class OrRule(val eitherThis: Rule, val orThat: Rule) : Rule {
        override fun matches(message: String, rules: Map<Int, Rule>): Int? =
            eitherThis.matches(message, rules) ?: orThat.matches(message, rules)

        override fun toString(rules: Map<Int, Rule>): String =
            "${eitherThis.toString(rules)} | ${orThat.toString(rules)}"
    }

    private fun String.toRules(): Map<Int, Rule> = lines().associate { line -> when {
        letterRuleRegex.matches(line) -> line.toLetterRule()
        proxyRuleRegex.matches(line) -> line.toProxyRule()
        dualRuleRegex.matches(line) -> line.toDualRule()
        singleOrRuleRegex.matches(line) -> line.toSingleOrRule()
        dualOrRuleRegex.matches(line) -> line.toDualOrRule()
        else -> error("Not a valid rule: $line")
    } }

    private fun String.toLetterRule(): Pair<Int, Rule> {
        val match = letterRuleRegex.matchEntire(this) ?: error("Not a letter rule: $this")
        val (rule, letter) = match.destructured
        return rule.toInt() to LetterRule(letter.single())
    }

    private fun String.toProxyRule(): Pair<Int, Rule> {
        val match = proxyRuleRegex.matchEntire(this) ?: error("Not a proxy rule: $this")
        val (rule, sub) = match.destructured
        return rule.toInt() to ProxyRule(sub.toInt())
    }

    private fun String.toDualRule(): Pair<Int, Rule> {
        val match = dualRuleRegex.matchEntire(this) ?: error("Not a dual rule: $this")
        val (rule, left, right) = match.destructured
        return rule.toInt() to DualRule(left.toInt(), right.toInt())
    }

    private fun String.toSingleOrRule(): Pair<Int, Rule> {
        val match = singleOrRuleRegex.matchEntire(this) ?: error("Not an OR rule: $this")
        val (rule, eitherThis, orThat) = match.destructured
        return rule.toInt() to OrRule(ProxyRule(eitherThis.toInt()), ProxyRule(orThat.toInt()))
    }

    private fun String.toDualOrRule(): Pair<Int, Rule> {
        val match = dualOrRuleRegex.matchEntire(this) ?: error("Not an OR rule: $this")
        val (rule, eitherThisLeft, eitherThisRight, orThatLeft, orThatRight) = match.destructured
        return rule.toInt() to OrRule(
            DualRule(eitherThisLeft.toInt(), eitherThisRight.toInt()),
            DualRule(orThatLeft.toInt(), orThatRight.toInt())
        )
    }
}
