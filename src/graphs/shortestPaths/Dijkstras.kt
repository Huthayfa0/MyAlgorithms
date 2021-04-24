package graphs.shortestPaths

import graphs.WeightedGraph
import java.util.*
import kotlin.collections.ArrayList

val <V>WeightedGraph<V>.dijkstraShortestPathTree
    get() = dijkstra(0)

/**
 * O ( n + m log m )
 * Dijkstra’s algorithm 2 finds shortest paths from the starting node to all nodes of
the graph, like the Bellman–Ford algorithm. The benefit of Dijsktra’s algorithm
is that it is more efficient and can be used for processing large graphs. However,
the algorithm requires that there are no negative weight edges in the graph.
 */
fun <V>WeightedGraph<V>.dijkstra(startingVertex:Int):WeightedGraph<V>.ShortestPathTree{
    val cost = DoubleArray(size) { Double.POSITIVE_INFINITY }
    cost[startingVertex] = 0.0 // Cost of source is 0
    val parent = IntArray(size) // Parent of a vertex
    parent[startingVertex] = -1 // startingVertex is the root
    val processed=BooleanArray(size)
    val t = PriorityQueue<Pair<Double,Int>>(Comparator.comparing { it.first })
    val list=ArrayList<Int>()
    t.add(Pair(0.0,startingVertex))
    while (!t.isEmpty()) {
        val a = t.poll().second
        if (processed[a]) continue
        processed[a] = true
        list.add(a)
        for (u in getNeighborsWithWeight(a)) {
            val (b,w) = u
            if (cost[a]+w < cost[b]) {
                parent[b]=a
                cost[b] = cost[a]+w
                t.add(Pair(cost[b],b))
            }
        }
    }

    return ShortestPathTree(startingVertex, parent, list, cost)
}