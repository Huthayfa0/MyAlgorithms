import java.util.*
import kotlin.math.*

//RotateArray MergeSort FirstSearch ShoretestPath
//MinimumSpanningTree Primes Permutations
//Combinations BinarySearchTechs ComplexAndGeometry 
fun main() {
    val (n,k)=readlnInts()
    val a=readlnInts().withIndex()
    val pmin=PriorityQueue<IndexedValue<Int>>(Comparator.comparing{it.value})
    val pmax=PriorityQueue<IndexedValue<Int>>(Comparator.comparing<IndexedValue<Int>?, Int?> {it.value}.reversed())
    pmin.addAll(a)
    pmax.addAll(a)

    var count=0
    val stringBuilder=StringBuilder()
   run r@{
    repeat(k){
        var x=pmin.poll()
        var y=pmax.poll()
        pmax.remove(x)
        pmin.remove(y)
        if (y.value-x.value>1) {
           x= IndexedValue(x.index,x.value+1)
           y= IndexedValue(y.index,y.value-1)
            pmin.add(x)
            pmax.add(y)
            pmax.add(x)
            pmin.add(y)
            stringBuilder.append("${y.index+1} ${x.index+1}\n")
            count++
        }else{
            pmin.add(x)
            pmax.add(y)
            pmax.add(x)
            pmin.add(y)
            return@r
        }

    }
   }
    val min=pmax.peek().value-pmin.peek().value
    println("$min $count")
    print(stringBuilder.toString())
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
