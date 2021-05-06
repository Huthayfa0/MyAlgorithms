package A

import kotlin.math.abs

fun main() {
    var i=0
    var j=0
    repeat(5){
        val arr= readLine()!!.split(" ").map { it.toInt() }
        val x=arr.indexOf(1)
        if (x!=-1){
            i=it
            j=x
        }
    }
    println(abs(i-2)+ abs(j-2))
}