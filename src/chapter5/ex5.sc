import scala.beans.BeanProperty

// ex1
class Counter(private var value: Int = 0) {
  def increment(): Unit = {
    if (value != Int.MaxValue) value += 1
  }

  def current = value
}

// ex2
class BankAccount {
  private var deposit: Double = 0.0d
  private var withdraw: Double = 0.0d

  def deposit(value: Double): Unit = {
    deposit += value
  }

  def withdraw(value: Double): Unit = {
    withdraw += value
  }

  def balance = deposit - withdraw
}

// ex3 & ex4
class Time(val hours: Byte, val minutes: Byte) {
  def before(other: Time) =
    this.hours * 60 + this.minutes < other.hours * 60 + other.minutes
}
new Time(12, 3).before(new Time(12, 4)) // true is excepted

// ex5
class Student(@BeanProperty var name: String, @BeanProperty var id: Long)
val student = new Student("Fred", 123456L)

// ex6
class Person(val name: String = "", var age: Int = 0) {
  if (age < 0) age = 0

  override def toString: String = s"$name and $age"
}
new Person("Fred", 42).toString
new Person("Liza", -10).toString

// ex7
class Person1(name: String) {
  private val firstLastName = name.split(" ")
  val firstName = firstLastName(0)
  val lastName = firstLastName(1)
}
new Person1("Fred Smith").firstName

// ex8
class Car(val manufacturer: String,
          val model: String,
          val productionYear: Int = -1,
          var registrationNumber: String = "") {
  def this(manufacturer: String, model: String, rn: String) {
    this(manufacturer, model, registrationNumber = rn)
  }
}

// ex10
class Employee(val name: String = "John Q. Public", var salary: Double = 0.0d)