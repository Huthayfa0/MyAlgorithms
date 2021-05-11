package A

fun main() {
    val n= readLine()!!.toInt()
    val arr= readLine()!!.split(" ").map { it.toInt() }
    val ans=IntArray(n)
    arr.forEachIndexed { index, i -> ans[i-1]=index+1 }
    println(ans.joinToString(separator = " "))
}