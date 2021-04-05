import java.util.Date
import scala.beans.BeanProperty

class Counter {
  private var value = 0
  def increment() { value += 1; privateCounter += 1 }
  def current() = value
  def current1 = value // force user not to use () while calling method

  private[this] var privateCounter = 0 // very private field: accessible only from this object

  def isLess(other: Counter) = value < other.value
}

val myCounter = new Counter
myCounter.increment()
println(myCounter.current())
println(myCounter.current1)

class Person {
  var age = 0
  @BeanProperty var name: String = _ // Java Beans: setName() and getName() or getName() for val

  /*
    scala generates Java code which contains:
    private int age; <- private field
    public int age() { return age; }; <- getter
    public void age_$eq(int age) { this.age = age; } <- setter
   */
}

class PersonOverride {
  private var privateAge = 0

  def age = privateAge
  def age_=(newValue: Int): Unit = {
    if (newValue > privateAge) privateAge = newValue // unable to set younger
  }
}

// readonly class properties
class Message {
  val timeStamp = new Date
}

// auxiliary constructors
class PersonWithAuxiliaryConstructors { // main constructor exists but does not have an arguments
  private var name = ""
  private var age = 0

  def this(name: String) {
    this() // main constructor call
    this.name = name
  }

  def this(name: String, age: Int) {
    this(name)
    this.age = age
  }
}

new PersonWithAuxiliaryConstructors
new PersonWithAuxiliaryConstructors("Fred")
new PersonWithAuxiliaryConstructors("Fred", 42)

// main constructor
class PersonWithMainConstructor(val name: String = "", val age: Int = 0) {
  // name and age are automatically class properties
  println("Just constructed another person")
  def description = name + " is " + age + " years old"
}
new PersonWithMainConstructor("Fred", 42)

// nested classes
import scala.collection.mutable.ArrayBuffer
class Network {
  class Member(val name: String) {
    val contacts = new ArrayBuffer[Network#Member]
  }

  private val members = new ArrayBuffer[Member]

  def join(name: String) = {
    val m = new Member(name)
    members += m
    m
  }
}

val chatter = new Network
val myFace = new Network
// chatter.Member & myFace.Member are different classes

val fred = chatter.join("Fred")
val wilma = chatter.join("Wilma")
fred.contacts += wilma
val barney = myFace.join("Barney")
fred.contacts += barney // type mismatch, to fix object companion or type projection