package homework.homework1

object Distance {

  def getDistance(cord1: Double, cord2: Double): Double = {
    Math.abs(cord1 - cord2)
  }

  def main(args: Array[String]): Unit = {
    val cord1: Double = 100.0
    val cord2: Double = 60.6
    println(f"${getDistance(cord1, cord2)}%.2f")
  }
}
