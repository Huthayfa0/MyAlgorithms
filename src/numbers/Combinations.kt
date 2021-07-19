package numbers

import java.util.*


/**
 * iterates on n elements
 * if n=3 ,m=2 , f=  println(it.joinToString())
 * 0 1
 * 0 2
 * 2 1
 */
fun combinationsIteration(n:Int, m:Int, f:(LinkedList<out Int>)->Unit){
    val list= LinkedList<Int>()
    var count=0

    fun getCombination(i:Int=0,lastVal:Int=0){
        if (i==m){
            f(list)
            count++
            return
        }
        for (j in lastVal until n){
            list.add(j)
            getCombination(i+1,j+1)
            list.removeLast()
        }
    }

    getCombination()
}
fun main(){
    combinationsIteration(4,2){ println(it.joinToString())}
}