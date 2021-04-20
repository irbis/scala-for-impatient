import java.util.Date
import javax.swing.JFrame

trait Logger {
  def log(msg: String) // abstract method
}

class ConsoleLogger extends Logger {
  def log(msg: String): Unit = { println(msg) } // override can be ommited
}

class ConsoleLogger1 extends Logger with Cloneable with Serializable {
  def log(msg: String): Unit = { println(msg) } // override can be ommited
}

trait ConsolerLoggerTrait {
  def log(msg: String) { println (msg) }
}

trait Logged {
  def log(msg: String) { }
}

class SavingsAccount extends Logged {
  private var balance: Double = 0.0d

  def withdraw(amount: Double): Unit = {
    if (amount > balance) log("Insufficient funds")
  }
}

trait ConsoleLogger2 extends Logged {
  override def log(msg: String): Unit = { println(msg) }
}

val acct = new SavingsAccount with ConsoleLogger2

trait TimestampLogger extends Logged {
  override def log(msg: String): Unit = {
    super.log(new Date() + " " + msg)
  }
}

trait ShortLogger extends Logged {
  val maxLength = 15

  override def log(msg: String): Unit = {
    super[Logged].log( // [Logger] in case to specify method of what trait will be used
      if (msg.length <= maxLength) msg
      else msg.substring(0, maxLength - 3) + "..."
    )
  }
}

trait TimestampLogger extends Logger {
  abstract override def log(msg: String): Unit = {
    super.log(new java.util.Date() + " " + msg)
  }
}

trait RichLogger {
  def log(msg: String)
  def info(msg: String) { log("INFO: " + msg) }
  def warn(msg: String) { log("WARN: " + msg) }
  def severe(msg: String) { log("SEVERE: " + msg) }
}

trait ShortLogger2 extends Logged {
  val maxLength: Int // trait abstract field
  override def log(msg: String): Unit = {
    super.log(
      if (msg.length <= maxLength) msg
      else msg.substring(0, maxLength - 3) + "..."
    )
  }
}

trait LoggedException extends Exception with Logged {
  def log() { log(getMessage()) }
}

class UnhappyException extends LoggedException {
  override def getMessage(): String = "arggh!"
}

trait LogException extends Logged {
  this: Exception =>
    def log() { log(getMessage()) }
}

trait Log1Exception extends Logged {
  this: { def getMessage(): String} =>
    def log() { log(getMessage()) }
}