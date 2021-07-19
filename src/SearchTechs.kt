/**
 * finds the first occurrence of a number
 */
private fun BSfindFirst(start: Int, end: Int, x: Int,f:(Int)->Int): Int {
    var s = start
    var e = end
    while (s < e) {
        val mid = s + (e - s) / 2
        if (f(mid) < x) s = mid + 1
        else if (f(mid) > x) e = mid - 1
        else e = mid
    }
    return s
}

/**
 * finds the last occurrence of a number
 */
private fun BSfindLast(start: Int, end: Int, x: Int,f:(Int)->Int): Int {
    var s = start
    var e = end
    while (s < e) {
        val mid = s + (e - s) / 2
        if (f(mid) < x) s = mid + 1
        else if (f(mid) > x) e = mid - 1
        else s = mid
    }
    return s
}

fun binary( start:Double, end:Double,can:(Double)->Boolean):Double{
    var s=start
    var e=end
    repeat(100){
        val mid = (s + e) / 2
        if (can(mid)) e = mid else s = mid
    }

    if( can(e) )
        return s

    return -1.0	// failed
}
