package A

fun main() {
    val (n,h)= readLine()!!.split(" ").map { it.toInt() }
    var sum=0
    val arr=readLine()!!.split(" ").map { it.toInt() }
    for (x in arr){
        if (x>h)sum+=2
        else sum++
    }
    println(sum)
}