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

fun getCombinationCountArray(n:Int,m:Int){
    require(n>=m)
    val arr=Array(m+1){LongArray(n+1)}
    for (i in 0 until m+1)
        for (j in 0 until n+1)
            arr[i][j]=when{
                j==0->1
                i==0->0
                else-> arr[i-1][j-1]+arr[i-1][j]
            }

}
fun main(){
    combinationsIteration(4,2){ println(it.joinToString())}
}