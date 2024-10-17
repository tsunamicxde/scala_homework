package homework

object CelsiusToFahrenheit {

  def calculateFahrenheit(x: Double): Double = {
    (x * 9/5) + 32
  }

  def main(args: Array[String]): Unit = {
    val x: Double = 16.0
    println(f"$x%.2f - ${calculateFahrenheit(x)}%.2f")

  }
}
