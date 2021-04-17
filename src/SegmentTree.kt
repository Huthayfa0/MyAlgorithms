import kotlin.math.max as maxI
import kotlin.math.min as minI

/**
 * A segment tree is a binary tree such that the nodes on the bottom level of the
tree correspond to the array elements, and the other nodes contain information
needed for processing range queries.
 */
class SegmentTree(var array: IntArray) {
    private var minReady = false
    private var maxReady = false
    private val minTree= IntArray(array.size*2)
    private val maxTree= IntArray(array.size*2)

    //O(n)
    private fun minEvaluate() {
        for (i in array.size until minTree.size){
            minTree[i]=array[i-array.size]
        }
        for (i in array.size-1 downTo 0){
            minTree[i]=minI(minTree[i*2],minTree[i*2+1])
        }
    }
    fun min(start: Int = 0, end: Int = array.size): Int {
        if (!minReady) minEvaluate()

        return when{
            start<0&&end>=array.size->min()
            start<0->min(end=end)
            end>=array.size->min(start=start)
            end<start->0
            else-> {
                var s =start+ array.size
                 var e =end+ array.size
                var ans = Int.MAX_VALUE
                while (s <= e) {
                    if (s % 2 == 1) ans = minI(ans,minTree[s++])
                    if (e % 2 == 0) ans = minI(ans,minTree[e--])
                    s /= 2
                    e /= 2
                }
                return s
            }
        }
    }
    //O(nln n)
    //TODO improve to O(n)
    private fun maxEvaluate() {
        for (i in array.size until minTree.size){
            maxTree[i]=array[i-array.size]
        }
        for (i in array.size-1 downTo 0){
            maxTree[i]=maxI(maxTree[i*2],maxTree[i*2+1])
        }
    }
    //O(ln n)
    fun max(start: Int = 0, end: Int = array.size-1): Int {
        if (!maxReady) maxEvaluate()

        return when{
            start<0&&end>=array.size->max()
            start<0->max(end=end)
            end>=array.size->max(start=start)
            end<start->0
            else->{
                var s =start+ array.size
                var e =end+ array.size
                var ans = Int.MIN_VALUE
                while (s <= e) {
                    if (s % 2 == 1) ans = maxI(ans,maxTree[s++])
                    if (e % 2 == 0) ans = maxI(ans,maxTree[e--])
                    s /= 2
                    e /= 2
                }
                return s
            }
        }
    }
}
