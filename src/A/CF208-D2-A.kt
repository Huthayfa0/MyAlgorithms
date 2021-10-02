import java.util.*
import kotlin.math.*

//RotateArray MergeSort FirstSearch ShoretestPath
//MinimumSpanningTree Primes Permutations
//Combinations BinarySearchTechs ComplexAndGeometry 
fun main() {
   val x=readln().replace("(WUB)+".toRegex()," ").trim()



    println(x)
}

//Scanner code, if wanted to read from file just change the first
private fun readln() = readLine()!!.trim()
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

//rotate
/*
inline fun <reified T>Array<Array<T>>.rotate()= Array(this[0].size){ i->Array(this.size){ j->this[j][i]} }
fun Array<CharArray>.rotate()= Array(this[0].size){ i->CharArray(this.size){ j->this[j][i]} }
fun Array<IntArray>.rotate()= Array(this[0].size){ i->IntArray(this.size){ j->this[j][i]} }
fun Array<LongArray>.rotate()= Array(this[0].size){ i->LongArray(this.size){ j->this[j][i]} }
fun Array<DoubleArray>.rotate()= Array(this[0].size){ i->DoubleArray(this.size){ j->this[j][i]} }
*/

//sort
/*
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
*/

//Graphs
//First Search
/*
private fun dfs(size: Int, adjacencyList: List<List<Int>>, v: Int = 0) {
    val searchOrder = ArrayList<Int>()
    val parent = IntArray(size) { -1 }
    val isVisited = BooleanArray(size)
    fun dfs(v: Int) {
        searchOrder.add(v)
        isVisited[v] = true
        adjacencyList[v].forEach { e ->
            if (!isVisited[e]) {
                parent[e] = v
                dfs(e)
            }
        }
    }
    // Recursively search
    dfs(v)
}

private fun bfs(size: Int, adjacencyList: List<List<Int>>, v: Int = 0) {
    val searchOrder: MutableList<Int> = ArrayList()
    val parent = IntArray(size) { -1 } // Initialize parent[i] to -1
    val queue = LinkedList<Int>() // list used as a queue
    val isVisited = BooleanArray(size)
    queue.offer(v) // Enqueue v
    isVisited[v] = true // Mark it visited
    while (!queue.isEmpty()) {
        val u = queue.poll() // Dequeue to u
        searchOrder.add(u) // u searched
        adjacencyList[u].forEach { e -> // Note that e.u is u
            if (!isVisited[e]) { // e.v is w in Listing 28.11
                queue.offer(e) // Enqueue w
                parent[e] = u // The parent of w is u
                isVisited[e] = true // Mark w visited
            }
        }
    }

}
*/

//Shoretest Path
/*
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
    val dis = IntArray(V) { Int.MAX_VALUE }
    dis[src] = 0
    for (i in 0 until V - 1) {
        for (j in 0 until E) {
            if (dis[graph[j][0]] != Int.MAX_VALUE && dis[graph[j][0]] + graph[j][2] <
                dis[graph[j][1]]
            ) dis[graph[j][1]] = dis[graph[j][0]] + graph[j][2]
        }
    }
    for (i in 0 until E) {
        val x = graph[i][0]
        val y = graph[i][1]
        val weight = graph[i][2]
        if (dis[x] != Int.MAX_VALUE && dis[x] + weight < dis[y]) println("Graph contains negative weight cycle")
    }

}
*/

//MST
/*
private fun prim(size: Int, adjacencyList: List<List<List<Int>>>, startingVertex: Int = 0) {
    val cost = DoubleArray(size) { Double.POSITIVE_INFINITY }
    cost[startingVertex] = 0.0 // Cost of source is 0
    val parent = IntArray(size) // Parent of a vertex
    parent[startingVertex] = -1 // startingVertex is the root
    val t = mutableSetOf<Int>()
    while (t.size < size) {
        var u = -1 // Vertex to be determined
        var currentMinCost = Double.POSITIVE_INFINITY
        for (i in 0 until size) {
            if (!t.contains(i) && cost[i] < currentMinCost) {
                currentMinCost = cost[i]
                u = i
            }
        }
        if (u == -1) break else t.add(u)
        for (e in adjacencyList[u]) {
            val sum = cost[u]
            if (!t.contains(e[1]) && cost[e[1]] > sum) {
                cost[e[1]] = sum
                parent[e[1]] = u
            }
        }
    }
}

private fun kruskal(size: Int, edges: List<List<Int>>) {
    edges.sortedBy { it[2] }
    /* Arrays.sort(edges, Comparator.comparing { e: IntArray ->
         e[2]
     })*/

    fun getSet(i: Int, parent: IntArray): Int =
        if (parent[i] == i) i else getSet(parent[i], parent).also { parent[i] = it }

    fun unionSets(i: Int, j: Int, ranks: IntArray, parent: IntArray): Boolean {
        val ii = getSet(i, parent)
        val jj = getSet(j, parent)
        if (ii != jj) {
            if (ranks[ii] > ranks[jj]) {
                parent[jj] = ii
            } else if (ranks[jj] > ranks[ii]) {
                parent[ii] = jj
            } else {
                parent[ii] = jj
                ranks[jj]++
            }
            return true
        }
        return false
    }

    val rank = IntArray(size)
    val parent = IntArray(size)
    for (i in 1 until size) {
        parent[i] = i
    }
    var cost = 0
    val pairs = HashSet<List<Int>>()
    for (e in edges) {
        if (unionSets(e[0], e[1], rank, parent)) {
            pairs.add(e)
            cost += e[2]
        }
    }

}
*/

//Primes
/*
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
*/

//Permutations
/*
private fun permutationsIteration(n:Int,m:Int=n,f:(LinkedList<out Int>)->Unit){
    val list= LinkedList<Int>()
    var count=0
    val visited=BooleanArray(n)

    fun getPerm(i:Int=0){
        if (i==m){
            f(list)
            count++
            return
        }
        for (j in 0 until n){
            if (visited[j])
                continue
            list.add(j)
            visited[j]=true
            getPerm(i+1)
            visited[j]=false
            list.removeLast()
        }
    }

    getPerm()
}
*/

//combinations
/*
private fun combinationsIteration(n:Int, m:Int, f:(LinkedList<out Int>)->Unit){
    val list= LinkedList<Int>()
    var count=0

    fun getCombination(i:Int=0,lastVal:Int=0){
        if (i==m){
            f(list)
            count++
            return
        }
        for (j in lastVal until n){
            list.add(j)
            getCombination(i+1,j+1)
            list.removeLast()
        }
    }
    getCombination()
}

private fun getCombinationCountArray(n:Int,m:Int){
    require(n>=m)
    val arr=Array(m+1){LongArray(n+1)}
    for (i in 0 until m+1)
        for (j in 0 until n+1)
            arr[i][j]=when{
                j==0->1
                i==0->0
                else-> arr[i-1][j-1]+arr[i-1][j]
            }

}
*/
//Search Techs
/*
private fun BSfindFirst(start: Int, end: Int, x: Int,f:(Int)->Int): Int {
    var s = start
    var e = end
    while (s < e) {
        val mid = s + (e - s) / 2
        if (f(mid) < x) s = mid + 1
        else if (f(mid) > x) e = mid - 1
        else e = mid
    }
    return s
}

private fun BSfindLast(start: Int, end: Int, x: Int,f:(Int)->Int): Int {
    var s = start
    var e = end
    while (s < e) {
        val mid = s + (e - s) / 2
        if (f(mid) < x) s = mid + 1
        else if (f(mid) > x) e = mid - 1
        else s = mid
    }
    return s
}

private fun binary( start:Double, end:Double,can:(Double)->Boolean):Double{
    var s=start
    var e=end
    repeat(100){
        val mid = (s + e) / 2
        if (can(mid)) e = mid else s = mid
    }

    if( can(e) )
        return s

    return -1.0	// failed
}

private fun BSfindFirstTrue(start: Int, end: Int, f:(Int)->Boolean): Int {
    var s = start
    var e = end
    while (s < e) {
        val mid = s + (e - s) / 2
        if (f(mid)) e = mid
        else s = mid+1
    }
    return s
}

private fun BSfindLastFalse(start: Int, end: Int, f:(Int)->Boolean): Int {
    var s = start
    var e = end
    while (s < e) {
        val mid = s + (e - s) / 2
        if (f(mid)) e = mid-1
        else s = mid
    }
    return s
}
*/
//Complex
/*
private fun isEven(i: Int) = i % 2 == 0
private val img = Complex(0.0, 1.0)
private fun abs(c: Complex): Double = c.abs()
private fun exp(c: Complex): Complex {
    val e = exp(c.real)
    return Complex(e * cos(c.img), e * sin(c.img))
}
private fun sinh(c: Complex) = (exp(c) - exp(-c)) / 2
private fun cosh(c: Complex) = (exp(c) + exp(-c)) / 2
private fun tanh(c: Complex) = sinh(c) / cosh(c)
private fun coth(c: Complex) = cosh(c) / sinh(c)
private fun cos(c: Complex) = (exp(img * c) + exp(-img * c)) / 2.0
private fun sin(c: Complex) = img * (exp(-img * c) - exp(img * c)) / 2.0
private fun tan(c: Complex) = sin(c) / cos(c)
private fun cot(c: Complex) = cos(c) / sin(c)
private fun sec(c: Complex) = Complex.ONE / cos(c)
private fun ln(c: Complex) = Complex(ln(c.abs()), c.phase())
private fun roots(n: Int) =
    (1 ..n).map { exp(img*2*PI*it/n) }
private operator fun Number.plus(c: Complex) = Complex(this.toDouble() + c.real, c.img)
private operator fun Number.minus(c: Complex) = Complex(this.toDouble() - c.real, -c.img)
private operator fun Number.times(c: Complex) = Complex(this.toDouble() * c.real, this.toDouble() * c.img)
private operator fun Number.div(c: Complex) = Complex.ONE / c
private class Complex(val real: Double, val img: Double) {
    constructor(real: Number, img: Number) : this(real.toDouble(), img.toDouble())
    override fun equals(other: Any?): Boolean {
        return (other is Complex && real == other.real && img == other.img)
    }
    override fun hashCode(): Int {
        return real.hashCode() * 31 + img.hashCode()
    }
    operator fun unaryMinus() = Complex(-real, -img)
    operator fun plus(c: Complex) = Complex(real + c.real, img + c.img)
    operator fun plus(n: Number) = Complex(real + n.toDouble(), img)
    operator fun minus(c: Complex) = Complex(real - c.real, img - c.img)
    operator fun minus(n: Number) = Complex(real - n.toDouble(), img)
    operator fun times(c: Complex) = Complex(real * c.real - img * c.img, real * c.img + img * c.real)
    operator fun times(n: Number) = Complex(n.toDouble() * real, n.toDouble() * img)
    operator fun div(n: Number) = Complex(real / n.toDouble(), img / n.toDouble())
    operator fun div(c: Complex): Complex {
        val den = c.normSquared()
        if (isPracticallyZero(den)) {
            return this / 0 //TO make this consistent with division by zero number
        }
        val num = this * c.conjugate()
        return num / den
    }
    operator fun component1() = real
    operator fun component2() = img
    /**
     * Complex conjugate = x-y*i
     */
    fun conjugate() = Complex(real, -img)
    fun normSquared() = real * real + img * img
    fun abs(): Double = sqrt(this.normSquared())
    fun phase(): Double = atan(img / real)
    fun pow(a: Double) = exp(ln(this) * a)
    fun pow(a: Number) = exp(ln(this) * a)
    fun pow(a: Complex) = exp(ln(this) * a)
    override fun toString(): String {
        return when {
            isPracticallyZero(img) -> "${ real}"
            isPracticallyZero(real) -> "${ img}i"
            img < 0 -> "${ real}-${ -img}i"
            else -> "${ real}+${ img}i"
        }
    }
    private fun isPracticallyZero(d: Double) = abs(d) < DEFAULT_TOLERANCE
    companion object {
        /**
         * Complex 0 = 0 + 0i
         */
        val ZERO = Complex(0.0, 0.0)
        /**
         * Complex 1 = 1 + 0i
         */
        val ONE = Complex(1.0, 0.0)
        const val DEFAULT_TOLERANCE = 1.0E-15
        fun fromNumber(n: Number) = Complex(n.toDouble(), 0.0)
        fun fromPolar(radius: Double, theta: Double) :Complex  =radius*exp(img*theta)
    }
    /**
     * Tests if the norm of the complex number is smaller than the given tolerance
     */
    fun isZero(tolerance: Double) = this.abs() < tolerance
    infix fun to(exponent: Int): Complex {
        if (exponent == 0) {
            return ONE
        }
        if (exponent == 1) {
            return this
        }
        val half = to(exponent / 2)
        return if (isEven(exponent)) {
            half * half
        } else {
            half * half * this
        }
    }
    infix fun to(exponent: Complex) = this.pow(exponent)
    infix fun to(exponent: Number) = this.pow(exponent)
}
*/

//Point2D
/*
val Complex.X
    get() = this.real
val Complex.Y
    get() = this.img
fun Complex.angle()=this.phase()
fun vec(A:Complex,B:Complex)=B-A
fun dotProduct(A:Complex,B:Complex)=(A.conjugate()*B).real
fun crossProduct(A:Complex,B:Complex)=(A.conjugate()*B).img
fun Complex.length()=this.abs()
fun Complex.normalize()=this/this.abs()
fun rotateAroundO(p:Complex,ang:Double)=p* exp(ang*img)
fun rotateAroundA(p:Complex,ang:Double,about:Complex)=rotateAroundO(vec(about,p),ang)+about
fun reflectO(v:Complex,m:Complex)=(((v)/(m)).conjugate()*(m))
fun reflect(p:Complex, p0:Complex, p1:Complex):Complex {
    val z = p-p0
    val w = p1-p0
    return (z/w).conjugate()*w + p0 // Refelect point p1 around p0p1
}
fun fixAngle(A:Double): Double =if(A > 1) 1.0 else if (A < -1) -1.0 else A
fun angleO( a:Complex, O:Complex, b:Complex):Complex {
    val v1=(a - O)
    val v2=(b - O)
    return Complex.fromPolar(1.0, acos(fixAngle ( dotProduct(v1, v2) / v1.length() / v2.length() )) )
}
fun getAng(a:Complex, b:Complex, c:Complex):Double {
    var ang =  vec(b, c).angle() -  vec(b, a).angle()
    if(ang< 0)
        ang+=2*PI
    return ang
}
 */

//lines

/*

fun isCollinear(a: Complex, b: Complex, c: Complex): Boolean {
    return (crossProduct(b - a, c - a)).isZero()
}

fun isPointOnRay(p0: Complex, p1: Complex, p2: Complex): Boolean {
    return if ((p2 - p0).length().isZero()) true else ((p1 - p0).normalize()== (p2 - p0).normalize())
}

fun isPointOnSegment(a: Complex, b: Complex, c: Complex): Boolean {
    return isPointOnRay(a, b, c) && isPointOnRay(b, a, c)
}
fun distToLine(p0: Complex, p1: Complex, p2: Complex): Double {
    return abs(crossProduct(p1 - p0, p2 - p0) / (p0 - p1).length()) // area = 0.5*b*h
}

fun distToSegment(p0: Complex, p1: Complex, p2: Complex): Double {
    var d1: Double
    var d2: Double
    val v1: Complex = p1 - p0
    val v2: Complex = p2 - p0
    if (dotProduct(v1, v2).also { d1 = it } <= 0) return (p2 - p0).length()
    if (dotProduct(v1, v1).also { d2 = it } <= d1) return (p2 - p1).length()
    val t = d1 / d2
    return (p2 - (p0 + v1 * t)).length()
}
 */