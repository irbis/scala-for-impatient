import scala.collection.mutable.ArrayBuffer

// ex1
class BankAccount(initialBalance: Double) {
  private var balance = initialBalance
  def deposit(amount: Double) = { balance += amount; balance }
  def withdraw(amount: Double) = { balance -= amount; balance }
}

class CheckingAccount(initialBalance: Double) extends BankAccount(initialBalance) {
  override def deposit(amount: Double): Double = super.deposit(amount - 1)
  override def withdraw(amount: Double): Double = super.withdraw(amount + 1)
}

// ex2
class SavingsAccount(initialBalance: Double, monthlyPercents: Double) extends BankAccount(initialBalance) {
  private final val OPERATION_THRESHOLD = 3
  private var transactionsCount = 0

  override def deposit(amount: Double): Double =
    if (transactionsCount < OPERATION_THRESHOLD)
      super.deposit(amount)
    else
      super.deposit(amount - 1)

  override def withdraw(amount: Double): Double =
    if (transactionsCount < OPERATION_THRESHOLD)
      super.withdraw(amount)
    else
      super.withdraw(amount + 1)

  def earnMonthlyInterest = {
    val balance = deposit(0.0d)
    deposit(balance * monthlyPercents / 100)

    transactionsCount = 0
  }
}

// ex4
abstract class Item {
  def price: Double
  def description: String
}

class SimpleItem(val price: Double, val description: String) extends Item

class Bundle(items: ArrayBuffer[Item]) extends Item {
  override def price: Double = items.map(_.price).sum
  override def description: String = s"Bundle with ${items.length} items"

  def addItem(item: Item): Unit = {
    items += item
  }
}

// ex5
class Point(val x: Double, val y: Double)

class LabeledPoint(label: String, x: Double, y: Double) extends Point(x, y)
new LabeledPoint("Black Thursday", 1929d, 230.07d)

// ex6
abstract class Shape {
  def centerPoint: Point
}

class Rectangle(val p: Point, val dx: Int, val dy: Int) extends Shape {
  override def centerPoint = new Point(p.x + dx/2, p.y + dy/2)
}

class Circle(val centerPoint: Point, val radius: Int) extends Shape