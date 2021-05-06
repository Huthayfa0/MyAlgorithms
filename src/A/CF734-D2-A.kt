package A

fun main() {
    val n= readLine()!!.toInt()
    val s= readLine()!!
    val d=s.count { it=='D' }
    val a=n-d
    println(if (d>a)"Danik" else if (a>d) "Anton" else "Friendship")
}