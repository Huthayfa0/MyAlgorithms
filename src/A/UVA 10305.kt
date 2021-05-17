package A

val an= mutableListOf<Int>()
fun main() {
    val (n,k)= readLine()!!.split(" ").map { it.toInt() }
    val adjacency=Array(n){ mutableSetOf<Int>()}
    while(true){
        val (i,j)= readLine()!!.split(" ").map {x->x.toInt() }
        if(i==0 || j==0)
            break
        adjacency[i-1].add(j-1)
    }
    val vis=BooleanArray(n)

    for (i in vis.indices){
        if (!vis[i]){
            dfss(i,vis,adjacency)
        }
    }
    println(an.reversed().joinToString(separator = " ") {x->""+(x+1)})
}

fun dfss(i: Int, vis: BooleanArray, adjacency: Array<MutableSet<Int>>) {
    vis[i]=true
    for (x in adjacency[i]){
        if (!vis[x]){
            dfss(x,vis,adjacency)
        }
    }
    an.add(i)
}
