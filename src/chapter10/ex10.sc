// ex1
trait RectangleLike extends {
  def getX(): Double
  def getY(): Double
  def getWidth(): Double
  def getHeight(): Double
  def setFrame(x: Double, y: Double, w: Double, h: Double)

  def translate(dx: Int, dy: Int) : Unit = {
    val rec = new java.awt.Rectangle(
      getX().intValue(),
      getY().intValue(),
      getWidth().intValue(),
      getHeight().intValue())
    rec.translate(dx, dy);
    setFrame(rec.getX, rec.getY, rec.getWidth, rec.getHeight)
  }

  def grow(w: Int, h: Int) : Unit = {
    val rec = new java.awt.Rectangle(
      getX().intValue(),
      getY().intValue(),
      getWidth().intValue(),
      getHeight().intValue())
    rec.grow(h, w);
    setFrame(rec.getX, rec.getY, rec.getWidth, rec.getHeight)
  }
}

val egg = new java.awt.geom.Ellipse2D.Double(5, 10, 20, 30) with RectangleLike
egg.getX
egg.translate(10, -10)
egg.getX
egg.grow(10, 20)
egg.getX