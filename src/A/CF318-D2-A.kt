package A

fun main() {
    val (n,k)= readLine()!!.split(" ").map { it.toLong() }
    val q=(n+1)/2
    if (k>q){
        println((k-q)*2)
    }else{
        println(k*2-1)
    }
}