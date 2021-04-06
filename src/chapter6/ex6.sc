// ex1
object Convertions {
  def inchesToCentimeters(inches: Double) = inches * 2.54d
  def gallonsToLiters(gallons: Double) = gallons * 3.79d
  def milesToKilometers(miles: Double) = (miles * 8) / 5
}

// ex2
abstract class UnitConversion {
  def convert(value: Double): Double
}

object InchesToCentimeters extends UnitConversion {
  override def convert(value: Double): Double = value * 2.54d
}

object GallonsToLiters extends UnitConversion {
  override def convert(value: Double): Double = value * 3.79d
}

object MilesToKilometers extends UnitConversion {
  override def convert(value: Double): Double = (value * 8) / 5
}

// ex3
object Origin extends java.awt.Point {

}

// ex4
class Point private (x: Int, y: Int) {

}

object Point {
  def apply(x: Int, y: Int) = new Point(x, y)
}

Point(3, 4)

// ex7
object PlayingCard extends Enumeration {
  type PlayingCard = Value

  val Heart = Value("\u2665")
  val Diamond = Value("\u2666")
  val Club = Value("\u2663")
  val Spade = Value("\u2660")
}

PlayingCard.Heart.toString
PlayingCard.Diamond.toString
PlayingCard.Club.toString
PlayingCard.Spade.toString

// ex8
import PlayingCard._
def isRedCard(card: PlayingCard) = card == Heart || card == Diamond