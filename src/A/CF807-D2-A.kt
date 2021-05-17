package A

fun main() {
    val n= readLine()!!.toInt()
    val arr=Array(n){
        readLine()!!.split(" ").map { it.toInt() }
    }
    var case=false
    for (x in arr){
        if (x[0]!=x[1]){
            case=true
            break
        }
    }
    if (case)
        println("rated")
    else{
        for (i in 1 until n){
            if (arr[i][0]>arr[i-1][1]){
                case=true
                break
            }
        }

    if (case)
        println("unrated")
    else
        println("maybe")
    }
}