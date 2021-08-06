package graphs.MST


fun kruskal(size: Int, edges: List<List<Int>>) {
    edges.sortedBy { it[2] }
    /* Arrays.sort(edges, Comparator.comparing { e: IntArray ->
         e[2]
     })*/

    fun getSet(i: Int, parent: IntArray): Int =
        if (parent[i] == i) i else getSet(parent[i], parent).also { parent[i] = it }

    fun unionSets(i: Int, j: Int, ranks: IntArray, parent: IntArray): Boolean {
        val ii = getSet(i, parent)
        val jj = getSet(j, parent)
        if (ii != jj) {
            if (ranks[ii] > ranks[jj]) {
                parent[jj] = ii
            } else if (ranks[jj] > ranks[ii]) {
                parent[ii] = jj
            } else {
                parent[ii] = jj
                ranks[jj]++
            }
            return true
        }
        return false
    }

    val rank = IntArray(size)
    val parent = IntArray(size)
    for (i in 1 until size) {
        parent[i] = i
    }
    var cost = 0
    val pairs = HashSet<List<Int>>()
    for (e in edges) {
        if (unionSets(e[0], e[1], rank, parent)) {
            pairs.add(e)
            cost += e[2]
        }
    }

}

