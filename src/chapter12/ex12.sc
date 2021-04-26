// ex1
def values(fun: Int => Int, low: Int, high: Int) =
  for (i <- low to high) yield (i, fun(i))

values(x => x * x, -5, 5)

// ex2
Array(1, 2, 3, 10, 5, 7, 4).reduceLeft((a, b) => if (a > b) a else b)

// ex3
def fact1(n: Int) =
  if (n < 1) 1
  else (1 to n) reduceLeft (_ * _)

fact1(5)

// ex4
def fact2(n: Int) =
  (1 to n).foldLeft(1)(_ * _)

fact2(0)

// ex5
def largest1(fun: Int => Int, inputs: Seq[Int]) =
  fun(inputs.maxBy(fun(_)))

largest1(x => 10 * x - x * x, 1 to 10)

// ex6
def largest2(fun: Int => Int, inputs: Seq[Int]) = {
  val maxIn = inputs.maxBy(fun(_))
  (maxIn, fun(maxIn))
}

largest2(x => 10 * x - x * x, 1 to 10)

// ex7
var pairs = (1 to 10) zip (11 to 20)
def adjustToPair(fun: (Int, Int) => Int)(t: (Int, Int)) =
  fun(t._1, t._2)

pairs.map(adjustToPair(_ + _)(_)) // looks very cool!!!

// ex8
val a = Array("Hello", "World")
val b = Array(5, 5)
a.corresponds(b)(_.length == _)

// ex10
def unless(condition: => Boolean)(block: => Unit): Unit = {
  if (!condition) {
    block
  }
}

val t = false
unless(t) {
  println("unless")
}