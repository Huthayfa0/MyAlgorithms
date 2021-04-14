
fun main() {

    val arr= intArrayOf(1,3,4,-1,5,2,10,4,2)
    var staticArrayQueries=StaticArrayQueries(arr)
    while (true) {
        val x= readLine()!!.toInt()
        val y= readLine()!!.toInt()
        println(staticArrayQueries.max(x,y))
    }
}