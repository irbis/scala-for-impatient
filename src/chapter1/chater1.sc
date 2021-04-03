// simple expressions
8 * 5 + 2
0.5 * res0
"Hello, " + res0
res2.toUpperCase()

// defining variables
val answer = 8 * 5 + 2

var counter = 0
counter = 1

var greeting: String = null
var greeting: Any = "Hello"

// list of types
val b: Byte = 127
val c: Char = 'c'
val s: Short = 32767
val i: Int = 123456
val l: Long = 1234567890123456L
val f: Float = 12.3f
val d: Double = 2345.5d

// type is an object
127.toString()
1.to(10)

// String & StringOps
"Hello".intersect("World")
// and RichInt, RichDouble, RichChar...
// BinInt extends java.math.BigInteger
// BigDecimal extends java.math.BigDecimal

// method instead of (Type):
"99.44".toDouble

// Operator overload:
var a = 8
var b = 5
a + b
a.+(b)

// increment and decrement - no -- and ++
a += 1
b -= 1
a.toString
b.toString
val x: BigInt = 1234567890
x * x * x // in Java: x.multiply(x).multiply(x)

import scala.math._
sqrt(2)
pow(2, 4)
min(3, Pi)

// no interfaces, camping object instead
BigInt.probablePrime(100, scala.util.Random)
"Hello".distinct

// method apply
"Hello"(4) // equals to
"Hello".apply(4)
// object campaing method apply() is typical method to build new objects
BigInt("1234567890") * BigInt("112358111321")
// (parameters) looks like call apply(parameters)

"Harry".patch(1, "ung", 2)