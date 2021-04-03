import java.text.MessageFormat
import scala.math.sqrt

val x = 1
val s = if (x > 0) 1 else -1 // type Int
val s1 = if (x > 0) "positive" else -1 // type Any
val s2 = if (x > 0) () else -1 // () - Unit (AnyVal)

// code blocks
var n = 1
var r = 2

if (n > 0) {
  r = r * n
  n -= 1
}

print("Answer: ")
println(42)
printf("Hello, %s! You are %d years old.\n", "Fred", 42)

// The following commented lines brakes Idea
//import scala.io.StdIn.{readLine, readInt}
//val name = readLine("You name:")
//print("Your age: ")
//val age = readInt()
//printf("Hello, %s! Next year, you will be %d.\n", name, age + 1)

// loops: while and do are the same as in Java
while ( n > 0 ) {
  r = r * n
  n -= 1
}

// for:
// last element included
for (i <- 1 to n)
  r = r * i

// last element not included
val s = "Hello"
var sum = 0
for (i <- 0 until s.length)
  sum += s(i)

// no index at all as string is an array
for (ch <- "Hello") sum += ch

for (i <- 1 to 3; j <- 1 to 3) print((10 * i + j) + " ")

for (i <- 1 to 3; j <- 1 to 3) if (j < 3) print(i + " ") else println(i + " ")
// below equals to previous
for (i <- 1 to 3) {
  for (j <- 1 to 3)
    print(i + " ")
  println(" ")
}

// guard
for (i <- 1 to 3; j <- 1 to 3 if i != j) print((10 * i + j) + " ")

// for-comprehension: yield add element to collection
for (i <- 1 to 10) yield i % 3

// functions: outside of object, in Java it is a static method
def abs(x: Double) = if (x >= 0) x else -x

def fac(n: Int) = {
  var r = 1
  for (i <- 1 to n) r = r * i
  r
}

def fac(n: Int): Int = if (n <= 0) 1 else n * fac(n - 1)

def decorate(str: String, left: String = "[", right: String = "]") =
  left + str + right

decorate("Hello")
decorate("Hello", "<<<", ">>>")
decorate("Hello", ">>>[")
decorate(left = "<<<", str = "Hello", right = ">>>")
decorate("Hello", right = "]<<<")

def sum(args: Int*) = {
  var result = 0
  for (arg <- args) result += arg
  result
}

val sum = (1, 4, 9, 16, 25)
//val sum = sum(1 to 5: _*) - error

def recursiveSum(args: Int*) : Int = {
  if (args.length == 0) 0
  else args.head + recursiveSum(args.tail : _*)
}

recursiveSum(1, 4, 9, 16, 25)
recursiveSum(1 to 5: _*)

// for Java functions type convertion is manual:
val str = MessageFormat.format("The answer to {0} is {1}",
  "everything", 42.asInstanceOf[AnyRef])

// procedures:
def box(s: String) {
  val border = "-" * s.length + "--\n"
  println(border + "|" + s + "|\n" + border)
}

box("Hello")

// lazy initialization
lazy val words = "12345"

// exceptions: all exceptions are unchecked and has type Nothing
def mySqrt(x: Double) =
if (x >= 0) { sqrt(x)
} else throw new IllegalArgumentException("x should not be negative")

try {
  mySqrt(2)
} catch {
  case ex: IllegalArgumentException => println("Error: " + ex.getMessage)
} finally ()

try {
  mySqrt(-2)
} catch {
  case ex: IllegalArgumentException => println("Error: " + ex.getMessage)
}