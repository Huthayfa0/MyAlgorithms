package graphs

class WeightedEdge(u: Int, v: Int,var weight: Double
    ) : Edge(u, v),
    Comparable<WeightedEdge?> {
    /** Compare two edges on weights  */
    override fun compareTo(other: WeightedEdge?): Int {
        if (other != null) {
            return if (weight > other.weight) {
                1
            } else if (weight == other.weight) {
                0
            } else {
                -1
            }
        }
        return 0
    }
}
