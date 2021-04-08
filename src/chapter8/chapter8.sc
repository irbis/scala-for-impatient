class Person(id: Int, val name: String) {
  override def toString: String = s"Person: $name, with id: $id"
}

final class Employee(id: Int, name: String, salary: Double)
  extends Person(id, name) {
  override def toString: String = super.toString + s", salary: $salary"
}

val p: Employee = new Employee(11, "John Gold", 100.01d)
if (p.isInstanceOf[Employee]) {
  val s = p.asInstanceOf[Employee]
}

p match {
  case p: Employee => println("Employee")
  case _ => println("Not an Employee")
}

// can extends Java classes and use one of the superclass constructors
class Square(x: Int, y: Int, width: Int) extends
  java.awt.Rectangle(x, y, width, width)

class SecretAgent(id:Int, codename: String) extends Person(id, codename) {
  override val name = "secret"
  override val toString = "secret"
}

val sa: SecretAgent = new SecretAgent(1234, "007")
sa.name

val alien = new Person(-123,"Fred") {
  def greeting = "Greetings, Earthling! My name is Fred."
}

def meet(p: Person{def greeting: String}): Unit = {
  println(p.name + " says: " + p.greeting)
}

meet(alien)

abstract class AbstractPerson(val name: String) {
  def id: Int
}

class EmployeeFromAbstract(name: String) extends AbstractPerson(name) {
  def id = name.hashCode
}

class Creature {
  val range: Int = 10
  val env: Array[Int] = new Array[Int](range)
}

class Ant extends Creature {
  override val range = 2
}

val ant: Ant = new Ant
ant.env.length

class Bug extends {
  override val range = 3
} with Creature
val bug: Bug = new Bug
bug.env.length
