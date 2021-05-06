package A

fun main() {
    val n= readLine()!!.toInt()
    var count=0
    repeat(n){
        val arr= readLine()!!.split(" ").map { it.toInt() }
        if (arr[0]+arr[1]+arr[2]>1)count++
    }
    println(count)
}