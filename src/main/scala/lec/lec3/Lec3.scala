package lec3

import scala.beans.BeanProperty

object ScalaClasses extends App {
  class Point(private val x: Int, val y: Int) {
    println(s"$x, $y")

    def distance(other: Point): Double = {
      import scala.math.sqrt

      val deltaX     = other.x - this.x
      val deltaXQuad = deltaX * deltaX

      val deltaY     = other.y - this.y
      val deltaYQuad = deltaY * deltaY

      sqrt(deltaXQuad + deltaYQuad)
    }

    override def toString: String = s"($x, $y)"
  }

  val p1 = new Point(1, 1)
  println(p1.toString)
  val p2 = new Point(2, 4)
  println(p2.y)
  println(p1.distance(p2))
}

object ScalaClassesWithVar extends App {
  class Point(var x: Int, var y: Int)
  val p1 = new Point(1000, 1000)
  println(p1.x)
  p1.x = 1001
  println(p1.x)
}

object ScalaClassesWithDefaultParam extends App {
  class Point(var x: Int = 0, var y: Int = 0) {
    var color: String             = _
    def scaleTemp(): Unit         = color = "Purple"
    override def toString: String = s"$x, $y"
  }
  val p = new Point(3, 4)
  println(p.color)
  p.scaleTemp()
  println(p.color)
}

object ScalaClassesWithAuxiliaryConstructors extends App {
  class PointWithAuxiliaryConstructor(val x: Int, val y: Int) {
    def this() = this(1, 1)
    def this(xOrY: Int, isX: Boolean) = this(if (isX) xOrY else 0, if (isX) 0 else xOrY)
  }
  val p0 = new PointWithAuxiliaryConstructor
}

object ScalaClassesWithAuxiliaryConstructorsV2 extends App {
  class X(x: Int)
  class Y(y: Int)
  class PointWithAuxiliaryConstructor(val x: X, val y: Y) {
    def this(x: X) = this(x, new Y(0))
    def this(y: Y) = this(new X(0), y)
  }
}

object ScalaClassesExtends extends App {
  class Person(
                @BeanProperty var name: String,
                @BeanProperty val age: Int
              ) {
    def printName(): Unit = println(name)
    def printHello(): Unit = println("Hello!")
  }
  val vlad = new Person("Vlad", 20)
  vlad.printName()
  vlad.setName("Vladislav")
  vlad.printName()
  vlad.printHello()

  class JavaDeveloper(name: String, age: Int, exp: Double) extends Person(name, age) {
    def printInfo(): Unit = {
      println(s"Name: $name, Age: $age, Experience: $exp")
    }
    override def printHello(): Unit = {
      println(s"My 10000-line calculator is very good!")
    }
  }

  class ScalaDeveloper(name: String, age: Int, exp: Double) extends Person(name, age) {
    def printInfo(): Unit = {
      println(s"Name: $name, Age: $age, Experience: $exp")
    }
    override def printHello(): Unit = {
      println("Oh no! I wrote a microservices application in 10 lines of code!")
    }
  }
  val javaVlad = new JavaDeveloper("Vlad", 20, 1.5)

  val scalaVlad = new ScalaDeveloper("Vlad", 20, 1.5)
  javaVlad.printHello()
  scalaVlad.printHello()
}

object ScalaCaseClasses extends App {
  case class Point(x: Int, var y: Int)

  class Point1(x: Int, var y: Int)

  case class p(i: Int, i1: Int) extends Point1(i, i1)

  val p1 = Point(1, 2)

  val x  = Point.unapply(null)
  val x1 = Point.unapply(p1)
  println(x)
  println(x1)
}

object ScalaObjects extends App {
  System.out.println("1")
  LogAny.log(1)
  LogAny1.log(6)
}

object LogAny {
  println("....123")
  val x                          = 1
  private val y                  = 1
  def log(a: Any): Unit          = println(s"INFO $a")
  private def log1(a: Any): Unit = println(s"INFO $a")
}
object LogAny1 {
  println("......")
  def log(a: Any): Unit = println(s"INFO $a")
}

object ScalaCompanionObjects extends App {

  case class Point(x: Int, y: Int) {
    def toWest(): Unit = println("111")
  }

  object Point {
    def createFromX(x: Int): Point = Point(x, 0)
    def createFromY(y: Int): Point = Point(0, y)
    def zeroPoint: Point           = Point(0, 0)

    def distance(p1: Point, p2: Point): Double = {
      import scala.math.sqrt
      val deltaX     = p1.x - p2.x
      val deltaXQuad = deltaX * deltaX

      val deltaY     = p1.y - p2.y
      val deltaYQuad = deltaY * deltaY

      sqrt(deltaXQuad + deltaYQuad)
    }
  }
  val p1 = Point(1, 2)
  val p2 = Point(2, 4)
  Point.distance(p1, p2)
  val p3    = Point.createFromX(1)
  val p4    = Point.createFromY(2)
  val pZero = Point.zeroPoint

}


object MoreCompanionObjects extends App {
  class Point()
  case class Point1() extends Point
  case class Point2() extends Point

  object Point {
    def toP(p:Point): Unit = {
      println(p)
    }
  }
  Point.toP(Point1())
  Point.toP(Point2())
}