import java.util.*
import kotlin.math.*

//RotateArray MergeSort FirstSearch ShoretestPath
//MinimumSpanningTree Primes Permutations
//Combinations BinarySearchTechs ComplexAndGeometry 
fun main() {
    val t=readlnInt()
    repeat(t) {
        val (n, m) = readlnInts()
        val arr=Array(n){
            readln().toCharArray()
        }
        val isVisited = Array(n){IntArray(m){ Int.MAX_VALUE} }
        var j=-1
        var i=arr.indexOfFirst { it.indexOfFirst { c-> c=='S' }.also {x-> if (x!=-1)j=x }!=-1 }

        fun bfs() {
            val queue = PriorityQueue<Triple<Int,Int,Int>>(Comparator.comparing<Triple<Int, Int, Int>, Int> { it.third })
            queue.offer(Triple(i,j,0)) // Enqueue v
            while (!queue.isEmpty()) {
                val u = queue.poll() // Dequeue to
                val (i,j,x)=u

                isVisited[i][j]= min(x,isVisited[i][j])
                for (ii in (i+1) until n){
                    if (arr[ii][j]=='X')
                        break
                    if (isVisited[ii][j]==Int.MAX_VALUE)
                    queue.offer(Triple(ii,j,x+1))
                }
                for (ii in 0 until (i-1)){
                    if (arr[ii][j]=='X')
                        break
                    if (isVisited[ii][j]==Int.MAX_VALUE)
                    queue.offer(Triple(ii,j,x+1))
                }
                for (jj in (j+1) until m){
                    if (arr[i][jj]=='X')
                        break
                    if (isVisited[i][jj]==Int.MAX_VALUE)
                    queue.offer(Triple(i,jj,x+1))
                }
                for (jj in 0 until (j-1)){
                    if (arr[i][jj]=='X')
                        break
                    if (isVisited[i][jj]==Int.MAX_VALUE)
                    queue.offer(Triple(i,jj,x+1))
                }
                for (ii in 0 until (min(m-j,n-i))) {
                    if (arr[i + ii][j + ii] == 'X')
                        break
                    if (isVisited[i+ii][j+ii]==Int.MAX_VALUE)
                    queue.offer(Triple(i+ii,j+ii,x+1))
                }
                for (ii in 0 until (min(j,n-i))) {
                    if (arr[i + ii][j - ii] == 'X')
                        break
                    if (isVisited[i+ii][j-ii]==Int.MAX_VALUE)
                    queue.offer(Triple(i+ii,j-ii,x+1))
                }
                for (ii in 0 until (min(m-j,i))) {
                    if (arr[i - ii][j + ii] == 'X')
                        break
                    if (isVisited[i-ii][j+ii]==Int.MAX_VALUE)
                    queue.offer(Triple(i-ii,j+ii,x+1))
                }
                for (ii in 0 until (min(j,i))) {
                    if (arr[i - ii][j - ii] == 'X')
                        break
                    if (isVisited[i-ii][j-ii]==Int.MAX_VALUE)
                    queue.offer(Triple(i-ii,j-ii,x+1))
                }

            }
        }
        bfs()
        i=arr.indexOfFirst { it.indexOfFirst { c-> c=='F' }.also {x-> if (x!=-1)j=x }!=-1 }
        if (isVisited[i][j]== Int.MAX_VALUE)
            println(-1)
        else
            println(isVisited[i][j])

    }
}



//Scanner code, if wanted to read from file just change the first
private fun readln() = readLine()!!.trim()
private fun readlnInt() = readln().toInt()
private fun readlnLong() = readln().toLong()
private fun readlnDouble() = readln().toDouble()
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
private fun readInts(n: Int) = generateSequence { readInt() }.take(n)
private fun readLongs(n: Int) = generateSequence { readLong() }.take(n)
private fun readDoubles(n: Int) = generateSequence { readDouble() }.take(n)
