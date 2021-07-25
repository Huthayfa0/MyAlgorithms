package graphs.MST

fun prim(size: Int, adjacencyList: List<List<List<Int>>>, startingVertex: Int = 0) {
    val cost = DoubleArray(size) { Double.POSITIVE_INFINITY }
    cost[startingVertex] = 0.0 // Cost of source is 0
    val parent = IntArray(size) // Parent of a vertex
    parent[startingVertex] = -1 // startingVertex is the root
    val t = mutableSetOf<Int>()

    // Expand T
    while (t.size < size) {
        // Find smallest cost u in V - T
        var u = -1 // Vertex to be determined
        var currentMinCost = Double.POSITIVE_INFINITY
        for (i in 0 until size) {
            if (!t.contains(i) && cost[i] < currentMinCost) {
                currentMinCost = cost[i]
                u = i
            }
        }
        if (u == -1) break else t.add(u)

        // Adjust cost[v] for v that is adjacent to u and v in V - T
        for (e in adjacencyList[u]) {
            val sum = e[2] + cost[u]
            if (!t.contains(e[1]) && cost[e[1]] > sum) {
                cost[e[1]] = sum
                parent[e[1]] = u
            }
        }
    }
}