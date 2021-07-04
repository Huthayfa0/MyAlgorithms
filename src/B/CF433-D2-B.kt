import java.util.*
import kotlin.math.*

fun main() {
    val n=readlnInt()
    val ints= readlnInts()
    val sortedInts=mergeSort(ints)
    val arr=LongArray(n)
    val sortedArr=LongArray(n)
    arr[0]=ints[0].toLong()
    sortedArr[0]=sortedInts[0].toLong()
    for (i in 1 until n){
        arr[i]+=arr[i-1]+ints[i]
        sortedArr[i]+=sortedArr[i-1]+sortedInts[i]
    }
    val t=readlnInt()
    repeat(t){
        var (type,l,r)=readlnInts()
        r--
        l--
        println(when(type){
            1-> if (l==0)arr[r] else arr[r]-arr[l-1]
            2-> if (l==0)sortedArr[r] else sortedArr[r]-sortedArr[l-1]
            else -> ""
        })
    }

}
private fun mergeSort(list: List<Int>): List<Int> {
    fun merge(left: List<Int>, right: List<Int>): List<Int>  {
        var indexLeft = 0
        var indexRight = 0
        var newList : MutableList<Int> = mutableListOf()

        while (indexLeft < left.count() && indexRight < right.count()) {
            if (left[indexLeft] <= right[indexRight]) {
                newList.add(left[indexLeft])
                indexLeft++
            } else {
                newList.add(right[indexRight])
                indexRight++
            }
        }

        while (indexLeft < left.size) {
            newList.add(left[indexLeft])
            indexLeft++
        }

        while (indexRight < right.size) {
            newList.add(right[indexRight])
            indexRight++
        }
        return newList;
    }
    if (list.size <= 1) {
        return list
    }

    val middle = list.size / 2
    var left = list.subList(0,middle);
    var right = list.subList(middle,list.size);

    return merge(mergeSort(left), mergeSort(right))
}

//Scanner code
private fun readln() = readLine()!!
private fun readlnInt() = readln().toInt()
private fun readlnLong() = readln().toLong()
private fun readlnDouble() = readln().toDouble()
private fun readlnBigInt(radix: Int = 10) = readln().toBigInteger(radix)
private fun readlnBigDecimal() = readln().toBigDecimal()
private fun lineSequence(limit: Int = Int.MAX_VALUE) = generateSequence { readLine() }.constrainOnce().take(limit)
private fun readlnStrings() = readln().split(' ')
private fun readlnInts() = readlnStrings().map { it.toInt() }
private fun readlnLongs() = readlnStrings().map { it.toLong() }
private fun readlnDoubles() = readlnStrings().map { it.toDouble() }
private fun readIntArray() = readlnStrings().run { IntArray(size) { get(it).toInt() } }
private fun readLongArray() = readlnStrings().run { LongArray(size) { get(it).toLong() } }
private fun readDoubleArray() = readlnStrings().run { DoubleArray(size) { get(it).toDouble() } }
private fun readlnIntArray(n: Int) = IntArray(n) { readlnInt() }
private fun readlnLongArray(n: Int) = LongArray(n) { readlnLong() }
private fun readlnDoubleArray(n: Int) = DoubleArray(n) { readlnDouble() }
private fun readLongArray2d(rows: Int, cols: Int) = Array(rows) { readLongArray().also { require(it.size == cols) } }
private fun readIntArray2d(rows: Int, cols: Int) = Array(rows) { readIntArray().also { require(it.size == cols) } }
private fun readDoubleArray2d(rows: Int, cols: Int) =
    Array(rows) { readDoubleArray().also { require(it.size == cols) } }

private fun isWhiteSpace(c: Char) = c in " \r\n\t"

// JVM-only targeting code follows next
// readString() via sequence is still slightly faster than Scanner
private fun readString() = generateSequence { System.`in`.read().toChar() }
    .dropWhile { isWhiteSpace(it) }.takeWhile { !isWhiteSpace(it) }.joinToString("")

private fun readInt() = readString().toInt()
private fun readLong() = readString().toLong()
private fun readDouble() = readString().toDouble()
private fun readBigInt(radix: Int = 10) = readString().toBigInteger(radix)
private fun readBigDecimal() = readString().toBigDecimal()
private fun readInts(n: Int) = generateSequence { readInt() }.take(n)
private fun readLongs(n: Int) = generateSequence { readLong() }.take(n)
private fun readDoubles(n: Int) = generateSequence { readDouble() }.take(n)

//Graphs
private fun dfs(size: Int, adjacencyList: List<List<List<Int>>>, v: Int = 0) {
    val searchOrder = ArrayList<Int>()
    val parent = IntArray(size) { -1 }

    // Mark visited vertices
    val isVisited = BooleanArray(size)
    fun dfs(v: Int) {
        // Store the visited vertex
        searchOrder.add(v)
        isVisited[v] = true // Vertex v visited
        adjacencyList[v].forEach { e -> // Note that e.u is v
            if (!isVisited[e[1]]) { // e.v is w in Listing 28.8
                parent[e[1]] = v // The parent of w is v
                dfs(e[1]) // Recursive search
            }
        }
    }
    // Recursively search
    dfs(v)
}

private fun bfs(size: Int, adjacencyList: List<List<List<Int>>>, v: Int = 0) {
    val searchOrder: MutableList<Int> = java.util.ArrayList()
    val parent = IntArray(size) { -1 } // Initialize parent[i] to -1
    val queue = LinkedList<Int>() // list used as a queue
    val isVisited = BooleanArray(size)
    queue.offer(v) // Enqueue v
    isVisited[v] = true // Mark it visited
    while (!queue.isEmpty()) {
        val u = queue.poll() // Dequeue to u
        searchOrder.add(u) // u searched
        adjacencyList[u].forEach { e -> // Note that e.u is u
            if (!isVisited[e[1]]) { // e.v is w in Listing 28.11
                queue.offer(e[1]) // Enqueue w
                parent[e[1]] = u // The parent of w is u
                isVisited[e[1]] = true // Mark w visited
            }
        }
    }

}

private fun dijkstra(size: Int, adjacencyList: List<List<List<Int>>>, startingVertex: Int = 0) {
    val cost = DoubleArray(size) { Double.POSITIVE_INFINITY }
    cost[startingVertex] = 0.0 // Cost of source is 0
    val parent = IntArray(size) // Parent of a vertex
    parent[startingVertex] = -1 // startingVertex is the root
    val processed = BooleanArray(size)
    val t = PriorityQueue<Pair<Double, Int>>(Comparator.comparing { it.first })
    val list = ArrayList<Int>()
    t.add(Pair(0.0, startingVertex))
    while (!t.isEmpty()) {
        val a = t.poll().second
        if (processed[a]) continue
        processed[a] = true
        list.add(a)
        for (u in adjacencyList[a]) {
            val b = u[1]
            val w = u[2]
            if (cost[a] + w < cost[b]) {
                parent[b] = a
                cost[b] = cost[a] + w
                t.add(Pair(cost[b], b))
            }
        }
    }
}

private fun floydWarshall(adjacencyMatrix: Array<DoubleArray>): Array<DoubleArray> {

    val distance = adjacencyMatrix
    val size = distance.size
    for (k in 0 until size) {
        for (i in 0 until size) {
            for (j in 0 until size) {
                distance[i][j] = java.lang.Double.min(distance[i][j], distance[i][k] + distance[k][j])
            }
        }
    }

    return distance
}

private fun bellmanFord(graph: Array<IntArray>, V: Int, E: Int, src: Int) {
    // Initialize distance of all vertices as infinite.
    val dis = IntArray(V) { Int.MAX_VALUE }

    // initialize distance of source as 0
    dis[src] = 0

    // Relax all edges |V| - 1 times. A simple
    // shortest path from src to any other
    // vertex can have at-most |V| - 1 edges
    for (i in 0 until V - 1) {
        for (j in 0 until E) {
            if (dis[graph[j][0]] != Int.MAX_VALUE && dis[graph[j][0]] + graph[j][2] <
                dis[graph[j][1]]
            ) dis[graph[j][1]] = dis[graph[j][0]] + graph[j][2]
        }
    }

    // check for negative-weight cycles.
    // The above step guarantees shortest
    // distances if graph doesn't contain
    // negative weight cycle. If we get a
    // shorter path, then there is a cycle.
    for (i in 0 until E) {
        val x = graph[i][0]
        val y = graph[i][1]
        val weight = graph[i][2]
        if (dis[x] != Int.MAX_VALUE && dis[x] + weight < dis[y]) println("Graph contains negative weight cycle")
    }

}

//Primes
private fun Int.isPrime(): Boolean {
    if (this < 2) return false
    var x = 2
    while (x * x <= this) {
        if (this % x == 0) return false
        x++
    }
    return true
}

private fun Int.primeFactors(): LinkedList<Int> {
    var n = this
    val f = LinkedList<Int>()
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

/*
//SegmentTree
private class SegmentTree(var array: IntArray) {
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
        minReady = true
    }

    fun min(start: Int = 0, end: Int = array.size - 1): Int {
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
        maxReady = true
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
        var l: Int
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
            l = kotlin.math.min(minTree[index * 2], minTree[index * 2 + 1])
            while (minTree[index] != l) {
                minTree[index] = l
                index = index shr 1
                if (index == 0) break
                l = kotlin.math.min(minTree[index * 2], minTree[index * 2 + 1])
            }
        }
        array[k] = x


    }
}

//StaticArrayQueries
private class StaticArrayQueries(val array: IntArray) {
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

    //O(nln n)
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
*/
//SlidingWindow
private fun slidingWindowMin(array: IntArray, slidingWindowSize: Int): IntArray {
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
private fun nearestSmallerElements(array: IntArray): Array<Pair<Int, Int>?> {
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
/*
//BinaryIndexedTree
private class BinaryIndexedTree(var array: IntArray) {
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
*/
