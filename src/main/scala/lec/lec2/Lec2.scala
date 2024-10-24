package lec2

import scala.util.{Failure, Success, Try}

object IfElse extends App {
  val x = 1
  val y = 2
  val z = 3

  def f(str: String = "F"): String = {
    println(str)
    str
  }

  def yes(str: String = "yes"): String = {
    println(str)
    str
  }

  if (z - x == y) {
    yes()
  } else {
    f()
  }

  val res: Any = if (x != y) f()

  var res1 = if (true) x else z

}

object LazyIf extends App {
  lazy val lazyE = {
    println("ThreadSleep")
    Thread.sleep(1000)
    1
  }
  val sleepless = {
    println("sleepless")
    2
  }
  println("1 if eval")
  if (1 == 1) sleepless else lazyE
  println("2 if eval")
  if (1 != 1) sleepless else lazyE
  println("3 if eval")
  if (3 == 3) lazyE else sleepless
}

object For extends App {

  for (i <- 1 to 5) println(i)
  for (i <- 1 until 5) println(i)

  val l = List(1, 2, 3, 4, 5)
  for (i <- l) println(i)

  val l1 = l.map(_ * 2)

  for {
    i <- l
    j <- l1
  } println(s"$i * 2 = $j")

  for (i <- l) {
    val res = i * i
    println(res)
  }

  val l1V2: List[Int] = for (i <- l) yield i*2
  l1V2.foreach(println)

  val l1V3: List[String] = for (i <- l) yield s"$i"
  l1V3.foreach(println)

  val userBase  = List(("Arthur", 36), ("John", 26), ("Dutch", 44), ("Charles", 24))

  val filteredF = userBase.filter(_._2 >= 20).filter(_._2 < 30)
  filteredF.foreach(println)

  def f(n: Int, sum: Int): Seq[(Int, Int)] =
    for {
      i <- 0 until n
      j <- 0 until n if (i + j == sum && i <= j)
    } yield (i, j)
  println(f(100, 100))

}

object While extends App {
  var i = 1d
  while (i > 0.002) {
    println(i)
    i = i / 2
  }

  do {
    println(i)
    i += 1
  } while (i < 0)
}

object TailRec extends App {
  def factorial(n: BigInt): BigInt = {
    import scala.annotation.tailrec
    @tailrec
    def factorialTail(acc: BigInt, n: BigInt): BigInt = {
      if (n == 0) acc
      else factorialTail(n * acc, n - 1)
    }
    factorialTail(1, n)
  }
  println(factorial(BigInt(10000)))
}

object TryMe extends App {
  try {
    val res = 1 / 0
    println(res)
  } catch {
    case a: ArithmeticException =>
      println("ArithmeticException!")
      println(a.getMessage)
      a.printStackTrace()
    case t: Throwable =>
      println("Throwable!")
      t.printStackTrace()
    case e: Exception =>
      println(e.getMessage)
      e.printStackTrace()
  } finally {
    println("finally block")
  }
}

object BreakMe extends App {

  import scala.util.control.Breaks.break
  import scala.util.control.Breaks.breakable

  val search = "Vibrant voices vividly verify valuable visions".toLowerCase()

  val words = search.split(" ")
  words.foreach(println)

  val start1 = System.nanoTime()
  var numVs = 0
  for (i <- 0 until search.length) {
    breakable {
      if (search.charAt(i) != 'v') {
        break
      } else {
        numVs += 1
      }
    }
  }
  println(s"Found $numVs v's in the string.")
  val end1 = System.nanoTime()
  println(s"${(end1 - start1) / 1e6} ms")

  val start2 = System.nanoTime()
  val numVs2 = search.count(_ == 'v')
  println(s"Found $numVs2 v's in the string.")
  val end2 = System.nanoTime()
  println(s"${(end2 - start2) / 1e6} ms")
}
