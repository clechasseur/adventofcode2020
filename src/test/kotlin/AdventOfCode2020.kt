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

    class Day2Puzzles {
        @Test
        fun `day 2, part 1`() {
            assertEquals(655, Day2.part1())
        }

        @Test
        fun `day 2, part 2`() {
            assertEquals(673, Day2.part2())
        }
    }

    class Day3Puzzles {
        @Test
        fun `day 3, part 1`() {
            assertEquals(148L, Day3.part1())
        }

        @Test
        fun `day 3, part 2`() {
            assertEquals(727_923_200L, Day3.part2())
        }
    }

    class Day4Puzzles {
        @Test
        fun `day 4, part 1`() {
            assertEquals(237, Day4.part1())
        }

        @Test
        fun `day 4, part 2`() {
            assertEquals(172, Day4.part2())
        }
    }

    class Day5Puzzles {
        @Test
        fun `day 5, part 1`() {
            assertEquals(908, Day5.part1())
        }

        @Test
        fun `day 5, part 2`() {
            assertEquals(619, Day5.part2())
        }
    }

    class Day6Puzzles {
        @Test
        fun `day 6, part 1`() {
            assertEquals(7120, Day6.part1())
        }

        @Test
        fun `day 6, part 2`() {
            assertEquals(3570, Day6.part2())
        }
    }

    class Day7Puzzles {
        @Test
        fun `day 7, part 1`() {
            assertEquals(287, Day7.part1())
        }

        @Test
        fun `day 7, part 2`() {
            assertEquals(48_160, Day7.part2())
        }
    }
}
