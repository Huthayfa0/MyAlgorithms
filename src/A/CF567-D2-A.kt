package A

import kotlin.math.*

fun main() {
    val n= readLine()!!.toInt()
    val arr= readLine()!!.split(" ").map { it.toInt() }
    println("${arr[1]-arr[0]} ${arr[n-1]-arr[0]}")
    for (i in 1 until n-1){
        println("${min(arr[i]-arr[i-1],arr[i+1]-arr[i])} ${max(arr[i]-arr[0],arr[n-1]-arr[i])}")
    }
    println("${arr[n-1]-arr[n-2]} ${arr[n-1]-arr[0]}")
}