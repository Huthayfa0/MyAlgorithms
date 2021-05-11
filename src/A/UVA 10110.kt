package A
/*
3
6241
8191
 */

fun main() {
    var n= readLine()!!.toInt()
    while (n!=0){
        println(if (solve(n))"Yes" else "No")
        n= readLine()!!.toInt()
    }
}

fun solve(n: Int): Boolean {
    val x = Math.sqrt(n.toDouble()).toInt()
    return x * x == n
}
