package homework.homework2

object MultiplicationTable {

  def getTable(): Unit = {
    val list = List.range(1, 11)
    val l1: List[String] = for (i <- list) yield s"$i - ${i*5}"
    l1.foreach(println)
  }

  def main(args: Array[String]): Unit = {
    getTable()
  }
}
