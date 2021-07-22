package math.komplex
import math.komplex.Complex.Companion.isZero
import kotlin.math.*

fun isCollinear(a: Complex, b: Complex, c: Complex): Boolean {
    return (crossProduct(b - a, c - a)).isZero()
}

fun isPointOnRay(p0: Complex, p1: Complex, p2: Complex): Boolean {
    return if ((p2 - p0).length().isZero() ) true else ((p1 - p0).normalize()== (p2 - p0).normalize())
}
/*
fun isPointOnRay(a: Complex, b: Complex, c: Complex): Boolean {    // not tested?
    return if (!isCollinear(a, b, c)) false else dcmp(dp(b - a, c - a), 0) === 1
}*/

fun isPointOnSegment(a: Complex, b: Complex, c: Complex): Boolean {
    return isPointOnRay(a, b, c) && isPointOnRay(b, a, c)
}
/*
fun isPointOnSegment(a: Complex, b: Complex, c: Complex): Boolean {
    val acb: Double = length(a - b)
    val ac: Double = length(a - c)
    val cb: Double = length(b - c)
    return dcmp(acb - (ac + cb), 0) === 0
}
*/
fun distToLine(p0: Complex, p1: Complex, p2: Complex): Double {
    return abs(crossProduct(p1 - p0, p2 - p0) / (p0 - p1).length()) // area = 0.5*b*h
}


//distance from Complex p2 to segment p0-p1
fun distToSegment(p0: Complex, p1: Complex, p2: Complex): Double {
    var d1: Double
    var d2: Double
    val v1: Complex = p1 - p0
    val v2: Complex = p2 - p0
    if (dotProduct(v1, v2).also { d1 = it } <= 0) return (p2 - p0).length()
    if (dotProduct(v1, v1).also { d2 = it } <= d1) return (p2 - p1).length()
    val t = d1 / d2
    return (p2 - (p0 + v1 * t)).length()
}