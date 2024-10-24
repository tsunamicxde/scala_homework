package homework.homework1

object GetStringLength {

  def getStringLength(str: String): Int = {
    str.length
  }

  def main(args: Array[String]): Unit = {
    val str: String = "Vladislav"
    println(s"$str - ${getStringLength(str)}")
  }
}
