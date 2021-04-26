import scala.math._

val num = 3.14
val fun = ceil _
fun(num)

Array(3.14, 1.42, 2.0).map(fun)

val triple = (x: Double) => 3 * x

Array(3.14, 1.42, 2.0).map((x: Double) => 3 * x)
// other variants of syntax
Array(3.14, 1.42, 2.0).map { (x: Double) => 3 * x }
Array(3.14, 1.42, 2.0) map { (x: Double) => 3 * x} // the best one

def valueAtOneQuarter(f: (Double) => Double) = f(0.25)

valueAtOneQuarter(ceil _)
valueAtOneQuarter(sqrt _)

// ********** closure mulBy
def mulBy(factor: Double) = (x: Double) => factor * x
val quintuple = mulBy(5)
quintuple(20)
val triple = mulBy(3)
val half = mulBy(0.5)
println(triple(14) + " " + half(14))

valueAtOneQuarter(x => 3 * x)
valueAtOneQuarter(3 * _)

(1 to 9) map (0.1 * _)

(1 to 9).map("*" * _).foreach(println _)
(1 to 9) filter (_ % 2 == 0)
(1 to 9) reduceLeft (_ * _)
"Mary had a little lamb" split " " sortWith (_.length < _.length)

// ********** curring
def mulOneAtATime(x: Int) = (y: Int) => x * y
mulOneAtATime(6)(7)
// other way of definition
def mulOneAtATime(x: Int)(y: Int) = x * y

val a = Array("Hello", "World")
val b = Array("hello", "world")
a.corresponds(b)(_.equalsIgnoreCase(_))

// ********** abstraction of control structures
def runInThread(block: () => Unit): Unit = {
  new Thread {
    override def run() { block() }
  }.start()
}

runInThread { () => println("Hi"); Thread.sleep(1000); println("Bye") }

// remove () to make code more readable --- call by name
def runInThreadBetter(block: => Unit): Unit = {
  new Thread {
    override def run() { block }
  }.start()
}

runInThreadBetter { println("Hi"); Thread.sleep(1000); println("Bye") }

Thread.sleep(3000)

//  new operator: until
def until(condition: => Boolean)(block: => Unit): Unit = {
  if (!condition) {
    block
    until(condition)(block)
  }
}

var x = 10
until (x == 0) {
  x -= 1
  println(x)
}