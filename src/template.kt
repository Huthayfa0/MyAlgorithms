import arrayQuieres.SlidingWindow
import java.util.*
import kotlin.math.log2

fun main() {

}
//Scanner code
 fun readln() = readLine()!!
 fun readlnByte() = readln().toByte()
 fun readlnShort() = readln().toShort()
 fun readlnInt() = readln().toInt()
 fun readlnLong() = readln().toLong()
 fun readlnFloat() = readln().toFloat()
 fun readlnDouble() = readln().toDouble()
 fun readlnBigInt(radix: Int = 10) = readln().toBigInteger(radix)
 fun readlnBigDecimal() = readln().toBigDecimal()

 fun lineSequence(limit: Int = Int.MAX_VALUE) = generateSequence { readLine() }.constrainOnce().take(limit)
 fun readlnStrings() = readln().split(' ')
 fun readlnBytes() = readlnStrings().map { it.toByte() }
 fun readlnShorts() = readlnStrings().map { it.toShort() }
 fun readlnInts() = readlnStrings().map { it.toInt() }
 fun readlnLongs() = readlnStrings().map { it.toLong() }
 fun readlnFloats() = readlnStrings().map { it.toFloat() }
 fun readlnDoubles() = readlnStrings().map { it.toDouble() }

 fun readByteArray() = readlnStrings().run { ByteArray(size) { get(it).toByte() } }
 fun readShortArray() = readlnStrings().run { ShortArray(size) { get(it).toShort() } }
 fun readIntArray() = readlnStrings().run { IntArray(size) { get(it).toInt() } }
 fun readLongArray() = readlnStrings().run { LongArray(size) { get(it).toLong() } }
 fun readFloatArray() = readlnStrings().run { FloatArray(size) { get(it).toFloat() } }
 fun readDoubleArray() = readlnStrings().run { DoubleArray(size) { get(it).toDouble() } }

 fun readlnByteArray(n: Int) = ByteArray(n) { readlnByte() }
 fun readlnShortArray(n: Int) = ShortArray(n) { readlnShort() }
 fun readlnIntArray(n: Int) = IntArray(n) { readlnInt() }
 fun readlnLongArray(n: Int) = LongArray(n) { readlnLong() }
 fun readlnFloatArray(n: Int) = FloatArray(n) { readlnFloat() }
 fun readlnDoubleArray(n: Int) = DoubleArray(n) { readlnDouble() }

 fun readByteArray2d(rows: Int, cols: Int) = Array(rows) { readByteArray().also { require(it.size == cols) } }
 fun readShortArray2d(rows: Int, cols: Int) = Array(rows) { readShortArray().also { require(it.size == cols) } }
 fun readLongArray2d(rows: Int, cols: Int) = Array(rows) { readLongArray().also { require(it.size == cols) } }
 fun readIntArray2d(rows: Int, cols: Int) = Array(rows) { readIntArray().also { require(it.size == cols) } }
 fun readFloatArray2d(rows: Int, cols: Int) = Array(rows) { readFloatArray().also { require(it.size == cols) } }
 fun readDoubleArray2d(rows: Int, cols: Int) = Array(rows) { readDoubleArray().also { require(it.size == cols) } }

 fun isWhiteSpace(c: Char) = c in " \r\n\t"

 // JVM-only targeting code follows next

 // readString() via sequence is still slightly faster than Scanner
 fun readString() = generateSequence { System.`in`.read().toChar() }
     .dropWhile { isWhiteSpace(it) }.takeWhile { !isWhiteSpace(it) }.joinToString("")
 fun readByte() = readString().toByte()
 fun readShort() = readString().toShort()
 fun readInt() = readString().toInt()
 fun readLong() = readString().toLong()
 fun readFloat() = readString().toFloat()
 fun readDouble() = readString().toDouble()
 fun readBigInt(radix: Int = 10) = readString().toBigInteger(radix)
 fun readBigDecimal() = readString().toBigDecimal()

 fun readBytes(n: Int) = generateSequence { readByte() }.take(n)
 fun readShorts(n: Int) = generateSequence { readShort() }.take(n)
 fun readInts(n: Int) = generateSequence { readInt() }.take(n)
 fun readLongs(n: Int) = generateSequence { readLong() }.take(n)
 fun readFloats(n: Int) = generateSequence { readFloat() }.take(n)
 fun readDoubles(n: Int) = generateSequence { readDouble() }.take(n)

//SubarraySum
fun subarraySum(array: IntArray, x: Int): Pair<Int, Int>? {
    var i = 0
    var j = 1
    var sum = array[0]
    while (j != array.size) {
        when {
            sum > x -> {
                sum -= array[i]
                i++
            }
            sum < x -> {
                sum += array[j]
                j++
            }
            else -> {
                return Pair(i, j)
            }
        }
    }
    return null
}
//SegmentTree
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

//StaticArrayQueries
class StaticArrayQueries(val array: IntArray) {
    private var sumReady = false
    private var minReady = false
    private var maxReady = false
    private val sumArray = IntArray(array.size)
    private val minList = arrayListOf<IntArray>()
    private val maxList = arrayListOf<IntArray>()

    //O(n)
    private fun sumEvaluate() {
        var sum = 0
        for (i in array.indices) {
            sum += array[i]
            sumArray[i] = sum
        }
        sumReady = true
    }

    //O(1)
    fun sum(start: Int = 0, end: Int = array.size): Int {
        if (!sumReady) sumEvaluate()
        return when {
            start < 0 && end > array.size -> sum()
            start < 0 -> sum(end = end)
            end > array.size -> sum(start = start)
            end <= start -> 0
            start == 0 -> sumArray[end - 1]
            else -> sumArray[end - 1] - sumArray[start - 1]
        }
    }

    //O(nln n)
    //TODO improve to O(n)
    private fun minEvaluate() {
        var count = 1
        minList.add(array)
        count = count shl 1
        val slidingWindowMinimum = SlidingWindow()
        while (count <= array.size) {
            minList.add(slidingWindowMinimum.algorithmMin(array, count))
            count = count shl 1
        }
        minReady = true
    }

    //O(ln n)
    fun min(start: Int = 0, end: Int = array.size): Int {
        if (!minReady) minEvaluate()
        val c = log2((end - start + 1).toFloat()).toInt()
        var w = 1 shl c
        w--
        return when {
            start < 0 && end >= array.size -> min()
            start < 0 -> min(end = end)
            end >= array.size -> min(start = start)
            end < start -> 0
            else -> kotlin.math.min(minList[c][start], minList[c][end - w])
        }
    }

    //O(nln n)
    //TODO improve to O(n)
    private fun maxEvaluate() {
        var count = 1
        maxList.add(array)
        count = count shl 1
        val slidingWindowMinimum = SlidingWindow()
        while (count <= array.size) {
            maxList.add(slidingWindowMinimum.algorithmMax(array, count))
            count = count shl 1
        }
        maxReady = true
    }

    //O(ln n)
    fun max(start: Int = 0, end: Int = array.size - 1): Int {
        if (!maxReady) maxEvaluate()
        val c = log2((end - start + 1).toFloat()).toInt()
        var w = 1 shl c
        w--
        return when {
            start < 0 && end >= array.size -> max()
            start < 0 -> max(end = end)
            end >= array.size -> max(start = start)
            end < start -> 0
            else -> kotlin.math.max(maxList[c][start], maxList[c][end - w])
        }
    }
}
//SlidingWindow
fun slidingWindowMin(array: IntArray, slidingWindowSize: Int): IntArray {
    if (slidingWindowSize >= array.size) return IntArray(1) { Collections.min(array.toList()) }
    val ans = IntArray(array.size - slidingWindowSize + 1)
    val queue = LinkedList<Pair<Int, Int>>()
    for (i in 0 until slidingWindowSize) {
        if (queue.size == 0 || queue.last.second < array[i]) {
            queue.addLast(Pair(i, array[i]))
        } else {
            while (queue.size != 0 && queue.last.second >= array[i]) {
                queue.removeLast()
            }
            queue.addLast(Pair(i, array[i]))
        }
    }
    ans[0] = queue.first.second
    for (i in slidingWindowSize until array.size) {
        if (queue.size == 0 || queue.last.second < array[i]) {
            queue.addLast(Pair(i, array[i]))
        } else {
            while (queue.size != 0 && queue.last.second >= array[i]) {
                queue.removeLast()
            }
            queue.addLast(Pair(i, array[i]))
        }
        if (queue.first.first == i - slidingWindowSize) queue.pop()
        ans[i - slidingWindowSize + 1] = queue.first.second
    }
    return ans
}
//NearestSmallerElements
fun nearestSmallerElements(array: IntArray): Array<Pair<Int, Int>?> {
    val ans = Array<Pair<Int, Int>?>(array.size) { null }
    val stack = Stack<Pair<Int, Int>>()
    stack.add(Pair(0, array[0]))
    for (i in 1 until array.size) {
        while (stack.size > 0 && array[i] < stack.peek().second) {
            stack.pop()
        }
        if (stack.size > 0) {
            ans[i] = stack.peek()
        }
        stack.push(Pair(i, array[i]))
    }
    return ans
}

//MaximumSubarraySum
fun maximumSubarraySum(array: IntArray, start: Int = 0, end: Int = array.size): Int {
    var best = 0
    var sum = 0
    for (k in start until end) {
        sum = Integer.max(array[k], sum + array[k])
        best = Integer.max(best, sum)
    }
    return best
}

fun maximumSubarraySumWithIndices(array: IntArray, start: Int = 0, end: Int = array.size): Pair<Int, Pair<Int, Int>> {
    var best = Pair(0, Pair(start, start))
    var sum = Pair(0, Pair(start, start))

    for (k in start until end) {
        val temp1 = Pair(array[k], Pair(k, k + 1))
        val temp2 = Pair(sum.first + array[k], Pair(sum.second.first, k + 1))
        sum = if (temp1.first > temp2.first) temp1 else temp2
        best = if (best.first > sum.first) best else sum
    }
    return best
}


//BinaryIndexedTree
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
//Primes
fun isPrime(n: Int): Boolean {
    if (n < 2) return false
    var x = 2
    while (x * x <= n) {
        if (n % x == 0) return false
        x++
    }
    return true
}
fun primeFactors(v: Int): LinkedList<Int> {
    var n = v
    val f= LinkedList<Int>()
    var x = 2
    while (x * x <= n) {
        while (n % x == 0) {
            f.addLast(x)
            n /= x
        }
        x++
    }
    if (n > 1) f.addLast(n)
    return f
}

