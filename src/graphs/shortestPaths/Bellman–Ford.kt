package graphs.shortestPaths

fun BellmanFord(graph: Array<IntArray>, V: Int, E: Int, src: Int) {
    // Initialize distance of all vertices as infinite.
    val dis = IntArray(V) { Int.MAX_VALUE }

    // initialize distance of source as 0
    dis[src] = 0

    // Relax all edges |V| - 1 times. A simple
    // shortest path from src to any other
    // vertex can have at-most |V| - 1 edges
    for (i in 0 until V - 1) {
        for (j in 0 until E) {
            if (dis[graph[j][0]] != Int.MAX_VALUE && dis[graph[j][0]] + graph[j][2] <
                dis[graph[j][1]]
            ) dis[graph[j][1]] = dis[graph[j][0]] + graph[j][2]
        }
    }

    // check for negative-weight cycles.
    // The above step guarantees shortest
    // distances if graph doesn't contain
    // negative weight cycle. If we get a
    // shorter path, then there is a cycle.
    for (i in 0 until E) {
        val x = graph[i][0]
        val y = graph[i][1]
        val weight = graph[i][2]
        if (dis[x] != Int.MAX_VALUE && dis[x] + weight < dis[y]) println("Graph contains negative weight cycle")
    }
    println("Vertex Distance from Source")
    for (i in 0 until V) println("$i\t\t${dis[i]}")
}
