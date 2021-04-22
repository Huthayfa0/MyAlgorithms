package graphs

interface Graph<V> {
    /** Return the number of vertices in the graph  */
    val size: Int

    /** Return the vertices in the graph  */
    val vertices: List<V>?

    /** Return the object for the specified vertex index  */
    fun getVertex(index: Int): V

    /** Return the index for the specified vertex object  */
    fun getIndex(v: V): Int

    /** Return the neighbors of vertex with the specified index  */
    fun getNeighbors(index: Int): List<Int?>

    /** Return the degree for a specified vertex  */
    fun getDegree(v: Int): Int

    /** Print the edges  */
    fun printEdges()

    /** Clear the graph  */
    fun clear()

    /** Add a vertex to the graph  */
    fun addVertex(vertex: V): Boolean

    /** Add an edge (u, v) to the graph  */
    fun addEdge(u: Int, v: Int): Boolean

    /** Add an edge to the graph  */
    fun addEdge(e: Edge): Boolean

    /** Remove a vertex v from the graph, return true if successful  */
    fun remove(v: V): Boolean

    /** Remove an edge (u, v) from the graph  */
    fun remove(u: Int, v: Int): Boolean

    /** Obtain a depth-first search tree  */
    fun dfs(v: Int): UnweightedGraph<V>.SearchTree?

    /** Obtain a breadth-first search tree  */
    fun bfs(v: Int): UnweightedGraph<V>.SearchTree?
}
