package graphs.FirstSearch

import java.util.ArrayList

fun dfs(size: Int, adjacencyList: List<List<List<Int>>>, v: Int = 0) {
    val searchOrder = ArrayList<Int>()
    val parent = IntArray(size) { -1 }

    // Mark visited vertices
    val isVisited = BooleanArray(size)
    fun dfs(v: Int) {
        // Store the visited vertex
        searchOrder.add(v)
        isVisited[v] = true // Vertex v visited
        adjacencyList[v].forEach { e -> // Note that e.u is v
            if (!isVisited[e[1]]) { // e.v is w in Listing 28.8
                parent[e[1]] = v // The parent of w is v
                dfs(e[1]) // Recursive search
            }
        }
    }
    // Recursively search
    dfs(v)
}