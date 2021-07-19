import java.util.*
import kotlin.math.*

fun main() {

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
private fun readDoubleArray2d(rows: Int, cols: Int) = Array(rows) { readDoubleArray().also { require(it.size == cols) } }
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


//sort
private fun mergeSort(list: List<Int>): List<Int> {
    fun merge(left: List<Int>, right: List<Int>): List<Int>  {
        var indexLeft = 0
        var indexRight = 0
        val newList : MutableList<Int> = mutableListOf()

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
        return newList
    }
    if (list.size <= 1) {
        return list
    }

    val middle = list.size / 2
    val left = list.subList(0,middle)
    val right = list.subList(middle,list.size)

    return merge(mergeSort(left), mergeSort(right))
}


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

