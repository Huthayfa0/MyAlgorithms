/***
 *  we are given an array of n positive
integers and a target sum x , and we want to find a subarray whose sum is x or
report that there is no such subarray
 */
class SubarraySum {
    /**
     * O(n)
     */
    fun algorithm(array: IntArray, x: Int): Pair<Int, Int>? {
        var i = 0
        var j = 1
        var sum = array[0]
        while (j != array.size) {
            when {
                sum > x -> {
                    sum -= array[i]
                    i++
                }
                sum < x -> {
                    sum += array[j]
                    j++
                }
                else -> {
                    return Pair(i, j)
                }
            }
        }
        return null
    }

}