import kotlin.math.log2

fun main() {

    val arr= intArrayOf(1,3,4,-1,5,2,10,4,2)
    var segmentTree=SegmentTree(arr)
    println(segmentTree.max(0,7))
}