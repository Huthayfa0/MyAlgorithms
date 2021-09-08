//RotateArray MergeSort FirstSearch ShoretestPath
//MinimumSpanningTree Primes Permutations
//Combinations BinarySearchTechs ComplexAndGeometry 
fun main() {
    val str=readln()
    val s=str.withIndex().groupBy ({it.value},{it.index})
    val ns=str.length
    val q=readlnInt()
    fun check(st:CharArray,pt:IntArray,ii:Int):Boolean{
        var y=ns
        val yy=BSfindLastTrue(0,pt.size-1){pt[it]==-1}
        if (yy!=pt.size-1){
            y=pt[yy+1]
        }
        for (i in yy downTo (st.size-ii)){
            val x=s[st[i]]
            if (x==null)
                return false
            val ss=BSfindLastTrue(0,x.size-1){x[it]<y}
            if (x[ss]>=y)
                return false
            pt[i]=x[ss]
            y=x[ss]
        }
        return true
    }
    repeat(q){
        val qi=readln().toCharArray()
        val pt=IntArray(qi.size){-1}
        val ans=BSfindLastTrue(0,qi.size){ check(qi,pt,it)}
        println(ans)
    }

}


private fun BSfindLastTrue(start: Int, end: Int, f: (Int) -> Boolean): Int {
    var s = start
    var e = end
    while (s+1 < e) {
        val mid = s + (e - s) / 2
        if (f(mid)) s = mid
        else e = mid - 1
    }
    return if (f(e)) e else s
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
