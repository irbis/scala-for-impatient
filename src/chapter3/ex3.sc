
// ex1
val a1 = for (i <- 0 until 10) yield i

// ex2
import java.util.Calendar
import scala.collection.mutable.ArrayBuffer
val a2 = ArrayBuffer(1, 2, 3, 4, 5)

var i = 0
val l = if (a2.length % 2 == 0) a2.length else a2.length - 1
while (i < l) {
  val buf = a2(i)
  a2(i) = a2(i+1)
  a2(i+1) = buf
  i += 2
}

a2

// ex3
val a3 = ArrayBuffer(1, 2, 3, 4, 5, 6)

val indexes = for (i <- 0 until a3.length) yield
  if (i % 2 == 0)
    if (i + 1 >= a3.length) i else i + 1
  else i - 1

for (i <- indexes) yield a3(i)

// ex4
val a4 = Array(1, 2, 4, -1, -4, 2, 0, -5)

val positiveIndexes = ArrayBuffer[Int]()
val negativeIndexes = ArrayBuffer[Int]()
for (i <- 0 until a4.length)
  if (a4(i) > 0) positiveIndexes += i
  else negativeIndexes += i

for (i <- positiveIndexes ++= negativeIndexes) yield a4(i) // =(1, 2, 4, 2, -1, -4, 0, -5)

// ex5
val a5 = Array(1.0d, 2.0d, 3.0d, -6.0d)
var sum = 0.0d
for (a <- a5) sum += a
sum / a5.length

// ex6
val a6 = ArrayBuffer(1, 6, 8, 20, 5)
a6.sortWith(_ > _)

// ex9
import collection.JavaConverters._
java.util.TimeZone.getAvailableIDs()
  .filter(_.startsWith("America"))
  .map(_.drop("America/".length))
  .sortWith(_ < _)


