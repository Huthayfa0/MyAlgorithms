/*
fun main() {
//val x=convert("ABC",2)
    println(-((1 shl 31)+1))
    var x=HashSet<Int>()
    var y=3
    x.toArray()[0] as Int
/*
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
*/

}
fun plusOne(digits: IntArray): IntArray {
    for (i in digits.size-1 downTo 0){
        if (digits[i]==9){
            digits[i]=0
        }else{
            digits[i]++
            break
        }
    }
    if (digits[0]==0){
        return intArrayOf(1)+digits
    }

    return digits
}
*/
