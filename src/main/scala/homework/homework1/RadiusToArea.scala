package homework.homework1

object RadiusToArea {

  def calculateArea(r: Double): Double = {
    2 * Math.PI * r
  }

  def main(args: Array[String]): Unit = {
    val r: Double = 16.6

    println(f"$r%.2f - ${calculateArea(r)}%.2f")
  }
}
