package homework.homework2

object For {

  def checkoutTo(): Unit = {
    for (i <- 1 to 10) println(i)
  }

  def checkoutUntil(): Unit = {
    for (i <- 1 until 10) println(i)
  }

  def main(args: Array[String]): Unit = {
    checkoutTo()
    checkoutUntil()
  }
}
