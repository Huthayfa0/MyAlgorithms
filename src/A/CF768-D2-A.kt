package A

import java.util.Collections.*

fun main() {
    val n= readLine()!!.toInt()
    val set= readLine()!!.split(" ").map { it.toInt() }.toMutableList()
    val mi= min(set)
    val ma= max(set)
    set-= setOf(mi,ma)
    println("${set.size}")
}