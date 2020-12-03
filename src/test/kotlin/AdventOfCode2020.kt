import kotlin.test.Ignore
import kotlin.test.Test
import kotlin.test.assertEquals

class AdventOfCode2020 {
    class Day1Puzzles {
        @Test
        fun `day 1, part 1`() {
            assertEquals(1_010_299, Day1.part1())
        }

        @Test
        fun `day 1, part 2`() {
            assertEquals(42_140_160, Day1.part2())
        }
    }
}
