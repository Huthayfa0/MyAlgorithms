package A
/*
3
6241
8191
 */

fun main() {
    var n= readLine()!!.toInt()
    while (n!=0){
        println(if (solve(n))"Yes" else "No")
        n= readLine()!!.toInt()
    }
}

fun solve(n: Int): Boolean {
    var count=0
    var x=n

    while (x and 1==0){
        x/=2
        count++
    }
    var ans=count
    var i=3
    while (i<=x){
        count=0
        while (x%i==0){
            x/=i
            count++
        }
        if (count!=0)
            ans=(ans+1)*(count+1)
        i+=2
    }
    return ans and 1==1
}
