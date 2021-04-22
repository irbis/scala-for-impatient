class Fraction (val n: Int, val d: Int) {
  def *(other: Fraction) = new Fraction(n * other.n, d * other.d)
}

object Fraction {
  def apply(n: Int, d: Int) = new Fraction(n, d)

  def unapply(input: Fraction) =
    if (input.d == 0) None else Some((input.n, input.d))
}

val result = Fraction(3, 4) * Fraction(2, 5)

object Name {
  def unapply(input: String) = {
    val pos = input.indexOf(" ")

    if (pos == -1) None
    else Some((input.substring(0, pos), input.substring(pos + 1)))
  }
}

val author = "Cray Horstman"
val Name(first, last) = author

// in case of one argument
object Number {
  def unapply(input: String): Option[Int] =
    try {
      Some(Integer.parseInt(input.trim))
    } catch {
      case ex: NumberFormatException => None
    }
}

val Number(n) = "1729"

// extractor also can check input value and returns boolean in this case
object IsCompound {
  def unapply(input: String) = input.contains(" ")
}

val author = "Peter van der Linden"

author match {
  case Name(first, last @ IsCompound()) => println("compound")
  case Name(first, last) => println("not compound")
}