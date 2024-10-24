package homework.homework2

object EvenOrOdd {

  def checkout(x: Int): String = {
    var result = "Нечётное"
    if (x % 2 == 0) {
      result = "Чётное"
    }
    result
  }

  def main(args: Array[String]): Unit = {
    val x: Int = 20
    val y: Int = 11
    val z: Int = 16

    println(s"$x - ${checkout(x)}")
    println(s"$y - ${checkout(y)}")
    println(s"$z - ${checkout(z)}")
  }
}
