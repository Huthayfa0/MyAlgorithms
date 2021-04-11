import java.lang.Integer.max

/***Given an array of n numbers, our task is to calculate the maximum subarray sum*/
class MaximumSubarraySum {
    /**
     *
     * @param array contains integer elements
     * @param start the point were you want to start (inclusive)
     * @param end the point were you want to finish (exclusive)
     * @return the maximum array
     */

    fun algorithm(array: IntArray, start: Int = 0, end: Int = array.size): Int {
        var best = 0
        var sum = 0
        for (k in start until end) {
            sum = max(array[k], sum + array[k])
            best = max(best, sum)
        }
        return best
    }

    /**
     * O(end-start)
     * @param array represents integers
     * @param end
     * @param start =0
     * @return returns maximum sum of subarray and it's indices <sum, <start,end>>
     */
    fun algorithmWithIndices(array: IntArray, start: Int = 0, end: Int = array.size): Pair<Int, Pair<Int, Int>> {
        var best = Pair(0, Pair(start, start))
        var sum = Pair(0, Pair(start, start))

        for (k in start until end) {
            val temp1 = Pair(array[k], Pair(k, k + 1))
            val temp2 = Pair(sum.first + array[k], Pair(sum.second.first, k + 1))
            sum = if (temp1.first > temp2.first) temp1 else temp2
            best = if (best.first > sum.first) best else sum
        }
        return best
    }
}