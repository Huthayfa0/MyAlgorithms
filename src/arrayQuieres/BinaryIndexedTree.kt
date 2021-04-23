package arrayQuieres

/**
 * binary indexed tree or a Fenwick tree 2 can be seen as a dynamic variant
of a prefix sum array. It supports two O (log n ) time operations on an array:
processing a range sum query and updating a value.
 */
class BinaryIndexedTree(var array: IntArray) {
    private val sumIndexedTree = IntArray(array.size + 1)

    init {
        for (k in 1 until sumIndexedTree.size) {
            sumIndexedTree[k] += array[k - 1]
            val x = (k and (-k)) + k
            if (x < sumIndexedTree.size)
                sumIndexedTree[x] += sumIndexedTree[k]
        }
    }

    fun update(index: Int, x: Int) {

        if (array.size > index && index >= 0) {
            var k = index + 1
            val v = x - array[index]
            array[index] = x
            while (k <= array.size) {
                sumIndexedTree[k] += v
                k += k and -k
            }
        }
    }

    private fun sum0ton(n: Int): Int {
        var x = n
        var sum = sumIndexedTree[n]
        while (x > 0) {
            x -= (x and (-x))
            sum += sumIndexedTree[x]
        }
        return sum
    }

    fun sum(start: Int = 0, end: Int = array.size): Int = when {
        start < 0 && end > array.size -> sum()
        start < 0 -> sum(end = end)
        end > array.size -> sum(start = start)
        end <= start -> 0
        else -> sum0ton(end) - sum0ton(start)
    }

}