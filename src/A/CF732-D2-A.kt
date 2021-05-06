package A

fun main() {
    val (k,r)=readLine()!!.split(" ").map { it.toInt() }
    var n=1
    var x=k*n%10
    while (x!=r &&x!=0){
        n++
        x=k*n%10
    }
    println(n)
}