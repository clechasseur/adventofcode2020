object Day23 {
    private const val input = "589174263"

    fun part1(): String = generateSequence(State(input.map { it.toString().toInt() })) { prevState ->
        prevState.next()
    }.elementAt(100).label

    private class State(val cups: LinkedList<Int>, val currentCup: Int) {
        constructor(cups: Iterable<Int>) : this(LinkedList(cups), cups.first())

        val label: String
            get() = cups.find { it.value == 1 }!!.drop(1).joinToString("")

        fun next(): State {
            val newCups = LinkedList(cups)
            val currentNode = newCups.find { it.value == currentCup } ?: error("Cannot find current cup $currentCup")
            val pickedUp = newCups.pickUpNext(currentNode, 3)
            var destinationCup = currentCup - 1
            var destinationNode = newCups.find { it.value == destinationCup }
            while (destinationNode == null) {
                if (destinationCup == 0) {
                    destinationCup = 10
                }
                destinationCup--
                require(destinationCup != currentCup) { "We wrapped around looking for destination cup" }
                destinationNode = newCups.find { it.value == destinationCup }
            }
            newCups.insertAfter(destinationNode, pickedUp)
            return State(newCups, currentNode.next!!.value)
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

        constructor(elements: LinkedList<T>) : this(elements.map { it.value })

        var head: Node<T>? = null
            private set

        fun add(value: T) {
            val node = Node(value)
            if (head == null) {
                node.next = node
                head = node
            } else {
                var last = head
                while (last!!.next != head) {
                    last = last.next
                }
                last.next = node
                node.next = head
            }
        }

        fun pickUpNext(node: Node<T>, n: Int): Node<T> {
            val pickedUp = node.next!!
            val lastPickedUp = pickedUp.elementAt(n - 1)
            val after = lastPickedUp.next!!
            lastPickedUp.next = pickedUp
            if (head in pickedUp) {
                head = after
            }
            node.next = after
            return pickedUp
        }

        fun insertAfter(node: Node<T>, newNode: Node<T>) {
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
