class StaticArrayQueries(val array:IntArray) {
    private val sumReady=false
    private val minReady=false
    private val maxReady=false
    private val sumArray=IntArray(array.size)
    private fun sumEvaluate(){
        var sum=0
        for (i in array.indices){
            sum+=array[i]
            sumArray[i]=sum
        }
    }
    fun sum( first:Int=0, end:Int=array.size):Int{
        if (!sumReady)sumEvaluate()

        return if (end>array.size)
            sumArray[array.size-1]-sumArray[first]
        else sumArray[end-1]-sumArray[first]
    }
}