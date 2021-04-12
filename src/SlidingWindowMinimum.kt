import java.util.*
import java.util.Collections.min

class SlidingWindowMinimum {
    /***
     * maintaining the sliding window minimum
     * O(n)
     */
fun algorithm(array: IntArray,slidingWindowSize:Int):IntArray{
        if (slidingWindowSize>=array.size)return IntArray(1) { min(array.toList()) }
        val ans=IntArray(array.size-slidingWindowSize+1)
        val queue=LinkedList<Pair<Int,Int>>()
        for (i in 0 until slidingWindowSize){
            if (queue.size==0||queue.last.second<array[i]){
                queue.addLast(Pair(i,array[i]))
            }else {
                while (queue.size!=0&&queue.last.second>=array[i]){
                    queue.removeLast()
                }
                queue.addLast(Pair(i,array[i]))
            }
        }
        ans[0]=queue.first.second
        for (i in slidingWindowSize until array.size){
            if (queue.size==0||queue.last.second<array[i]){
                queue.addLast(Pair(i,array[i]))
            }else {
                while (queue.size!=0&&queue.last.second>=array[i]){
                    queue.removeLast()
                }
                queue.addLast(Pair(i,array[i]))
            }
            if (queue.first.first==i-slidingWindowSize)queue.pop()
            ans[i-slidingWindowSize+1]=queue.first.second
        }
    return ans
}
}

fun main() {
    val arr= intArrayOf(1,3,4,-1,5,2,10,4,2)
    println(SlidingWindowMinimum().algorithm(arr,4).joinToString())
}