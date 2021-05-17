package A


fun main() {
    val ans= mutableListOf<Int>()
    val (n,k)= readLine()!!.split(" ").map { it.toInt() }
    val adjacency=Array(n){ mutableSetOf<Int>()}
    repeat(k){
        val arr= readLine()!!.split(" ").map {x->x.toInt() }
        for (i in 1 until arr.size){
            adjacency[it].add(arr[i]-1)
        }
    }
    val vis=BooleanArray(n)

    for (i in vis.indices){
        if (!vis[i]){
            dfs(i,vis,adjacency,ans)
        }
    }
    val arr=IntArray(n)
    var p=0
    for (x in ans.size-1 downTo 0){
        arr[ans[x]]=p
        p=ans[x]+1
    }
    println(arr.joinToString (separator = "\n"))
}

fun dfs(i: Int, vis: BooleanArray, adjacency: Array<MutableSet<Int>>, ans: MutableList<Int>) {
    vis[i]=true
    for (x in adjacency[i]){
        if (!vis[x]){
            dfs(x,vis,adjacency,ans)
        }
    }
    ans.add(i)
}
