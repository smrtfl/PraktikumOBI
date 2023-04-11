import kotlin.math.abs
import kotlin.math.pow
import kotlin.random.Random

fun Boolean.toInt(): Int {
    if (this) {
        return 1
    }
    else {
        return 0
    }
}

fun Int.toBoolean(): Boolean {
    if (this == 1) {
        return true
    }
    else {
        return false
    }
}

fun fact(n: Int): Int {
    if (n == 1) {
    	return n
   	}
    else {
        return n * fact(n - 1)
    }
}

fun gcd(a: Int, b: Int): Int {   
    var n1 = a
    var n2 = b
    
    while (n1 != n2) {
        if (n1 > n2) {
            n1 -= n2
        }
        else {
            n2 -= n1
        }
    }
    
    return n1
}

fun p01(arr: List<Int>) {
    print("P01: ")
    println(arr[arr.size - 1])
}

fun p02(arr: List<Int>) {
    print("P02: ")
    println(arr[arr.size - 1])
}

fun p03(arr: List<Int>, key: Int) {
    print("P03: ")
    for (i in 0..arr.size - 1) {
        if (arr[i] == key) {
            println(i)
        }
    }
}

fun p04(arr: List<Int>) {
    print("P04: ")
    println(arr.size)
}

fun p05(arr: List<Int>) {
    print("P05: ")
    println(arr.reversed())
}

fun p06(arr: List<Int>) {
    print("P06: ")
    if (arr == arr.reversed()) {
        println(true)
    }
    else {
        println(false)
    }
}

fun p07() {
    print("P07: ")
    val a = listOf(1, 1)
    val b = listOf(2)
    val c = listOf(3)
    val d = listOf(5, 8)
    
    println(listOf(a, b, c, d).flatten())
}

fun p08(str: String) {
    print("P08: ")
 	
    println(str.toSet())
}

fun p09(str: String): MutableList<MutableList<Char>> {
    print("P09: ")
 	
    var grouped = mutableListOf<MutableList<Char>>()
    
  	var temp = mutableListOf(str[0])
    var i = 1
    
    while (i < str.length) {
        if (str[i] == str[i - 1]) {
            temp += str[i]
        }
        else {
            grouped += temp
            temp = mutableListOf(str[i])
        }
        
        if (i == str.length - 1) {
            grouped += temp
        }
        
        i++
    }
    
    println(grouped)
    
    return grouped
}

fun p10(grouped: MutableList<MutableList<Char>>) {
    print("P10: ")
    
    var encoded = mutableListOf<Pair<Int, Char>>()
    
    for (arr in grouped) {
        encoded += Pair(arr.size, arr[0])
    }
    
    println(encoded)
}

fun p11(grouped: MutableList<MutableList<Char>>): MutableList<Any> {
    print("P11: ")
    
    var encoded = mutableListOf<Any>()
    
    for (arr in grouped) {
        if (arr.size == 1) {
            encoded += arr[0]
        }
        else {
            encoded += Pair(arr.size, arr[0])
        }
    }
    
    println(encoded)
    return encoded
}

fun p12(encoded: MutableList<Any>) {
    print("P12: ")
    
    var decoded = mutableListOf<Char>()
    
    for (x in encoded) {
        if (x is Char) {
        	decoded.add(x)
        }
        else {
            val y = x as Pair<Int, Char>
            
        	for (i in 0..y.first) {
                decoded.add(y.second)
            }
        }
    }
    
    println(decoded)
}

fun p13(str: String) {
    print("P13: ")
 	
    var grouped = mutableListOf<MutableList<Char>>()
    
  	var temp = mutableListOf(str[0])
    var i = 1
    
    while (i < str.length) {
        if (str[i] == str[i - 1]) {
            temp += str[i]
        }
        else {
            grouped += temp
            temp = mutableListOf(str[i])
        }
        
        if (i == str.length - 1) {
            grouped += temp
        }
        
        i++
    }
    
    var encoded = mutableListOf<Pair<Int, Char>>()
    
    for (arr in grouped) {
        encoded += Pair(arr.size, arr[0])
    }
    
    println(encoded)
}

fun p14 (str1: String) {
    print("P14: ")
    
    var duplicated = mutableListOf<Char>()
    
    for (x in str1) {
        duplicated.add(x)
        duplicated.add(x)
    }
    
    println(duplicated)
}

fun p15 (str: String, times: Int) {
    print("P15: ")
    
    var duplicated = mutableListOf<Char>()
    
    for (x in str) {
        for (i in 0..times - 1) {
            duplicated.add(x)
        }
    }
    
    println(duplicated)
}

fun p16(str: String, n: Int) {
    print("P16: ")
    
    var edited = mutableListOf<Char>()
    
    for (i in 0..str.length - 1) {
        if ((i + 1) % n == 0) {
            continue
        }
        else {
            edited.add(str[i])
        }
    }
    
    println(edited)
}

fun p17(str: String, n: Int) {
    print("P17: ")
    
    var splitted = mutableListOf<MutableList<Char>>()
	var temp = mutableListOf<Char>()
    
    for (i in 0..str.length - 1) {
        if (n == i + 1) {
            temp.add(str[i])
            splitted.add(temp)
            
            //temp.clear()
            temp = mutableListOf<Char>()
        }
        else {
            temp.add(str[i])
        }
    }
    
    splitted.add(temp)
	
    println(splitted)
}

fun p18(str: String, a: Int, b: Int) {
    print("P18: ")
    
    var part = mutableListOf<Char>()
    
    for (i in 0..str.length - 1) {
        if (a >= i + 1) {
            continue
        }
        else if (a < i + 1 && b >= i + 1) {
            part.add(str[i])
        }
        else {
            break
        }
    }
    
    println(part)
}

fun p19(s: String, n: Int) {
    print("P19: ")
    
    var str = s.toCharArray()
    
    if (n == 0) {}
    else if (n > 0) {
        for (k in 0..n - 1) {
            val temp = str[0]
            
            for (i in 0..str.size - 2) {
                str[i] = str[i + 1] 
            }
            
            str[str.size - 1] = temp
        }
    }
    else {
        for (k in 0..abs(n) - 1) {
            val temp = str[str.size - 1]
            
            for (i in str.size - 1 downTo 1) {
                str[i] = str[i - 1] 
            }
            
            str[0] = temp
        }
    }
    
    println(str.toList())
}

fun p20(str: String, k: Int) {
    print("P20: ")
    
    var without = mutableListOf<Char>()
    var extracted = ' '
    
    for (i in 0..str.length - 1) {
    	if (i == k) {
            extracted = str[i]
        }   
        else {
          	without.add(str[i]) 
        }
    }
    
    println(Pair(without, extracted))
}

fun p21(str: String, k: Int, x: Char) {
    print("P21: ")
    
    var inserted = mutableListOf<Char>()
    
    for (i in 0..str.length - 1) {
        if (i == k) {
            inserted.add(x)
        }
        else {
            inserted.add(str[i])
        }
    }
    
    println(inserted)
}

fun p22(a: Int, b: Int) {
    print("P22: ")
    
    var arr = mutableListOf<Int>()
    
    for (i in a..b) {
        arr.add(i)
    }
    
    println(arr)
}

fun p23(str: String, n: Int) {
    print("P23: ")
    
    var randomChar = mutableListOf<Char>()
    var i = 0
    while (i <= n - 1) {
       val temp = str.toList().random()
        if (temp in randomChar) {
            i -= 1
        }
        else {
            randomChar.add(temp)
            i++
        } 
    }
    
    println(randomChar)
}

fun p24(n: Int, rng: Int) {
    print("P24: ")
    
    var arr = mutableListOf<Int>()
    var i = 0
    
    while (i <= n - 1) {
        val temp = (0..rng).random()
        if (temp in arr) {
            i -= 1
        }
        else {
            arr.add(temp)
            i++
        }
    }
    
    println(arr)
}

fun p25(str: String) {
    print("P25: ")
    
    var randPermutation = mutableListOf<Char>()
    
    while (randPermutation.size != str.length) {
        val temp = str.toList().random()
        
        if (temp in randPermutation) {
            continue
        }
        else {
            randPermutation.add(temp)
        }
    }
    
    println(randPermutation)
}

fun p26(str: String, n: Int, combination: String, combs: MutableList<List<Char>>) {
    if (n == 0) {
        combs.add(combination.toList())
    }
    for (i in 0..str.length - 1) {
        p26(str.slice(i + 1..str.length - 1), n - 1, combination + str[i].toString(), combs)
    }
}
 
fun p28(a: List<Char>, b: List<Char>, c: List<Char>, d: List<Char>, e: List<Char>, f: List<Char>, g: List<Char>) {
    print("P28: ")
    var sorted = mutableListOf(a, b, c, d, e, f, g)
    
    for (k in 0..sorted.size - 2) {
        for (i in 0..sorted.size - k - 2) {
            if (sorted[i].size > sorted[i + 1].size) {
                val temp = sorted[i]
                sorted[i] = sorted[i + 1]
                sorted[i + 1] = temp
            }
    	}
    }
    
    println(sorted)
}
 
fun p31(n: Int) {
    print("P31: ")
    if (n > 1 && (n % 2 != 0 && n % 3 != 0 && n % 5 != 0) || n == 2 || n == 3 || n == 5) {
        println(true)
    }
    else {
        println(false)
    }
}

fun p32(a: Int, b: Int) {
    print("P32: ")
    
    var n1 = a
    var n2 = b
    
    while (n1 != n2) {
        if (n1 > n2) {
            n1 -= n2
        }
        else {
            n2 -= n1
        }
    }
    
    println(n1)
}
 
fun p33(a: Int, b: Int) {
    print("P33: ")
    
    if (gcd(a, b) == 1) {
        println(true)
    }
    else {
        println(false)
    }
}

fun p34(n: Int): Int {
    print("P34: ")
    
    var r = 0
    
    for (x in n - 1 downTo 1) {
        if (gcd(n, x) == 1) {
            r++
        }
    }
    
    println(r)
    return r
}
 
fun p35(x: Int): MutableList<Int> {
    print("P35: ")
    var r = mutableListOf<Int>()	
        
    if (x >= 0) {
        var n: Int = x

        while (n != 1) {
            if (n % 2 == 0) {
                r.add(2)
                n /= 2
            }
            else if (n % 3 == 0) {
                r.add(3)
                n /= 3
            }
            else if (n % 5 == 0) {
                r.add(5)
                n /= 5
            }
            else {
                var prime = 7
                while(prime <= n) {
                    if (n % prime == 0) {
                        r.add(prime)
                        n /= prime
                        break
                    }
                    else {
                        prime++
                    }
                }
            }
        }

    	println(r)
    }
    else {
        println("Integer is negative")
    }
    
    return r
}

fun p36(r: MutableList<*>): MutableList<Pair<Int, *>>{
    print("P36: ")
    
    var grouped = mutableListOf<MutableList<*>>()
    
  	var temp = mutableListOf(r[0])
    var i = 1
    
    while (i < r.size) {
        if (r[i] == r[i - 1]) {
            temp += r[i]
        }
        else {
            grouped += temp
            temp = mutableListOf(r[i])
        }
        
        if (i == r.size - 1) {
            grouped += temp
        }
        
        i++
    }
    
    var encoded = mutableListOf<Pair<Int, *>>()
    
    for (arr in grouped) {
        encoded += Pair(arr.size, arr[0])
    }
    
    println(encoded)
    
    return encoded
}

fun p37(pf: MutableList<Pair<Int, *>>): Int {
    print("P37: ")
    
    var phi = 1

    for (x in pf) {
        val factors = x as Pair<Int, Int>
        
        phi *= (factors.second - 1) * (factors.second.toDouble().pow(factors.first.toDouble() - 1)).toInt()
    }
    
    println(phi)
    return phi
}

fun p38(a: Int, b: Int) {
    print("P38: ")
    
    if (a == b) {
        println(true)
    }
    else {
        println(false)
    }
}

fun p39(a: Int, b: Int) {
    print("P39: ")
    
    var primes = mutableListOf<Int>()
    
    for (x in a..b) {
        if (x > 1 && (x % 2 != 0 && x % 3 != 0 && x % 5 != 0) || x == 2 || x == 3 || x == 5) {
        	primes.add(x)
    	}
    }
    
    println(primes)
}

fun p40(n: Int) {
    print("P40: ")

	if (n % 2 == 0) {
        var large = 0
    
    	for (x in n downTo 2) {
            if ((x > 1 && (x % 2 != 0 && x % 3 != 0 && x % 5 != 0) || x == 2 || x == 3 || x == 5) && n - x != 1) {
                large = x
                break
    		}
        }
  		
        println(Pair(n - large, large))
    }
    else {
        println("n is odd")
    }
}

fun p41(a: Int, b: Int) {
    println("P41: ")

	for (n in a + 1..b) {
        if (n % 2 == 0) {
            var large = 0

            for (x in n downTo 2) {
                if ((x > 1 && (x % 2 != 0 && x % 3 != 0 && x % 5 != 0) || x == 2 || x == 3 || x == 5) && n - x != 1) {
                    large = x
                    break
                }
            }

            println("$n = ${n - large} + $large")
        }
        else {
            continue
        }
    }
}

//P46
fun Boolean.and_(x: List<Boolean>): Boolean {
    var temp = x[0].toInt()
    
    for (y in x) {
         if (temp == 0) {
             temp = (false && y).toInt()
         }
         else {
             temp = (true && y).toInt()
         }
    }
    
    return temp.toBoolean()
}

fun Boolean.or_(x: List<Boolean>): Boolean {
    var temp = x[0].toInt()
    
    for (y in x) {
         if (temp == 0) {
             temp = (false || y).toInt()
         }
         else {
             temp = (true || y).toInt()
         }
    }
    
    return temp.toBoolean()
}

fun Boolean.nand_(x: List<Boolean>): Boolean {
    var temp = x[0].toInt()
    
    for (y in x) {
         if (temp == 0) {
             temp = (false && y).not().toInt()
         }
         else {
             temp = (true && y).not().toInt()
         }
    }
    
    return temp.toBoolean()
}

fun Boolean.nor_(x: List<Boolean>): Boolean {
    var temp = x[0].toInt()
    
    for (y in x) {
         if (temp == 0) {
             temp = (false || y).not().toInt()
         }
         else {
             temp = (true || y).not().toInt()
         }
    }
    
    return temp.toBoolean()
}
fun Boolean.xor_(x: List<Boolean>): Boolean {
    var temp = x[0].toInt()
    
    for (y in x) {
         if (temp == 0) {
             temp = (false xor y).toInt()
         }
         else {
             temp = (true xor y).toInt()
         }
    }
    
    return temp.toBoolean()
}

fun Boolean.impl_(x: List<Boolean>): Boolean {
    var temp = x[0].toInt()
    
    for (y in x) {
         if (temp == 0) {
             temp = (false xor !y).toInt()
         }
         else {
             temp = (true xor !y).toInt()
         }
    }
    
    return temp.toBoolean()
}

fun Boolean.equ_(x: List<Boolean>): Boolean {
   var temp = x[0].toInt()
    
    for (y in x) {
         if (temp == 0) {
             temp = (false xor y).not().toInt()
         }
         else {
             temp = (true xor y).not().toInt()
         }
    }
    
    return temp.toBoolean()
}

fun p46() { //a && (a || !b)
    println("P46: ")
    println("a\tb\tresult")
    
    for (a in listOf(true, false)) {
        for (b in listOf(true, false)) {
            println("$a\t$b\t${a.and_(listOf(a.or_(listOf(!b))))}")
        }
    }
}

fun p49(bits: Int) {
    print("P49: ")
    
    /*var gc = mutableListOf<String>()
   	gc.add("0")
    gc.add("1")
    
    var i = 2
    
    while (i < 1 shl bits) {
     	for (j in i - 1 downTo 0) {
            gc.add(gc[j])
        }
        
        for (j in 0..i - 1) {
            gc.set(j, "0" + gc[j])
        }
        
        for (j in i..2.toDouble().pow(i.toDouble()).toInt() - 1) {
            gc.set(j, "1" + gc[j])
        }
    	
        i = i shl 1
    }
    
    for (x in gc) {
        println(x)
    }*/
}

fun main() {
    //03.04.23
    val myList = listOf(1, 1, 2, 3, 5, 8)
    p01(myList)
    p02(myList)
    p03(myList, 2)
    p04(myList)
    p05(myList)
    p06(myList)
    p07()
    
    val str = "aaaabccaadeeee"
    p08(str)
    
    val grouped = p09(str)
    p10(grouped)
    
    val encoded = p11(grouped)
    
    //04.04.23
    p12(encoded)
    p13(str)
    
    val str1 = "abccd"
    p14(str1)
    p15(str1, 3)
    
    val str2 = "abcdefghijk"
    p16(str2, 3)
    p17(str2, 3)
    p18(str2, 3, 7)
    p19(str2, -2)
    
    //05.04.23
    val str3 = "abcd"
    p20(str3, 1)
    p21(str3, 1, 'X')
    
    p22(4, 9)
    
    val str4 = "abcdefgh"
    p23(str4, 3)
    
    p24(3, 39)
    
    val str5 = "abcdef"
    p25(str5)
    
    val str6 = "abcde"
    var combs = mutableListOf<List<Char>>()
    p26(str6, 3, "", combs)
    println("P26: " + combs)
    
    println("P27: None")
    
    p28("abc".toList(), "de".toList(), "fgh".toList(), "de".toList(), "ijkl".toList(), "mn".toList(), "o".toList())
    
    //ARITHMETICS
    
    p31(7)
    p32(36, 63)
    p33(35, 64)
    val comp1 = p34(315)
    
    //06.04.23
    var p35Data = p35(315)
    var primeFactors = p36(p35Data) //p13 improved | n = 315
    val comp2 = p37(primeFactors) // n = 315
	p38(comp1, comp2)
    p39(7, 31)
    p40(28)
    p41(9, 20)
 
    //LOGIC AND CODES
    //P46
    p46()
    println("P48: ${true.xor_(listOf(true, false, true))}")
    p49(3)
}