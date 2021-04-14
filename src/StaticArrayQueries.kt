import kotlin.math.min as minI
import kotlin.math.max as maxI
import kotlin.math.log2
class StaticArrayQueries(val array:IntArray) {
    private var sumReady = false
    private var minReady = false
    private var maxReady = false
    private val sumArray = IntArray(array.size)
    private val minList= arrayListOf<IntArray>()
    private val maxList= arrayListOf<IntArray>()
    //O(n)
    private fun sumEvaluate() {
        var sum = 0
        for (i in array.indices) {
            sum += array[i]
            sumArray[i] = sum
        }
        sumReady=true
    }
    //O(1)
    fun sum(start: Int = 0, end: Int = array.size): Int {
        if (!sumReady) sumEvaluate()
        return when{
            start<0&&end>array.size->sum()
            start<0->sum(end=end)
            end>array.size->sum(start=start)
            end<=start->0
            start==0->sumArray[end-1]
            else->sumArray[end-1]-sumArray[start]
        }
    }
    //O(nln n)
    //TODO improve to O(n)
    private fun minEvaluate() {
        var count=1
        minList.add(array)
        count=count shl 1
        val slidingWindowMinimum=SlidingWindow()
        while (count<=array.size) {
            minList.add(slidingWindowMinimum.algorithmMin(array, count))
            count=count shl 1
        }
        minReady=true
    }
    //O(ln n)
    fun min(start: Int = 0, end: Int = array.size): Int {
        if (!minReady) minEvaluate()
        val c=log2((end-start+1).toFloat()).toInt()
        var w=1 shl c
        w--
        return when{
            start<0&&end>=array.size->min()
            start<0->min(end=end)
            end>=array.size->min(start=start)
            end<=start->0
            else-> minI(minList[c][start],minList[c][end-w])
        }
    }
    //O(nln n)
    //TODO improve to O(n)
    private fun maxEvaluate() {
        var count=1
        maxList.add(array)
        count=count shl 1
        val slidingWindowMinimum=SlidingWindow()
        while (count<=array.size) {
            maxList.add(slidingWindowMinimum.algorithmMax(array, count))
            count=count shl 1
        }
        maxReady=true
    }
    //O(ln n)
    fun max(start: Int = 0, end: Int = array.size-1): Int {
        if (!maxReady) maxEvaluate()
        val c=log2((end-start+1).toFloat()).toInt()
        var w=1 shl c
        w--
        return when{
            start<0&&end>=array.size->max()
            start<0->max(end=end)
            end>=array.size->max(start=start)
            end<=start->0
            else-> maxI(maxList[c][start],maxList[c][end-w])
        }
    }
}
