package homework.homework3

abstract class Shape {
  def area: Double
}

case class Circle(radius: Double) extends Shape {
  override def area: Double = Math.PI * radius * radius
}

case class Rectangle(length: Double, width: Double) extends Shape {
  override def area: Double = length * width
}

case class Square(side: Double) extends Shape {
  override def area: Double = side * side
}

object TestGeometry {

  def printArea(shape: Shape): Unit = {
    println(s"Площадь фигуры: ${shape.area}")
  }

  def main(args: Array[String]): Unit = {
    val circle = Circle(5)
    val rectangle = Rectangle(4, 7)
    val square = Square(3)

    printArea(circle)
    printArea(rectangle)
    printArea(square)
  }
}