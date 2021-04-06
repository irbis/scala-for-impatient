object Account {
  private var lastNumber = 0
  def newUniqueNumber() = { lastNumber += 1; lastNumber }
  def apply(initialBalance: Double) =
    new Account(newUniqueNumber(), initialBalance)
}

class Account private (val id: Int, initialBalance: Double) {
  private var balance = initialBalance
  def deposit(amount: Double) { balance += amount }
}

abstract class UndoableAction(val description: String) {
  def undo(): Unit
  def redo(): Unit
}

object DoNothingAction extends UndoableAction("Do nothing") {
  override def undo(): Unit = {}
  override def redo(): Unit = {}
}

val actions = Map("open" -> DoNothingAction, "save" -> DoNothingAction)

// WARNING
// Array(100) - array of one element with value 100
// new Array(100) - array of 100 elements with value None

// Object which is application
object Hello extends App {
  if (args.length > 0)
    println("Hello, " + args(0))
  else
    println("Hello, World!")
}

// Enumerations
object TrafficLightColor extends Enumeration {
  type TrafficLightColor = Value // by default type of element is TrafficLigthColor.Value
  val Red, Yellow, Green = Value
}

import TrafficLightColor._
def doWhat(color: TrafficLightColor) = {
  if (color == Red) "stop"
  else if (color == Yellow) "hurry up"
  else "go"
}

for (c <- TrafficLightColor.values) println(c.id + ": " + c)
TrafficLightColor(0)
TrafficLightColor.withName("Red")