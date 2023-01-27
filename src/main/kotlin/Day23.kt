object Day23 {
    private const val input = "589174263"

    fun part1(): String {
        val state = State(input.map { it.toString().toLong() })
        state.moveMany(100)
        return state.label
    }

    fun part2(): Long {
        val state = State(oneMillionCups())
        state.moveMany(10_000_000)
        return state.hiddenStars
    }

    private fun oneMillionCups(): List<Long> = input.map { it.toString().toLong() } + (10L..1_000_000L)

    private class State(val cups: LinkedList<Long>, var currentCup: Long) {
        constructor(cups: Iterable<Long>) : this(LinkedList(cups), cups.first())

        val label: String
            get() = cups.find { it.value == 1L }!!.drop(1).joinToString("")

        val hiddenStars: Long
            get() {
                val oneCup = cups.find { it.value == 1L }!!
                return oneCup.next!!.value * oneCup.next!!.next!!.value
            }

        fun move() {
            val currentNode = cups.find { it.value == currentCup } ?: error("Cannot find current cup $currentCup")
            val pickedUp = cups.pickUpNext(currentNode, 3)
            var destinationCup = currentCup - 1L
            var destinationNode = cups.find { it.value == destinationCup }
            while (destinationNode == null) {
                destinationCup = if (destinationCup == 0L) {
                    cups.maxBy { it.value }!!.value
                } else {
                    destinationCup - 1
                }
                require(destinationCup != currentCup) { "We wrapped around looking for destination cup" }
                destinationNode = cups.find { it.value == destinationCup }
            }
            cups.insertAfter(destinationNode, pickedUp)
            currentCup = currentNode.next!!.value
        }
        fun moveMany(n: Int) {
            (0 until n).forEach { _ -> move() }
        }
    }

    private class Node<T>(val value: T) : Iterable<Node<T>> {
        var next: Node<T>? = null

        override fun iterator(): Iterator<Node<T>> = object : Iterator<Node<T>> {
            private var node = this@Node
            private var done = false

            override fun hasNext(): Boolean = !done
            override fun next(): Node<T> {
                val next = node
                node = node.next!!
                done = node == this@Node
                return next
            }
        }

        override fun toString(): String = value.toString()
    }

    private class LinkedList<T>(elements: Iterable<T> = emptyList()) : Iterable<Node<T>> {
        init {
            elements.forEach { add(it) }
        }

        var head: Node<T>? = null
            private set
        var tail: Node<T>? = null
        var size: Int = 0
            private set

        fun add(value: T) {
            val node = Node(value)
            if (head == null) {
                node.next = node
                head = node
                tail = node
            } else {
                tail!!.next = node
                node.next = head
                tail = node
            }
            size++
        }

        fun pickUpNext(node: Node<T>, n: Int): Node<T> {
            val pickedUp = node.next!!
            val lastPickedUp = pickedUp.elementAt(n - 1)
            val after = lastPickedUp.next!!
            lastPickedUp.next = pickedUp
            if (head in pickedUp) {
                head = after
                tail = node
            }
            node.next = after
            size -= n
            return pickedUp
        }

        fun insertAfter(node: Node<T>, newNode: Node<T>) {
            size += newNode.count()
            if (tail == node) {
                tail = newNode.last()
            }
            newNode.last().next = node.next
            node.next = newNode
        }

        override fun iterator(): Iterator<Node<T>> = head?.iterator() ?: EmptyIterator()

        override fun toString(): String = "[${joinToString()}]"

        private class EmptyIterator<T> : Iterator<Node<T>> {
            override fun hasNext(): Boolean = false
            override fun next(): Node<T> {
                error("No elements")
            }
        }
    }
}
