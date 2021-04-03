// fixed size arrays
val nums = new Array[Int](10)
val a = new Array[String](10)
val s = Array("Hello", "World")
s(0) = "Goodbye"

import scala.collection.mutable.ArrayBuffer
val b = ArrayBuffer[Int]()
b += 1
b += (1, 2, 3, 5)
b ++= Array(8, 13, 21)
b.trimEnd(5)

b.insert(2, 6)
b.insert(2, 7, 8, 9)
b.remove(2)
b.remove(2, 3)

b.toArray

for (i <- 0 until a.length)
  println(i + ": " + a(i))

for (i <- 0 until (a.length, 2))
  println(i + ": " + a(i))

for (i <- (0 until a.length).reverse)
  println(i + ": " + a(i))

// array transformation: for-comprehension
val a = Array(2, 3, 5, 7, 11)
val result = for (elem <- a) yield 2 * elem
//val guardResult = for (elem <- a if a % 2 == 0) yield 2 * elem

// sum and sort
Array(1, 7, 2, 9).sum
ArrayBuffer("Mary", "had", "a", "little", "lamb").max

val b = ArrayBuffer(1, 7, 2, 9)
val bSorted = b.sortWith(_ < _)

val a = Array(1, 7, 2, 9)
scala.util.Sorting.quickSort(a)
a.mkString
a.mkString(" and ")
b.toString

// multidimensional array
val matrix = Array.ofDim[Double](3, 4)
matrix(1)(1)

// Scala and Java arrays
import collection.JavaConverters._
import collection.mutable.ArrayBuffer
val command = ArrayBuffer("ls", "-al", "/home/irbis")
val pb = new ProcessBuilder(command.asJava)

import collection.JavaConverters._
import collection.mutable.Buffer
val cmd : Buffer[String] = pb.command().asScala

println("End of chapter")