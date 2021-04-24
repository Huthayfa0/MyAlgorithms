package graphs

import java.util.*


open class UnweightedGraph<V> : Graph<V> {
    override var vertices = ArrayList<V>() // Store vertices
    protected var neighbors: MutableList<MutableList<Edge>> = ArrayList() // Adjacency lists

    /** Construct an empty graph  */
    constructor()

    /** Construct a graph from vertices and edges stored in arrays  */
    constructor(vertices: Array<V>, edges: Array<IntArray>) {
        for (v in vertices)
            addVertex(v)
        createAdjacencyLists(edges)
    }

    /** Construct a graph from vertices and edges stored in List  */
    constructor(vertices: List<V>, edges: List<Edge>) {
        for (v in vertices)
            addVertex(v)
        createAdjacencyLists(edges)
    }

    /** Construct a graph for integer vertices 0, 1, 2 and edge list  */
    constructor(edges: List<Edge>, numberOfVertices: Int) {
        for (i in 0 until numberOfVertices)
            addVertex(i as V) // vertices is {0, 1, ...}
        createAdjacencyLists(edges)
    }

    /** Construct a graph from integer vertices 0, 1, and edge array  */
    constructor(edges: Array<IntArray>, numberOfVertices: Int) {
        for (i in 0 until numberOfVertices)
            addVertex(i as V) // vertices is {0, 1, ...}
        createAdjacencyLists(edges)
    }

    /** Create adjacency lists for each vertex  */
    private fun createAdjacencyLists(
        edges: Array<IntArray>//, numberOfVertices: Int
    ) {
        for (i in edges.indices) {
            addEdge(edges[i][0], edges[i][1])
        }
    }

    /** Create adjacency lists for each vertex  */
    private fun createAdjacencyLists(
        edges: List<Edge>//, numberOfVertices: Int
    ) {
        for (edge: Edge in edges) {
            addEdge(edge.u, edge.v)
        }
    }

    /** Return the number of vertices in the graph  */
    override val size: Int
    get() = vertices.size



    /** Return the object for the specified vertex  */
    override fun getVertex(index: Int) = vertices[index]

    /** Return the index for the specified vertex object  */
    override fun getIndex(v: V) = vertices.indexOf(v)

    /** Return the neighbors of the specified vertex  */
    override fun getNeighbors(index: Int): List<Int?> {
        val result: MutableList<Int?> = ArrayList()
        for (e: Edge in neighbors[index]) result.add(e.v)
        return result
    }

    /** Return the degree for a specified vertex  */
    override fun getDegree(v: Int): Int = neighbors[v].size

    /** Print the edges  */
    override fun printEdges() = println(neighbors.indices.joinToString(separator = "\n") {
        "${getVertex(it)} ($it): " + neighbors[it].joinToString(separator = ", ", prefix = "{", postfix = "}") { e ->
            "("+getVertex(e.u) + ", " + getVertex(e.v) + ")"
        }
    })


    /** Clear the graph  */
    override fun clear() {
        vertices.clear()
        neighbors.clear()
    }

    /** Add a vertex to the graph  */
    final override fun addVertex(vertex: V): Boolean {
        return if (!vertices.contains(vertex)) {
            vertices.add(vertex)
            neighbors.add(ArrayList())
            true
        } else false
    }

    /** Add an edge to the graph  */
    override fun addEdge(e: Edge): Boolean {
        if (e.u < 0 || e.u > size - 1) throw IllegalArgumentException("No such index: " + e.u)
        if (e.v < 0 || e.v > size - 1) throw IllegalArgumentException("No such index: " + e.v)
        return if (!neighbors[e.u].contains(e)) {
            neighbors[e.u].add(e)
            true
        } else false

    }

    /** Add an edge to the graph  */
    override fun addEdge(u: Int, v: Int): Boolean {
        return addEdge(Edge(u, v))
    }

    /** Remove vertex v and return true if successful  */
    override fun remove(v: V): Boolean {
        val index = vertices.indexOf(v)
        if (index != -1) {
            vertices.removeAt(index)
            neighbors.removeAt(index)
            neighbors.forEach { it.removeIf { edge -> edge.v == index } }
            return true
        }
        return false
    }

    /** Remove edge (u, v) and return true if successful  */
    override fun remove(u: Int, v: Int): Boolean {
        if (u < 0 || u > size - 1) throw IllegalArgumentException("No such index: $u")
        return neighbors[u].remove(Edge(u, v))
    }

    /** Obtain a DFS tree starting from vertex u  */

    override fun dfs(v: Int): SearchTree {
        val searchOrder = ArrayList<Int>()
        val parent = IntArray(vertices.size) { -1 }

        // Mark visited vertices
        val isVisited = BooleanArray(vertices.size)

        // Recursively search
        dfs(v, parent, searchOrder, isVisited)

        // Return a search tree
        return SearchTree(v, parent, searchOrder)
    }

    /** Recursive method for DFS search  */
    private fun dfs(v: Int, parent: IntArray, searchOrder: MutableList<Int>, isVisited: BooleanArray) {
        // Store the visited vertex
        searchOrder.add(v)
        isVisited[v] = true // Vertex v visited
        neighbors[v].forEach { e -> // Note that e.u is v
            if (!isVisited[e.v]) { // e.v is w in Listing 28.8
                parent[e.v] = v // The parent of w is v
                dfs(e.v, parent, searchOrder, isVisited) // Recursive search
            }
        }
    }

    /** Starting bfs search from vertex v  */
    override fun bfs(v: Int): SearchTree {
        val searchOrder: MutableList<Int> = ArrayList()
        val parent = IntArray(vertices.size) { -1 } // Initialize parent[i] to -1
        val queue = LinkedList<Int>() // list used as a queue
        val isVisited = BooleanArray(vertices.size)
        queue.offer(v) // Enqueue v
        isVisited[v] = true // Mark it visited
        while (!queue.isEmpty()) {
            val u = queue.poll() // Dequeue to u
            searchOrder.add(u) // u searched
            neighbors[u].forEach { e -> // Note that e.u is u
                if (!isVisited[e.v]) { // e.v is w in Listing 28.11
                    queue.offer(e.v) // Enqueue w
                    parent[e.v] = u // The parent of w is u
                    isVisited[e.v] = true // Mark w visited
                }
            }
        }
        return SearchTree(v, parent, searchOrder)
    }

    /** Tree inner class inside the AbstractGraph class  */
    open inner class SearchTree(
        /** Return the root of the tree  */
        val root // The root of the tree
        : Int, // Store the parent of each vertex
        private var parent: IntArray,
        val searchOrder: List<Int>
    ) {


        /** Return the parent of vertex v  */
        fun getParent(v: Int): Int {
            return parent[v]
        }

        /** Return number of vertices found  */
        fun getNumberOfVerticesFound(): Int {
            return searchOrder.size
        }

        /** Return the path of vertices from a vertex to the root  */
        fun getPath(index: Int): List<V> {
            var i = index
            val path = ArrayList<V>()
            do {
                path.add(vertices[i])
                i = parent[i]
            } while (i != -1)
            return path
        }

        /** Print a path from the root to vertex v  */
        fun printPath(index: Int) {
            val path = getPath(index)
            println(
                "A path from " + vertices[root] + " to " +
                        vertices[index] + ": " + path.reversed().joinToString()
            )

        }

        /** Print the whole tree  */
        fun printTree() {
            println("Root is: " + vertices[root])
            print("Edges: ")
            for (i in parent.indices) {
                if (parent[i] != -1) {
                    // Display an edge
                    print(
                        ("(" + vertices[parent[i]] + ", " +
                                vertices[i] + ") ")
                    )
                }
            }
            println()
        }

    }

}
