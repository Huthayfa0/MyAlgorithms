import graphs.WeightedGraph
import graphs.shortestPaths.dijkstra
import graphs.shortestPaths.dijkstraShortestPathTree

fun main() {
val weightedGraph=WeightedGraph<Int>(ArrayList(),5)
    weightedGraph.addEdge(0,1,5.0)
    weightedGraph.addEdge(1,0,5.0)
    weightedGraph.addEdge(0,2,3.0)
    weightedGraph.addEdge(2,0,3.0)
    weightedGraph.addEdge(0,3,7.0)
    weightedGraph.addEdge(3,0,7.0)
    weightedGraph.addEdge(1,3,3.0)
    weightedGraph.addEdge(3,1,3.0)
    weightedGraph.addEdge(4,1,2.0)
    weightedGraph.addEdge(1,4,2.0)
    weightedGraph.addEdge(4,3,2.0)
    weightedGraph.addEdge(3,4,2.0)
    weightedGraph.addEdge(3,2,1.0)
    weightedGraph.addEdge(2,3,1.0)

    val x=weightedGraph.dijkstraShortestPathTree
    x.printAllPaths()

}