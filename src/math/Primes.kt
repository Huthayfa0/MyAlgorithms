package math

import java.util.*

class Primes {
    fun prime(n: Int): Boolean {
        if (n < 2) return false
        var x = 2
        while (x * x <= n) {
            if (n % x == 0) return false
            x++
        }
        return true
    }
    fun factors(v: Int): LinkedList<Int> {
        var n = v
        val f= LinkedList<Int>()
        var x = 2
        while (x * x <= n) {
            while (n % x == 0) {
                f.addLast(x)
                n /= x
            }
            x++
        }
        if (n > 1) f.addLast(n)
        return f
    }
}