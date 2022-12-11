package org.clechasseur.adventofcode2020

object Day20Data {
    val input = """
        Tile 1321:
        .....#.##.
        ....##.###
        #..##.....
        .........#
        #.#...#...
        ##..#....#
        #..#.#....
        ......#.##
        ...#......
        .###.#####

        Tile 1327:
        .#.###.##.
        ###..#...#
        ##.....#.#
        #..#..##..
        ##..#..#..
        .#.##...#.
        #..#.#....
        ##.#......
        ...#......
        .###.#..#.

        Tile 3929:
        ######..##
        ....#.....
        #.....##.#
        #..#....##
        #........#
        ....##....
        .#...#..##
        #...#...##
        #.#.#...##
        #.#.#.#.##

        Tile 1699:
        ##.##..##.
        ##....###.
        .#.......#
        ...###.##.
        ###.#..#.#
        ##.###.###
        .#...#....
        ......##..
        ##........
        ..##...###

        Tile 3877:
        ###.......
        #.#.....##
        ##...#.###
        ....##..##
        ##.....##.
        .....###.#
        #..##..#.#
        ..........
        #....#.#.#
        .#.##....#

        Tile 1289:
        ####.#####
        ........#.
        ..#.....##
        #.......#.
        ...###...#
        ..#.....##
        ..#......#
        ##....###.
        ###....#..
        ......#..#

        Tile 2833:
        ..##.#.###
        .##.#.....
        .....#.###
        #..##.....
        #........#
        .#.......#
        .##...###.
        ..##....#.
        #....###.#
        #.###.#...

        Tile 2707:
        .....####.
        ....#..##.
        ....#.#..#
        ...#.....#
        ##.##..#..
        .##...#..#
        .#....#...
        #....##...
        ##...#.#..
        #.#...###.

        Tile 1303:
        #.##.###.#
        ..........
        #.....##..
        #........#
        ...#.#....
        ..#......#
        #.#..#..##
        #.#.......
        #.....###.
        .##....###

        Tile 3779:
        ##.##...#.
        #####....#
        ###..#....
        ......#..#
        ....#...#.
        ...#.##.#.
        #..#..##.#
        ..#..#....
        ..#.#....#
        #.##.#.#.#

        Tile 1637:
        ..#.######
        .........#
        ......#.##
        ..#.......
        #.#......#
        #......#..
        #........#
        #...#...#.
        ......#..#
        ###..###..

        Tile 3881:
        ...#.##...
        ......#.#.
        .........#
        ##..#.#..#
        #......#..
        #........#
        #.....#...
        ....#..###
        #...#..#.#
        .#.###..##

        Tile 1753:
        ##.#...###
        #.......#.
        #.#......#
        .........#
        ..#..#####
        ..#...###.
        ..#...#...
        .........#
        .........#
        ##.#.#####

        Tile 2311:
        ##..#####.
        #.......#.
        #.#....#..
        .........#
        ..#..#.#.#
        #..##....#
        ##....#.##
        ...#....##
        .......##.
        ..##.#...#

        Tile 3677:
        ..#####...
        .#..##..#.
        #........#
        #.....####
        ###....#.#
        .#..#.....
        ##..#.....
        #........#
        ..........
        ....#.....

        Tile 3371:
        #...#.####
        ..........
        #...#....#
        ..#.......
        ....#..#..
        ..........
        #.#.####.#
        ..#....###
        ..##.....#
        #...#..###

        Tile 1093:
        ...#....##
        ##.......#
        ###.#...#.
        ..#.#.....
        .......#..
        ##.......#
        ..#.##....
        ##....#..#
        ##.......#
        .#...#....

        Tile 1193:
        .###....#.
        ..#.#.....
        ..#.##.##.
        .###...#.#
        #.....#...
        ...#.###.#
        .....#..#.
        #....##.##
        .#.#.#....
        ####...###

        Tile 2699:
        ....#.####
        ......#..#
        ...#...#.#
        #.....#.##
        #....#...#
        #....#...#
        #..##.....
        .#...#..##
        ..#..#.#.#
        #.......##

        Tile 2069:
        .#...#..##
        ..#..#...#
        ....##....
        ..#.......
        .......#..
        ##.##.##..
        .#........
        ........##
        #..##..###
        .###..#..#

        Tile 3739:
        .##.####.#
        #...#....#
        #....#....
        .#....##..
        ...##...##
        ....##.#.#
        .#.....#..
        #......#.#
        ...#...#.#
        ######.#.#

        Tile 1871:
        #.####..#.
        .###.#....
        .........#
        #...#....#
        .......#.#
        #......##.
        #......#.#
        .##.#..#.#
        .....##.##
        ##.#.##...

        Tile 1483:
        ..##..####
        #.#.......
        #...#....#
        #####..#..
        #....#...#
        #.......##
        ...#.....#
        ####......
        #.###..#..
        ..####.###

        Tile 3343:
        .##.#.##..
        #.#..##.#.
        #..#.##...
        .#...##..#
        ......#..#
        ##..##....
        ##.#......
        ##....#...
        #....#...#
        ###...#...

        Tile 1553:
        #...#....#
        #..#.#.#..
        #....###..
        ##....#...
        ...##...#.
        ....#....#
        #.#..#...#
        .......##.
        .#.......#
        #.####...#

        Tile 2393:
        #..###....
        ##.#..##..
        #...##....
        #.........
        .#.....#.#
        ....#....#
        .##.#.#...
        ##...#...#
        .###..#.##
        ...###..##

        Tile 3061:
        ##.#.....#
        #....#.#..
        ........##
        ##...#...#
        #.........
        ..#..#....
        ##.#.#...#
        ##.#......
        .###.#...#
        .####..##.

        Tile 3797:
        #.#..#..#.
        ..##..#...
        ..#...##.#
        #...#...#.
        ###......#
        ...#.###..
        #...#....#
        ....#.#.##
        ........##
        ......#...

        Tile 2593:
        ..##.###.#
        #..##.....
        #.#..#..##
        #.#...#..#
        ........##
        ......##.#
        #.#.#.#.#.
        ..##..#...
        ...#.#....
        ###..#.###

        Tile 1907:
        .##.#..###
        ####.##.##
        ..#....#..
        ..####...#
        ...##.....
        #.....#.#.
        ....#.###.
        ...#......
        #...#....#
        #######...

        Tile 2557:
        #.###..#.#
        #.....#..#
        .#........
        #...#.##..
        #......#..
        ##......#.
        #..##....#
        #......#..
        #...###.#.
        #.##......

        Tile 1499:
        ####...#.#
        ##..#.##..
        #.#..#....
        .#....##.#
        ....#..##.
        ##........
        #.#.#.....
        .##..#...#
        ..##.....#
        ##...#####

        Tile 1409:
        .#...###.#
        ..##.#...#
        #.........
        ...##.....
        .#....#...
        .##.....#.
        ..##....#.
        #..#...#.#
        #.......##
        .#.#....##

        Tile 2801:
        .#.#.##...
        #.#.......
        #....#...#
        #.....#..#
        .##.##.###
        .#.##.###.
        ##.##.##.#
        .#...#....
        .#.#.##..#
        .###.#.##.

        Tile 2971:
        .......#.#
        ..##..#...
        ..##..##.#
        ..###.####
        ....#..#..
        #..#....#.
        ##....#..#
        ##..#.....
        .#..#.#.##
        .##...#.##

        Tile 2789:
        ###.#.#...
        #..#....##
        ##...##.#.
        .....###..
        ...##.....
        ...##....#
        ....##.#.#
        #..####...
        ####....##
        ..#.#...##

        Tile 1249:
        #..##.###.
        ..#....#..
        ......#..#
        .....#...#
        #.#...####
        #.#..#..##
        ...#.#..#.
        #.##...#.#
        ##..#....#
        ..###.###.

        Tile 2179:
        .#.#.##.#.
        #.##.###.#
        #.#.......
        .....#.#.#
        #.....#.#.
        ....#....#
        ...#....##
        ...#..###.
        .#........
        ######.#..

        Tile 2879:
        ......####
        ###..#...#
        .#.#..##..
        ..###...##
        ....#.##..
        ....#.#...
        .....#.#.#
        ....####.#
        ..#...#..#
        .##.###.#.

        Tile 3463:
        ...#.###..
        ..#.####.#
        ..###.....
        ...##...#.
        #.##..#.#.
        ..##.##...
        .#.#.....#
        .##..#...#
        ......##.#
        .#.##...#.

        Tile 1901:
        .#.#....##
        #....#...#
        .###..#.##
        #...#.##..
        #..#.#....
        ##..##...#
        ..#.......
        .........#
        #......#.#
        #..#....##

        Tile 3307:
        ......#...
        #........#
        ..#.#..#.#
        ....###.#.
        #...#.#...
        .#####....
        ..#......#
        .#........
        #..#.#.#.#
        ####.###..

        Tile 2719:
        .####..##.
        ...#......
        #.........
        #..##.#.##
        #...#.#..#
        #.....#.#.
        ..#....##.
        #.........
        #.#..##..#
        ...##..#..

        Tile 1439:
        .###.#....
        #....##...
        ...#......
        ...#......
        #.........
        ..........
        .#......##
        ........##
        #...##..#.
        .#.###.#..

        Tile 2917:
        ##.#.#..##
        ##........
        .......#.#
        ...##....#
        ##..##....
        .###...#..
        ..###.#...
        #.#..#..##
        ..........
        ##........

        Tile 1039:
        .##.....#.
        #.........
        #..#..#..#
        ....##.#..
        ##....#..#
        #.#.......
        ....#.....
        #..#....#.
        #...#....#
        ##...#####

        Tile 3251:
        ...###..##
        ####......
        ...###.#.#
        ....#.####
        #####.##.#
        .....##..#
        ..#..#....
        #.......##
        #....#.##.
        #.#.##..##

        Tile 1451:
        ..##...##.
        ..##...###
        ..........
        #.........
        #.###...#.
        ##.#......
        ...#....##
        #.##......
        ..#.......
        ....###.#.

        Tile 2111:
        ...#..#.##
        #....##.##
        #...##.#.#
        #...##....
        #...#.#.#.
        .#..#....#
        #.#.....##
        ......##..
        ..##.#..##
        .######.##

        Tile 2683:
        .#####.#.#
        .#..##....
        #.#......#
        ....#..#.#
        ...#.####.
        .#........
        ...#......
        #..#..#..#
        #.........
        ##..######

        Tile 3517:
        .###.#.#..
        #.......##
        #........#
        #....#...#
        #.#......#
        #....#....
        #......#.#
        #.........
        .#.#.###..
        .....#.##.

        Tile 3659:
        .###..####
        .#........
        ###..#...#
        .....#..##
        ....#.#..#
        #....###..
        #.....#...
        #.##.#...#
        #.#...###.
        #..#.####.

        Tile 2131:
        .##..#.#..
        #.#.....##
        ####....#.
        .#........
        ...#..#..#
        ##..#..###
        #....##.##
        ........##
        #...###...
        ....##.##.

        Tile 1873:
        #####..#.#
        .......#.#
        ###......#
        #.#.#..#.#
        .........#
        ..#....#.#
        ..........
        #...#.##.#
        #....#.#.#
        #####..###

        Tile 3331:
        .#######..
        #.#...##..
        ##..##.##.
        .....##.#.
        ..#......#
        .....#...#
        #.#...#..#
        .....#....
        ##......##
        .......#..

        Tile 2467:
        .#.#.#..#.
        ......#..#
        ......#...
        .#...###.#
        .#..#....#
        ..........
        #.....##..
        .#..#.#..#
        ##....##..
        ....#.#.#.

        Tile 2837:
        ...#..##.#
        .....#..##
        ...#.#.###
        #..#....#.
        #.#.#.....
        .......#.#
        ##..#....#
        #....#.#..
        #.......##
        .###..####

        Tile 3089:
        ######.#.#
        #..#....##
        ...#..##.#
        ..#.###...
        ....###...
        ....#..#..
        .......##.
        ....#..#..
        ..##...#.#
        .#.#.#..#.

        Tile 2381:
        ..##.#..#.
        .#.#..#..#
        ..#.......
        #.##.#.##.
        #..#......
        .#....#..#
        ....#..#.#
        .#.....###
        #...#....#
        #####.##..

        Tile 2083:
        #.....#.#.
        .#......#.
        .##..#..#.
        .#...#.#..
        ...#....#.
        #......#.#
        .#.....##.
        .#....###.
        .##.....##
        .#.#..#...

        Tile 1277:
        ....##.#.#
        ...###.##.
        #...##.#.#
        ....##..#.
        ...#.....#
        #....#.#..
        #...#...##
        #..#......
        ....#....#
        ##.######.

        Tile 2851:
        ###...#...
        #....#..##
        ..#...#.#.
        .#.##.#...
        #.##.....#
        #...#.#..#
        ###..#.#.#
        #.####.#..
        .....#..##
        ##.#..#.#.

        Tile 1867:
        .#.#####..
        ##......#.
        #.......##
        #.......#.
        #..##.....
        ..........
        #.........
        ##...#...#
        ...#..##.#
        ...####.#.

        Tile 3889:
        .#.#.#...#
        #...#.....
        #......#.#
        #.#.....##
        #.....#...
        #.###.....
        #........#
        .....#....
        ..........
        .##...####

        Tile 3943:
        #..###.###
        #..#....#.
        .....#..##
        ###..#..#.
        .#.##.###.
        ##....#.#.
        ....#.....
        .#....#...
        #.....#..#
        #.#.###.##

        Tile 3613:
        ###.#...##
        #....##...
        ..#...#.#.
        #...#...##
        #.##......
        ..#.......
        #..#..#.#.
        #.........
        ##.#...#..
        #.#...###.

        Tile 1471:
        ...#.#....
        .........#
        #.........
        #....##.##
        .#...##...
        ..#.#..#.#
        .....#...#
        #...#..#.#
        ##....#...
        #.####....

        Tile 1627:
        ##..##.###
        #..#.....#
        .##.##..#.
        .#.....#..
        ...#.###..
        #.#....#.#
        .###...###
        .#####.#..
        ###......#
        ..#.#.#.#.

        Tile 3581:
        #.#..##...
        ..........
        ..........
        ....##..#.
        #........#
        #...##....
        ....#...#.
        ...###....
        ..##......
        .#..###.##

        Tile 2677:
        .#.###...#
        .#.##....#
        ##.##.....
        #......###
        #........#
        ......#.##
        .#........
        .##....#.#
        .##....##.
        ...######.

        Tile 3253:
        .#..#..#.#
        ..#......#
        ..###...##
        #.........
        .##....#..
        ...##....#
        #..#.....#
        ..#.......
        #....#.##.
        #.##.##.#.

        Tile 2027:
        .#.#......
        ..#..#..#.
        #.#......#
        .....####.
        ..........
        .#.#......
        #.#.....##
        ...#.#.#.#
        .#........
        ##...#..##

        Tile 1801:
        #.#.#.##..
        #......#.#
        .#...#....
        #..#.##..#
        #.###.##.#
        #.#..#.##.
        ....##..#.
        ...##....#
        .......#.#
        ....#..###

        Tile 2377:
        ###.##...#
        .###.#..##
        ...#..##.#
        #...##....
        ...#.....#
        ##........
        .#.#..#..#
        .......#.#
        #........#
        ....##.#.#

        Tile 3449:
        ###.##..#.
        .##.#.##..
        ..##..#.#.
        .#..#..#..
        #.......#.
        .#..#....#
        #...#..#.#
        ...###...#
        #.##.#.###
        #..###..#.

        Tile 1721:
        ..##..##.#
        ........##
        ###...#..#
        ####...#..
        .##...###.
        .#.#..#..#
        .#.......#
        #....##.##
        #.#.##...#
        ..##..#..#

        Tile 1787:
        ##.#.##...
        #.....#...
        ##..##....
        .#..#....#
        #......###
        ......#...
        #.........
        ...#...###
        .#...#....
        .#.###..#.

        Tile 1777:
        .....#.#..
        .#.#.....#
        ...#..#...
        #####.####
        ...##.#.#.
        ###.#....#
        #.#.#...##
        #...###...
        .#..#...##
        .#.##.##..

        Tile 3461:
        .....###.#
        #.#.......
        #...#....#
        #......#.#
        #....####.
        ##....#...
        ....###.##
        #.#.....##
        #........#
        .##.....#.

        Tile 2539:
        .##.###..#
        #.#...#...
        #.......#.
        .......#.#
        #.......##
        ......##..
        #........#
        .##.#..###
        #.#....###
        ##.##.##..

        Tile 1823:
        .#.##...##
        ####...#.#
        #.#..#...#
        .#...#....
        #.#.......
        ..##.#....
        ...#......
        #..#...##.
        #.#.#....#
        .##..###..

        Tile 1697:
        #.###.###.
        .#.#...#..
        #.#....#.#
        .###..##..
        ..#..##.##
        #......#.#
        #.#####...
        #..###.#..
        ##.....###
        .####.#.##

        Tile 1783:
        #.##..##..
        ##...#..##
        .#.....###
        ...#..#.##
        ..#.......
        .##....#.#
        ..#..#..##
        .#.......#
        ...#..#..#
        ###.#.####

        Tile 1367:
        ##.#.#.###
        ...#.#...#
        ....##...#
        ......#...
        ......##..
        #....###.#
        ....#.....
        #.#.#..#.#
        #....#....
        ##..###..#

        Tile 3671:
        ....#...##
        #...#..#..
        .#........
        ..........
        #.#...#...
        #...#.#..#
        ...#.##..#
        #.......#.
        ...#...#.#
        #..#....##

        Tile 1373:
        .#..##.#..
        .........#
        .#.#..#.#.
        ..........
        #...##....
        .........#
        #.#.##...#
        .#.##....#
        ##........
        ...#######

        Tile 3571:
        ##..##.#..
        .......#.#
        #....#.#.#
        #.#.#..#..
        #...#.###.
        #..#.#####
        ##..####..
        .........#
        .....#...#
        .##.#...##

        Tile 1949:
        #.##..#..#
        ...##.#...
        ##.....#..
        #......#.#
        #.......##
        ##.##....#
        ....#.....
        #.#.......
        ##..##...#
        ###.###...

        Tile 1759:
        ..##.##.#.
        ##.#....#.
        #.#.##....
        #........#
        ..#..#..#.
        .#..####.#
        #.......#.
        ......#..#
        ...#....#.
        .#.#.#####

        Tile 3407:
        #..#..##..
        #...##....
        .##.#####.
        ####..#.##
        #.#.##...#
        #...#..#..
        .#........
        #.##....##
        #..#...#.#
        ##.##.###.

        Tile 3557:
        #.....####
        .........#
        ###......#
        #.##..#..#
        #.....#.##
        #..#....##
        .##....#..
        #......#.#
        .....#..##
        #.#..##...

        Tile 2423:
        #.##..#...
        ......#.#.
        ##.#..####
        #...#.....
        ...###...#
        #.........
        #...#....#
        .......##.
        ###....##.
        .##.##.#..

        Tile 2777:
        .#.#####..
        #...#.....
        ##....#..#
        #......##.
        .#.#..#..#
        ..#.#...##
        #....##...
        ..........
        #...#.####
        #..#...#..

        Tile 2309:
        ##.###..##
        .#.......#
        ...#..#.##
        #....###.#
        .....#...#
        #.###...#.
        .#.....#.#
        ..#..#..#.
        #.#..#.#.#
        .####.#..#

        Tile 2417:
        #.####.##.
        ##....#...
        #.#.##....
        #...#.####
        .###....##
        #.#..#...#
        #.#....###
        #.#......#
        ......#...
        ...#..##..

        Tile 1619:
        ..#.#..###
        #....##..#
        ##..#....#
        #..##...##
        #.#.#..##.
        ##..##..##
        #..#.#....
        ..#...##..
        #.......##
        .#..###.##

        Tile 2797:
        #.##...#.#
        #...#....#
        ..##.#.#.#
        #.........
        .#....#...
        .#.#..##..
        #..##.#..#
        #....#..#.
        .#...#...#
        ##.#.#.###

        Tile 1663:
        #.####..##
        .....##..#
        ..#...#..#
        ..#.###.#.
        ##.#.#####
        #..#......
        #....#....
        .##.....##
        ..........
        .##..##..#

        Tile 2749:
        ....#..#.#
        #...#..#..
        ..#......#
        ...##.#...
        .##.#....#
        #.#..#....
        #...#....#
        ..#...#.##
        ..##....##
        #..#####..

        Tile 2389:
        ###.####..
        #.#......#
        ..#..#..##
        .#...###..
        .........#
        #.......##
        ..#.##....
        #.....#..#
        ##.......#
        ##.#..#..#

        Tile 2473:
        .##....#.#
        ..........
        #####.##.#
        #....###..
        #.........
        ..##..#.##
        .#..#.....
        #...#.#...
        .......#.#
        .#.#..#..#

        Tile 1021:
        .#.####..#
        .....#.#.#
        #.......#.
        ##.#.#...#
        .#.#...#..
        .#...#...#
        ..#..##...
        ....#....#
        .###..##..
        ##.###..##

        Tile 2213:
        ###..##.#.
        ##.###..##
        #....#...#
        #..##.#...
        ......#.#.
        #........#
        #..###....
        .###.###.#
        ##...#....
        ######....

        Tile 3821:
        .###.##.#.
        #....#...#
        ##.#.#...#
        ..#...#..#
        ...##.....
        #..###..#.
        .#....#...
        ....#.#..#
        ........##
        #.#.##.#..

        Tile 3793:
        ##...#..##
        #....#....
        ##.#.#...#
        #.##...#..
        .##..#..##
        .#..##...#
        ...#.....#
        .....#..#.
        ..##...#.#
        ..#.##.#.#

        Tile 2099:
        .#....#.##
        ...##..#..
        #........#
        ........##
        ...##.....
        #..##.#...
        #..##..#..
        .##.##....
        #.##...#..
        ..###..##.

        Tile 2663:
        ###.#.##.#
        .........#
        ...###....
        ####.#.#.#
        ##.#..#.##
        #.....#.##
        .#.#....#.
        .#.#....#.
        #....##.#.
        ###.##..#.

        Tile 1607:
        ##.#...#.#
        #.##......
        ##.#.....#
        ###......#
        ..##...#..
        ..##...##.
        ...#......
        #.#.......
        ..#.#...##
        ....#####.

        Tile 2687:
        .#...##.#.
        #........#
        ....#.##..
        ......##.#
        ......#...
        #...#.##..
        #.#.####.#
        ...##.....
        ..#.......
        ###.###..#

        Tile 2531:
        .#.#..#...
        ##.#....#.
        ##.##...##
        .#..#.##.#
        ##........
        ##......##
        #......###
        #....#...#
        ##......#.
        #.#..##..#

        Tile 1999:
        #.....####
        #.###....#
        #.##...#..
        ..####..##
        #.#.......
        ##..#.#..#
        .##.#..###
        ..##.#....
        ....##.###
        .....##.##

        Tile 2671:
        .##..##.#.
        ..#...##..
        #.#...##..
        ##.#..#..#
        ..........
        #......#.#
        .....#....
        #.#....#.#
        .......##.
        #....###..

        Tile 2549:
        #...###.#.
        ...##.....
        .......##.
        .##.....##
        #....##.##
        .#.#....##
        .#......#.
        .#.#...#.#
        ###.......
        ..#.#.#..#

        Tile 3593:
        ##...#...#
        #....#..#.
        #.....#...
        .#.......#
        ##....#.#.
        #..##..##.
        #.....#...
        .........#
        ..#......#
        ..##.#....

        Tile 1789:
        .##.......
        #...#.....
        .....#..##
        ..#..#....
        .#....#.##
        ...#.....#
        #.#..#...#
        .##.#...#.
        #.##.....#
        ....#..##.

        Tile 2341:
        #.....##..
        #..##.#.#.
        #.#....#.#
        ......#...
        ###.....#.
        #...#...#.
        .....#.#.#
        ..##...#.#
        ........#.
        #..####...

        Tile 2903:
        ####..#...
        ##.......#
        #.........
        .##.......
        .#.....#.#
        ###.#..#.#
        ..##.##..#
        ........##
        .#.....#..
        #.#..####.

        Tile 1091:
        .#####..##
        .#...#.#..
        ...####.#.
        ......#..#
        #..#.###.#
        ..........
        .....#...#
        .#........
        #.#..#....
        .#.#.#.#..

        Tile 1481:
        #.#.#.##.#
        ..#...#.##
        ..#...##.#
        ..##.#..##
        ##..#####.
        ###..#.#.#
        #....#....
        ........#.
        .#.#....#.
        .##..###.#

        Tile 1433:
        ######....
        #...#..##.
        ..........
        #........#
        .##.#..#..
        ..#..##.#.
        #...#...##
        .#......##
        ...###...#
        #..##..###

        Tile 3967:
        #.####.#..
        ...#..##.#
        #..#.#..##
        .#..##.###
        #...###..#
        #.#...#.##
        #.#...#.#.
        ..#..#.#.#
        ..#..#....
        .##...#.##

        Tile 2153:
        ..#####..#
        #..#.#....
        #........#
        #......#..
        ##........
        ..........
        #......##.
        ..........
        ##..#.#..#
        .##..#...#

        Tile 3299:
        ....####..
        ..#..#....
        #...##.#.#
        ##..##...#
        ##..#.#..#
        ..#.#.....
        ...#.#....
        #.....#...
        ##....#.##
        #...##.#..

        Tile 1601:
        ..###.##..
        #....#..#.
        .#.#......
        ..#....##.
        #...##.#..
        .#..####.#
        .#...###..
        #.......##
        #...#.....
        .#....##..

        Tile 2003:
        ###...##.#
        #.....#...
        .##....#..
        #.####..##
        #.........
        ##.#......
        ......####
        ##..#..##.
        ##.#......
        ##....##..

        Tile 1571:
        .#....##..
        #.......##
        #...#....#
        .#..#.....
        ##..#....#
        .....###..
        #.........
        ....#..#..
        ...#......
        .......###

        Tile 2909:
        ..##..#...
        ##.#.#....
        ....###...
        ...##.#...
        ##..#.#.#.
        .#.#..#...
        ..#..#.##.
        ##.......#
        #...##..#.
        .#..#.#...

        Tile 2113:
        #####..#..
        .#...##...
        ......####
        .#...#....
        ...##.#.#.
        .#....####
        ...##..#..
        #..#.#.#.#
        #.....#..#
        ###..#.#.#

        Tile 2503:
        .#..#.#...
        #..##..#..
        ##..#.#...
        .#.#.##..#
        #.#...##..
        .#........
        #......#..
        .####..##.
        .##...#..#
        .##..##...

        Tile 1231:
        .#.#..##.#
        .....#..##
        #..#.##...
        ####....#.
        ...###.#..
        #...#.#.#.
        ....##.#.#
        #.##......
        ###......#
        .#....##.#

        Tile 1237:
        #.#..###.#
        #.#..#..##
        #.....#..#
        .......##.
        #....#.##.
        .#...###.#
        .###.#.##.
        ##...#...#
        ###.......
        .#...#.#..

        Tile 2729:
        #.#.##..##
        ...#####..
        ...#.##...
        #..#.#..#.
        #.....#..#
        .#.......#
        .....#.#..
        ##....##..
        ##....##..
        ...###....

        Tile 1609:
        .###.##...
        .##..##...
        #......#.#
        .........#
        ..##...#.#
        ##..#.#...
        ..##....#.
        #..#..#...
        #.........
        ###.#.##.#

        Tile 2819:
        ..####....
        ...#..#..#
        ..#.##....
        ...#.....#
        ...#...#.#
        #.....#...
        #.......#.
        ..........
        #.#.......
        ..##....##

        Tile 1621:
        ##..#.####
        .#...#####
        .....##...
        ..#.....##
        ...#...#.#
        ...#..##.#
        #.#.#.#.##
        .#.#.##..#
        #...#....#
        .##.#..###

        Tile 1987:
        #.#..##..#
        ##..##..#.
        ...##..#..
        ##....##.#
        .....#....
        #.....##..
        ##..#....#
        ..#......#
        ###.#..#.#
        #..##.#.##

        Tile 1951:
        .#..#..#..
        ##.....###
        #.........
        #........#
        ....#.....
        ..##..###.
        .##.#..##.
        #.#.......
        ##..#.#..#
        .#........

        Tile 2137:
        ..#...#.#.
        #......#.#
        .......#.#
        ...#.....#
        ...##.##.#
        ...#......
        ...###....
        #......#..
        .#...##..#
        .###.#....

        Tile 2063:
        #....#.###
        ......#.#.
        ###.##....
        .#.##.#.#.
        ........##
        .....####.
        .###.#...#
        ..#####...
        .#..##.#.#
        .##...####

        Tile 1213:
        #......##.
        .#.##.#..#
        #.#.#.#.##
        #.#..#.###
        ##.#.#...#
        .###..#..#
        .#.......#
        ##..#.....
        #####.##.#
        ...###....

        Tile 2543:
        ###.#..#.#
        #....#.#.#
        ##..#....#
        #..#......
        ##.###.#..
        .#..#....#
        .....#.#..
        #..#...#..
        #.......##
        .#####....

        Tile 2857:
        .###.###.#
        #..#.#....
        ...##...#.
        .#..#..###
        ...#...#..
        #.#....#..
        ..#.#.#.#.
        #..##....#
        ...#..#...
        .##......#

        Tile 1153:
        ...##.#...
        ....#....#
        #.......##
        ###.....##
        ..#....#..
        #..##....#
        .#.....##.
        .##.......
        #..#.#..##
        ......##..

        Tile 1217:
        ..##.#...#
        #.##.##..#
        ##....#.#.
        ..##.#.###
        ###.......
        #........#
        ....##...#
        #...#.#..#
        ...#.#..##
        ....##.##.

    """.trimIndent()
}
