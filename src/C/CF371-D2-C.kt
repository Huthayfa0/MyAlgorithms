import java.util.*
import kotlin.math.*

//RotateArray MergeSort FirstSearch ShoretestPath
//MinimumSpanningTree Primes Permutations
//Combinations BinarySearchTechs ComplexAndGeometry 
fun main() {
    val x=readln().groupingBy { when(it){
        'B'->1
        'S'->2
        'C'->3
        else->0
    } }.eachCount()
    val (b,s,c)= listOf(x[1]?:0,x[2]?:0,x[3]?:0)
    var (nb, ns, nc)=readlnInts()
    val (pb, ps, pc)=readlnInts()
    val r=readLong()
    var ans= min(min(if (b==0)Int.MAX_VALUE else nb/b,if (s==0)Int.MAX_VALUE else ns/s),if (c==0)Int.MAX_VALUE else nc/c).toLong()
    nb-=(b*ans).toInt()
    nc-=(c*ans).toInt()
    ns-=(s*ans).toInt()
    fun check(x:Long)=(max(x*b-nb ,0L)*pb)+(max(x*c-nc ,0L)*pc)+(max(x*s-ns ,0L)*ps)
    ans+=BSfindLastFalse(0L,r/(min(pb, min(ps,pc)))){
        check(it)>r
    }
    println(ans)
}
private fun BSfindFirst(start: Int, end: Int, x: Int, f: (Int) -> Int): Int {
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

private fun BSfindLast(start: Int, end: Int, x: Int, f: (Int) -> Int): Int {
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

private fun binary(start: Double, end: Double, can: (Double) -> Boolean): Double {
    var s = start
    var e = end
    repeat(100) {
        val mid = (s + e) / 2
        if (can(mid)) e = mid else s = mid
    }

    if (can(e))
        return s

    return -1.0    // failed
}

private fun BSfindFirstTrue(start: Int, end: Int, f: (Int) -> Boolean): Int {
    var s = start
    var e = end
    while (s < e) {
        val mid = s + (e - s) / 2
        if (f(mid)) e = mid
        else s = mid + 1
    }
    return s
}

private fun BSfindLastFalse(start: Long, end: Long, f: (Long) -> Boolean): Long {
    var s = start
    var e = end
    while (s+1 < e) {
        val mid = s + (e - s) / 2
        if (f(mid)) e = mid - 1
        else s = mid
    }

    return if (f(e)) s else e
}


//Scanner code, if wanted to read from file just change the first
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
