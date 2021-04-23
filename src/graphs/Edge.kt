package graphs

open class Edge(val u: Int, val v: Int) {
    override fun equals(other: Any?): Boolean {
        return u == (other as Edge?)!!.u && v == other!!.v
    }

    override fun hashCode(): Int {
        var result = u
        result = 31 * result + v
        return result
    }
}