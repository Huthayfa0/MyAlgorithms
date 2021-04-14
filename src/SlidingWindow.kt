import java.util.*
import java.util.Collections.min

class SlidingWindow {
    /***
     * maintaining the sliding window minimum
     * O(n)
     */
fun algorithmMin(array: IntArray, slidingWindowSize:Int):IntArray{
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
    /***
     * maintaining the sliding window minimum
     * O(n)
     */
    fun algorithmMax(array: IntArray, slidingWindowSize:Int):IntArray{
        if (slidingWindowSize>=array.size)return IntArray(1) { min(array.toList()) }
        val ans=IntArray(array.size-slidingWindowSize+1)
        val queue=LinkedList<Pair<Int,Int>>()
        for (i in 0 until slidingWindowSize){
            if (queue.size==0||queue.last.second>array[i]){
                queue.addLast(Pair(i,array[i]))
            }else {
                while (queue.size!=0&&queue.last.second<=array[i]){
                    queue.removeLast()
                }
                queue.addLast(Pair(i,array[i]))
            }
        }
        ans[0]=queue.first.second
        for (i in slidingWindowSize until array.size){
            if (queue.size==0||queue.last.second>array[i]){
                queue.addLast(Pair(i,array[i]))
            }else {
                while (queue.size!=0&&queue.last.second<=array[i]){
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
