package arrayQuieres

/**
 * A segment tree is a binary tree such that the nodes on the bottom level of the
tree correspond to the array elements, and the other nodes contain information
needed for processing range queries.
 */
class SegmentTree(var array: IntArray) {
    private var minReady = false
    private var maxReady = false
    private lateinit var minTree: IntArray
    private lateinit var maxTree: IntArray
    private var halfSize = 0

    init {
        var x = array.size
        x--
        x = x or (x shr 1)
        x = x or (x shr 2)
        x = x or (x shr 4)
        x = x or (x shr 8)
        x = x or (x shr 16)
        x++
        halfSize = x

    }

    private fun minEvaluate() {
        minTree = IntArray(halfSize * 2)
        for (i in array.indices) {
            minTree[i + halfSize] = array[i]
        }
        for (i in halfSize - 1 downTo 0) {
            minTree[i] = kotlin.math.min(minTree[i * 2], minTree[i * 2 + 1])
        }
        minReady=true
    }

    fun min(start: Int = 0, end: Int = array.size-1): Int {
        if (!minReady) minEvaluate()

        return when {
            start < 0 && end >= array.size -> min()
            start < 0 -> min(end = end)
            end >= array.size -> min(start = start)
            end < start -> 0
            else -> {
                var l = start + halfSize
                var r = end + halfSize
                var ans = Int.MAX_VALUE
                while (l <= r) {
                    if (l and 1 == 1) ans = kotlin.math.min(ans, minTree[l++])
                    if (r and 1 == 0) ans = kotlin.math.min(ans, minTree[r--])
                    l = l shr 1
                    r = r shr 1
                }
                return ans
            }
        }
    }

    //O(nln n)
    //TODO improve to O(n)
    private fun maxEvaluate() {
        maxTree = IntArray(halfSize * 2)
        for (i in array.indices) {
            maxTree[i + halfSize] = array[i]
        }
        for (i in halfSize - 1 downTo 0) {
            maxTree[i] = kotlin.math.max(maxTree[i * 2], maxTree[i * 2 + 1])
        }
        maxReady=true
    }

    fun max(start: Int = 0, end: Int = array.size - 1): Int {
        if (!maxReady) maxEvaluate()

        return when {
            start < 0 && end >= array.size -> max()
            start < 0 -> max(end = end)
            end >= array.size -> max(start = start)
            end < start -> 0
            else -> {
                var l = start + halfSize
                var r = end + halfSize
                var ans = Int.MIN_VALUE
                while (l <= r) {
                    //l and 1 is same as l mod 2
                    if (l and 1 == 1) ans = kotlin.math.max(ans, maxTree[l++])
                    if (r and 1 == 0) ans = kotlin.math.max(ans, maxTree[r--])
                    l = l shr 1
                    r = r shr 1
                }
                return ans
            }
        }
    }

    fun update(k: Int, x: Int) {
            var l:Int
            if (maxReady) {
                var index = k + halfSize
                maxTree[index] = x
                index = index shr 1
                l = kotlin.math.max(maxTree[index * 2], maxTree[index * 2 + 1])
                while (maxTree[index] != l) {
                    maxTree[index] = l
                    index = index shr 1
                    l = kotlin.math.max(maxTree[index * 2], maxTree[index * 2 + 1])
                    if (index == 0) break
                }
            }
            if (minReady) {
                var index = k + halfSize
                minTree[index] = x
                index = index shr 1
                l=kotlin.math.min(minTree[index*2],minTree[index*2+1])
                while (minTree[index] !=l) {
                    minTree[index] = l
                    index = index shr 1
                    if (index == 0) break
                    l=kotlin.math.min(minTree[index*2],minTree[index*2+1])
                }
            }
            array[k] = x


    }
}
