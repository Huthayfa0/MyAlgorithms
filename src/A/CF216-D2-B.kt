package A

fun main() {
    val (n,m)= readLine()!!.split(" ").map{it.toInt()}
    val edges=Array(n){HashSet<Int>()}
    repeat(m){
        val (x,y)= readLine()!!.split(" ").map{it.toInt()}
        edges[x-1].add(y-1)
        edges[y-1].add(x-1)
    }
    val vis=IntArray(n)
    var count=0
    for (i in vis.indices){
        if (vis[i]==0)
            count+=dfs(i,edges,vis,1)
    }
    count/=2
    if (n+count and 1!=0)
        println(count+1)
    else println(count)
}

fun dfs(i: Int, edges: Array<java.util.HashSet<Int>>, vis: IntArray, x: Int): Int {
    if (vis[i]==x){
        return 0
    }else if (vis[i]==-x)
        return 1
    vis[i]=x
    var sum=0
    for (s in edges[i]){
            sum+= dfs(s,edges, vis, -x)
    }
    return sum
}
