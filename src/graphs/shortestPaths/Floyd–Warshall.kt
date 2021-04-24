package graphs.shortestPaths

import graphs.WeightedGraph
import java.lang.Double.min
import java.util.*

/**
 * O ( n ^3)
 * Dijkstra’s algorithm 2 finds shortest paths from the starting node to all nodes of
the graph, like the Bellman–Ford algorithm. The benefit of Dijsktra’s algorithm
is that it is more efficient and can be used for processing large graphs. However,
the algorithm requires that there are no negative weight edges in the graph.
 */

val <V>WeightedGraph<V>.floydWarshall:Array<DoubleArray>
    get() {
    val distance=adjacencyMatrix
        for (k in 0 until size) {
            for (i in 0 until size) {
                for (j in 0 until size) {
                    distance[i][j] = min(
                        distance[i][j],
                        distance[i][k] + distance[k][j]
                    )
                }
            }
        }

    return distance;
}