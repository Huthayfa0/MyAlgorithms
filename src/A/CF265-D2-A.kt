package A

fun main() {
    val str= readLine()!!
    val ins= readLine()!!
    var count=0
    for (c in ins){
        if (c==str[count])count++
    }
    println(count+1)
}