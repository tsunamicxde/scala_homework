package homework.homework2

object PositiveOrNegative {

  def checkout(x: Int): String = {
    var result = "-"
    if (x > 0) {
      result = "+"
    } else if (x == 0) {
      result = "0"
    } else {}
    result
  }

  def main(args: Array[String]): Unit = {
    val x: Int = -20
    val y: Int = 0
    val z: Int = 16

    println(s"$x (${checkout(x)})")
    println(s"$y - (${checkout(y)})")
    println(s"$z - (${checkout(z)})")
  }
}
