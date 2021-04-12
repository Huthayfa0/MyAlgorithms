import java.util.*

class NearestSmallerElements {
    /***
     *finding for each array element the
    nearest smaller element, i.e., the first smaller element that precedes the
    element in the array
     */
    /**
     * return array of Pairs if there is no nearest previous smaller elements it will be null
     * else it will contain the
     */
    fun algorithm(array: IntArray):Array<Pair<Int,Int>?>{
        val ans=Array<Pair<Int,Int>?>(array.size){null}
        val stack=Stack<Pair<Int,Int>>()
        stack.add(Pair(0,array[0]))
        for (i in 1 until array.size){
            while (stack.size>0&&array[i]<stack.peek().second){
                stack.pop()
            }
            if (stack.size>0){
                ans[i]=stack.peek()
            }
            stack.push(Pair(i,array[i]))
        }
        return ans
    }
}