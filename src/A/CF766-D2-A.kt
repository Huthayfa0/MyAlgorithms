package A

import kotlin.math.max

fun main() {
    val str1= readLine()!!
    val str2= readLine()!!
    if (str1 == str2){
        println(-1)
    }else
        println(max(str1.length,str2.length))
}