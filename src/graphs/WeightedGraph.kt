package graphs


class WeightedGraph<V> : UnweightedGraph<V> {
    /** Construct an empty  */
    constructor()

    /** Construct a WeightedGraph from vertices and edged in arrays  */
    constructor(vertices: Array<V>, edges: Array<IntArray>) {
        createWeightedGraph(listOf(*vertices), edges)
    }

    /** Construct a WeightedGraph from vertices and edges in list  */
    constructor(edges: Array<IntArray>, numberOfVertices: Int) {
        val vertices = ArrayList<V>()
        for (i in 0 until numberOfVertices)
            vertices.add(i as V)
        createWeightedGraph(vertices, edges)
    }

    /** Construct a WeightedGraph for vertices 0, 1, 2 and edge list  */
    constructor(vertices: List<V>, edges: List<WeightedEdge>) {
        createWeightedGraph(vertices, edges)
    }

    /** Construct a WeightedGraph from vertices 0, 1, and edge array  */
    constructor(
        edges: List<WeightedEdge>,
        numberOfVertices: Int
    ) {
        val vertices = ArrayList<V>()
        for (i in 0 until numberOfVertices)
            vertices.add(i as V)
        createWeightedGraph(vertices, edges)
    }

    /** Create adjacency lists from edge arrays  */
    private fun createWeightedGraph(vertices: List<V>, edges: Array<IntArray>) {
        this.vertices = vertices as ArrayList<V>
        for (i in vertices.indices) {
            neighbors.add(ArrayList()) // Create a list for vertices
        }
        for (i in edges.indices) {
            neighbors[edges[i][0]].add(
                WeightedEdge(edges[i][0], edges[i][1], edges[i][2].toDouble())
            )
        }
    }

    /** Create adjacency lists from edge lists  */
    private fun createWeightedGraph(
        vertices: List<V>, edges: List<WeightedEdge>
    ) {
        this.vertices = vertices as ArrayList<V>
        for (i in vertices.indices) {
            neighbors.add(ArrayList()) // Create a list for vertices
        }
        for (edge: WeightedEdge in edges) {
            neighbors[edge.u].add(edge) // Add an edge into the list
        }
    }

    /** Return the weight on the edge (u, v)  */
    @Throws(Exception::class)
    fun getWeight(u: Int, v: Int): Double {
        for (edge: Edge in neighbors[u]) {
            if (edge.v == v) {
                return (edge as WeightedEdge).weight
            }
        }
        throw Exception("Edge does not exit")
    }

    /** Display edges with weights  */
    fun printWeightedEdges() = println(neighbors.indices.joinToString(separator = "\n") {
        "${getVertex(it)} ($it): " + neighbors[it].joinToString(separator = " ", prefix = "{", postfix = "}") { e ->
            "(" + getVertex(e.u) + ", " + getVertex(e.v) + ", " + (e as WeightedEdge).weight + ")"
        }
    })

    /** Add an edge (u, v, weight) to the graph.  */
    fun addEdge(u: Int, v: Int, weight: Double): Boolean {
        return addEdge(WeightedEdge(u, v, weight))
    }
    /** Return the neighbors of the specified vertex  */
    fun getNeighborsWithWeight(index: Int): List<Pair<Int,Double>> {
        val result: MutableList<Pair<Int,Double>> = java.util.ArrayList()
        for (e: Edge in neighbors[index]) result.add(Pair(e.v,(e as WeightedEdge).weight))
        return result
    }
    /** Get a minimum spanning tree rooted at vertex 0  */
    val shortestPathTree: ShortestPathTree
        get() = getShortestPathTree(0)

    /** O(nm) : n number of nodes and m number of edges
     * Bellman–Ford algorithm
     * Get a minimum spanning tree rooted at a specified vertex  */
    fun getShortestPathTree(startingVertex: Int): ShortestPathTree {
        // cost[v] stores the cost by adding v to the tree
        val cost = DoubleArray(size) { Double.POSITIVE_INFINITY }
        cost[startingVertex] = 0.0 // Cost of source is 0
        val parent = IntArray(size) // Parent of a vertex
        parent[startingVertex] = -1 // startingVertex is the root
        val t = ArrayList<Int>()

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
            if (u == -1) break else t.add(u) // Add a new vertex to T
            // Add cost[u] to the tree

            // Adjust cost[v] for v that is adjacent to u and v in V - T
            for (e: Edge in neighbors[u]) {
                val sum = (e as WeightedEdge).weight + cost[u]
                if (!t.contains(e.v) && cost[e.v] > sum) {
                    cost[e.v] = sum
                    parent[e.v] = u
                }
            }
        } // End of while
        return ShortestPathTree(startingVertex, parent, t, cost)
    }

    /** ShortestPathTree is an inner class in WeightedGraph  */
    inner class ShortestPathTree
    /** Construct a path  */(
        source: Int, parent: IntArray,
        searchOrder: List<Int>, // cost[v] is the cost from v to source
        private val cost: DoubleArray
    ) : SearchTree(source, parent, searchOrder) {
        /** Return the cost for a path from the root to vertex v  */
        fun getCost(v: Int): Double {
            return cost[v]
        }

        /** Print paths from all vertices to the source  */
        fun printAllPaths() {
            println(
                ("All shortest paths from " +
                        vertices[root] + " are:")
            )
            for (i in cost.indices) {
                printPath(i) // Print a path from i to the source
                println("(cost: " + cost[i] + ")") // Path cost
            }
        }
    }
}
