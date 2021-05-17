package A

fun main() {
    val n= readLine()!!.toInt()
    val set=HashSet<Int>()
    set.addAll(readLine()!!.split(" ").map { it.toInt() }.drop(1))
    set.addAll(readLine()!!.split(" ").map { it.toInt() }.drop(1))
    println(if (set.size==n)"I become the guy." else "Oh, my keyboard!")

}