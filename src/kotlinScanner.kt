class kotlinScanner {

    //Scanner code
    fun readln() = readLine()!!
    fun readlnInt() = readln().toInt()
    fun readlnLong() = readln().toLong()
    fun readlnDouble() = readln().toDouble()
    fun readlnBigInt(radix: Int = 10) = readln().toBigInteger(radix)
    fun readlnBigDecimal() = readln().toBigDecimal()
    fun lineSequence(limit: Int = Int.MAX_VALUE) = generateSequence { readLine() }.constrainOnce().take(limit)
    fun readlnStrings() = readln().split(' ')
    fun readlnInts() = readlnStrings().map { it.toInt() }
    fun readlnLongs() = readlnStrings().map { it.toLong() }
    fun readlnDoubles() = readlnStrings().map { it.toDouble() }
    fun readIntArray() = readlnStrings().run { IntArray(size) { get(it).toInt() } }
    fun readLongArray() = readlnStrings().run { LongArray(size) { get(it).toLong() } }
    fun readDoubleArray() = readlnStrings().run { DoubleArray(size) { get(it).toDouble() } }
    fun readlnIntArray(n: Int) = IntArray(n) { readlnInt() }
    fun readlnLongArray(n: Int) = LongArray(n) { readlnLong() }
    fun readlnDoubleArray(n: Int) = DoubleArray(n) { readlnDouble() }
    fun readLongArray2d(rows: Int, cols: Int) = Array(rows) { readLongArray().also { require(it.size == cols) } }
    fun readIntArray2d(rows: Int, cols: Int) = Array(rows) { readIntArray().also { require(it.size == cols) } }
    fun readDoubleArray2d(rows: Int, cols: Int) = Array(rows) { readDoubleArray().also { require(it.size == cols) } }
    fun isWhiteSpace(c: Char) = c in " \r\n\t"

    // JVM-only targeting code follows next
// readString() via sequence is still slightly faster than Scanner
    fun readString() = generateSequence { System.`in`.read().toChar() }
        .dropWhile { isWhiteSpace(it) }.takeWhile { !isWhiteSpace(it) }.joinToString("")
    fun readInt() = readString().toInt()
    fun readLong() = readString().toLong()
    fun readDouble() = readString().toDouble()
    fun readBigInt(radix: Int = 10) = readString().toBigInteger(radix)
    fun readBigDecimal() = readString().toBigDecimal()
    fun readInts(n: Int) = generateSequence { readInt() }.take(n)
    fun readLongs(n: Int) = generateSequence { readLong() }.take(n)
    fun readDoubles(n: Int) = generateSequence { readDouble() }.take(n)

}