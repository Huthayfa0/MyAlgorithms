import arrayQuieres.SegmentTree
import graphs.Edge
import graphs.UnweightedGraph

fun main() {
val unweightedGraph=UnweightedGraph<Int>(ArrayList(),5)
    unweightedGraph.addEdge(0,1)
    unweightedGraph.addEdge(1,0)
    unweightedGraph.addEdge(0,3)
    unweightedGraph.addEdge(3,0)
    unweightedGraph.addEdge(1,2)
    unweightedGraph.addEdge(2,1)
    unweightedGraph.addEdge(2,4)
    unweightedGraph.addEdge(4,2)
    unweightedGraph.addEdge(4,1)
    unweightedGraph.addEdge(1,4)
    unweightedGraph.printEdges()
}