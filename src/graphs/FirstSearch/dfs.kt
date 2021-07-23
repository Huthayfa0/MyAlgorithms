package graphs.FirstSearch

import java.util.ArrayList

fun dfs(size: Int, adjacencyList: List<List<Int>>, v: Int = 0) {
    val searchOrder = ArrayList<Int>()
    val parent = IntArray(size) { -1 }

    // Mark visited vertices
    val isVisited = BooleanArray(size)
    fun dfs(v: Int) {
        // Store the visited vertex
        searchOrder.add(v)
        isVisited[v] = true
        adjacencyList[v].forEach { e ->
            if (!isVisited[e]) {
                parent[e] = v
                dfs(e)
            }
        }
    }
    // Recursively search
    dfs(v)
}