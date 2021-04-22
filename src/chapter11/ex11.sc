import scala.math.abs
// ex1
// 3 + 4 -> 5 = (3 + 4) -> 5
// 3 -> 4 + 5 = (3 -> 4) + 5
// + and -> have the same priority

// ex2
// because ** has minimal priority to compare with * + - /

// ex3
class Fraction(n: Int, d: Int) {

  private val num: Int = if (d == 0) 1 else n * sign(d) / gcd(n, d)
  private val den: Int = if (d == 0) 0 else d * sign(d) / gcd(n, d)

  override def toString = num + "/" + den
  def sign(a: Int) = if (a > 0) 1 else if (a < 0) -1 else 0
  def gcd(a: Int, b: Int): Int = if (b == 0) abs(a) else gcd(b, a % b)

  def +(other: Fraction) = new Fraction(num * other.den + den * other.num, den * other.den)
  def -(other: Fraction) = new Fraction(num * other.den - den * other.num, den * other.den)
  def *(other: Fraction) = new Fraction(num * other.num, den * other.den)
  def /(other: Fraction) = new Fraction(num * other.den, den * other.num)
}

object Fraction {
  def apply(n: Int, d: Int) = new Fraction(n, d)
}

Fraction(15, -6)

// ex4
class Money(val dollars: Int, val cents: Int) {
  override def toString = "$" + dollars + "." + cents

  def +(other: Money) =
    if (cents + other.cents > 100)
      new Money(dollars + other.dollars + 1, cents + other.cents - 100)
    else
      new Money(dollars + other.dollars, cents + other.cents)

  def -(other: Money) =
    if (cents - other.cents < 0)
      new Money(dollars - other.dollars - 1, 100 + cents - other.cents)
    else
      new Money(dollars - other.dollars, cents - other.cents)

  def ==(other: Money) =
    dollars == other.dollars && cents == other.cents

  def <(other: Money) =
    dollars * 100 + cents < other.dollars * 100 + other.cents
}

object Money {
  def apply(d: Int, c: Int) = new Money(d, c)
}

Money(1, 20) + Money(1, 50)
Money(1, 20) + Money(1, 90)

Money(1, 20) - Money(0, 20)
Money(1, 20) - Money(0, 30)

Money(1, 75) + Money(0, 50) == Money(2, 25)

Money(1, 25) < Money(1, 35)

// ex5
class Table(val html: String) {
  def |(value: String) = Table(html + "<td>" + value + "</td>")
  def ||(value: String) = Table(html + "</tr><tr><td>" + value + "</td><tr>")

  override def toString = html + "</tr></table>"
}

object Table {
  def apply(html: String = "<table><tr>") = new Table(html)
}

Table() | "Java" | "Scala" || "Gosling" | "Odersky" || "JVM" | "JVM, .NET"

class AsciiArt(val lines:Seq[String]) {

  // TODO will be an exception in case of different length of lines and other.lines
  def <(other: AsciiArt) = new AsciiArt(
      for (i <- lines.indices)
        yield lines(i) + other.lines(i)
  )

  def ^(other: AsciiArt) = new AsciiArt(lines ++ other.lines)
  override def toString = lines.mkString("\n")
}

val cat = new AsciiArt(
  Seq(" /\\_/\\ ",
      "( ' ' )",
      "(  -  )",
      " | | | ",
      "(__|__)"))

val helloScalaCoder = new AsciiArt(
  Seq("   -----",
      " / Hello \\",
      "<  Scala |",
      " \\ Coder /",
      "   -----"))

cat < helloScalaCoder
cat ^ helloScalaCoder

// ex7
class BitSequence(var value: Long) {
  def apply(bitNumber: Byte) = (value & (1 << bitNumber)) == 1
  def update(bitNumber: Byte, bit: Boolean) =
    if (bit) value |= (1 << bitNumber).toLong
    else value &= (~(1 << bitNumber).toLong)

  override def toString: String = value.toString
}

var seq1 = new BitSequence(5)
seq1(0)
seq1(1) = true
seq1
seq1(0) = false
seq1

// ex8
class Matrix(n: Int = 2, m: Int = 2) {
  var matrix = Array.ofDim[Double](n, m)

  def update(n: Int, m: Int, v: Double): Unit = {
    if (n > matrix.size || m > matrix(0).size) throw new IndexOutOfBoundsException(f"$n, $m")
    matrix(n)(m) = v
  }

  def apply(n: Int, m: Int) =
    if (n > matrix.size || m > matrix(0).size) throw new IndexOutOfBoundsException(f"$n, $m")
    else matrix (n)(m)

  def +(other: Matrix): Unit = {
    if (matrix.size != other.matrix.size || matrix(0).size != other.matrix(0).size)
      throw new IllegalArgumentException("Matrix has to have the same size")

    for (i <- matrix.indices)
      for (j <- matrix(0).indices)
        matrix(i)(j) = matrix(i)(j) + other.matrix(i)(j)
  }

  override def toString: String =
    (for (i <- matrix) yield i.mkString(" ")).mkString("\n")
}

val mat22 = new Matrix()
mat22(0, 0) = 0.0d
mat22(0, 1) = 1.0d
mat22(1, 0) = 2.0d
mat22(1, 1) = 3.0d
mat22
mat22(1, 1)

// ex9
object RichFile {
  // /home/user/file.txt
  def unapply(input: String) = {
    val fileStartIndex = input.lastIndexOf('/')
    val fileExtensionIndex = input.lastIndexOf('.')
    Some ((
      if (fileStartIndex > 0) input.substring(0, fileStartIndex) else "",
      if (fileExtensionIndex > 0) input.substring(fileStartIndex + 1, fileExtensionIndex) else "",
      if (fileExtensionIndex > 0) input.substring(fileExtensionIndex + 1) else ""
    ))
  }

  def unapplySeq(input: String) =
    if (input.indexOf("/") > 0)
      Some(input.split("/"))
    else
      None
}

val RichFile(path, name, ext) = "/home/user/file.txt"
path
name
ext
