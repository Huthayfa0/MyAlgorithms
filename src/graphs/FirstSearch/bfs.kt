package graphs.FirstSearch

import java.util.*

fun bfs(size: Int, adjacencyList: List<List<Int>>, v: Int = 0) {
    val searchOrder: MutableList<Int> = java.util.ArrayList()
    val parent = IntArray(size) { -1 } // Initialize parent[i] to -1
    val queue = LinkedList<Int>() // list used as a queue
    val isVisited = BooleanArray(size)
    queue.offer(v) // Enqueue v
    isVisited[v] = true // Mark it visited
    while (!queue.isEmpty()) {
        val u = queue.poll() // Dequeue to u
        searchOrder.add(u) // u searched
        adjacencyList[u].forEach { e -> // Note that e.u is u
            if (!isVisited[e]) { // e.v is w in Listing 28.11
                queue.offer(e) // Enqueue w
                parent[e] = u // The parent of w is u
                isVisited[e] = true // Mark w visited
            }
        }
    }

}