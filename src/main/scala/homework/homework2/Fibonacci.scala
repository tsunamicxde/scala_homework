package homework.homework2

import scala.annotation.tailrec

object Fibonacci {

  def getFibonacci(n: Int): Int = {
    if (n <= 1) n
    else getFibonacci(n - 1) + getFibonacci(n - 2)
  }

  def getFibonacciTailRec(n: Int): Int = {
    @tailrec
    def helper(n: Int, prev: Int, current: Int): Int = {
      if (n == 0) prev
      else helper(n - 1, current, prev + current)
    }
    helper(n, 0, 1)
  }


  def main(args: Array[String]): Unit = {
    val start1 = System.nanoTime()
    for (i <- 0 until 10) {
      println(s"Fibonacci($i) = ${getFibonacci(i)}")
    }
    val end1 = System.nanoTime()
    println(s"${(end1 - start1) / 1e6} ms")

    val start2 = System.nanoTime()
    for (i <- 0 until 10) {
      println(s"FibonacciTailRec($i) = ${getFibonacciTailRec(i)}")
    }
    val end2 = System.nanoTime()
    println(s"${(end2 - start2) / 1e6} ms")
  }
}
