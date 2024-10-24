package homework.homework1

object Square {

  def square(x: Int): Int = {
    x * x
  }

  def main(args: Array[String]): Unit = {
    val numbers = List(2, 4, 6)

    numbers.foreach(num => println(s"$num - ${square(num)}"))
  }
}
