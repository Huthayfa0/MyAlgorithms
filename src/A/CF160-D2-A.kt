package A

fun main() {
    val n=readLine()!!.toInt()
    val arr= readLine()!!.split(" ").map { it.toInt() }.sorted()
    var sum=arr.sum()
    var summ=0
    println("${arr.takeLastWhile { summ+=it
        sum-=it
        return@takeLastWhile sum>=summ
    }.size+1}")
}