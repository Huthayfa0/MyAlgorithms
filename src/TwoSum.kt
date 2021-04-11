/***
 * given an array of n numbers and a
target sum x , find two array values such that their sum is x , or report that no
such values exist.
 */
/***
 *  we are given an array of n positive
integers and a target sum x , and we want to find a subarray whose sum is x or
report that there is no such subarray
 */
class TwoSum {
    /*
    array should be sorted
     */
    fun unsortedAlgorithm(array: IntArray, x: Int): Pair<Int, Int>? {
        val arr=array.clone()
        arr.sort()
        return algorithm(arr,x)
    }
    /*
    array should be sorted
     */
    fun algorithm(array: IntArray, x: Int): Pair<Int, Int>? {
        var i = 0
        var j = array.size-1
        var sum = array[i]+array[j]
        while (j != i) {
            sum = when {
                sum > x -> {
                    j--
                    array[i]+array[j]
                }
                sum < x -> {
                    i++
                    array[i]+array[j]
                }
                else -> {
                    return Pair(i, j)
                }
            }
        }
        return null
    }
}
