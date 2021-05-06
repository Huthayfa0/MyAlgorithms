package A

fun main() {
    val arr= readLine()!!.split(" ").map { it.toInt() }
    val x=HashSet(arr)
    println(4-x.size)
}