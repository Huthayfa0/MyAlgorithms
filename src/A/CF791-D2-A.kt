package A

fun main() {
    var (a,b)= readLine()!!.split(" ").map { it.toInt() }
    var count=0
    while (a<=b){
        count++
        a*=3
        b*=2
    }
    println(count)
}