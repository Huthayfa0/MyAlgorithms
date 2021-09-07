import java.math.BigInteger
import java.util.*
import kotlin.math.*

//RotateArray MergeSort FirstSearch ShoretestPath
//MinimumSpanningTree Primes Permutations
//Combinations BinarySearchTechs ComplexAndGeometry 
fun main() {
    val t=readlnInt()
    repeat(t){
        val n=readlnInt()
        val ans= arrayOf(arrayOf(BigInteger.ZERO,BigInteger.ONE), arrayOf(BigInteger.ONE,BigInteger.ONE)).pow(n)
        println(ans[0][1]+ans[0][0])
    }
}
fun Array<Array<BigInteger>>.mul(x:Array<Array<BigInteger>>):Array<Array<BigInteger>>{
    return arrayOf(arrayOf(this[0][0]*(x[0][0])+this[0][1]*(x[1][0]),
        this[0][0]*(x[0][1])+this[0][1]*(x[1][1])),
        arrayOf(this[1][0]*(x[0][0])+this[1][1]*(x[1][0]),
            this[1][0]*(x[0][1])+this[1][1]*(x[1][1])))
}
fun Array<Array<BigInteger>>.pow(n:Int):Array<Array<BigInteger>>{
    if (n==0)
        return arrayOf(arrayOf(BigInteger.ONE,BigInteger.ZERO), arrayOf(BigInteger.ZERO,BigInteger.ONE))
    if (n==1)
        return this
    val x=this.pow(n/2)
    if (n%2==0)
        return x.mul(x)
    else
        return x.mul(x).mul(this)

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
