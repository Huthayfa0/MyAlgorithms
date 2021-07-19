package numbers

import java.util.*
import kotlin.collections.ArrayList

/**
 * iterates on n elements
 * if n=3 ,m=3 , f=  println(it.joinToString())
 * 0 1 2
 * 0 2 1
 * 1 0 2
 * 1 2 0
 * 2 0 1
 * 2 1 0
 */
fun permutationsIteration(n:Int,m:Int=n,f:(LinkedList<out Int>)->Unit){
    val list= LinkedList<Int>()
    var count=0
    val visited=BooleanArray(n)

    fun getPerm(i:Int=0){
        if (i==m){
            f(list)
            count++
            return
        }
        for (j in 0 until n){
            if (visited[j])
                continue
            list.add(j)
            visited[j]=true
            getPerm(i+1)
            visited[j]=false
            list.removeLast()
        }
    }

    getPerm()
}
fun main(){
    permutationsIteration(4,2){ println(it.joinToString())}
}