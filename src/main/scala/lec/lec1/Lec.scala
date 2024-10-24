package lec.lec1

object HelloWorld {
  def main(args: Array[String]): Unit = {
    println(1 + 3)

    type PersonId       = Long
    type ContactType    = String
    type ContactValue   = String
    type PersonContacts = Map[ContactValue, ContactType]

    val contacts: Map[PersonId, PersonContacts] = Map(
      1L -> Map(
        "email" -> "abc@gmail.com",
        "phone" -> "+78005553535",
        "github" -> "tsunamicxde"
      ),
      2L -> Map(
        "email" -> "drdef@gmail.com",
        "phone" -> "+38005553535",
        "github" -> "user2"
      )
    )
    contacts.foreach { case (id, contactInfo) =>
      println(s"Contacts for PersonId $id:")
      println(s"  Email: ${contactInfo.get("email").getOrElse("Not provided")}")
      println(s"  Phone: ${contactInfo.get("phone").getOrElse("Not provided")}")
      println(s"  GitHub: ${contactInfo.get("github").getOrElse("Not provided")}")
      println()
    }

    val u: Unit = println("111")

    val str1 =
      """
        |aaa
        |bbb
        |""".stripMargin
    println(str1)
  }
}

object HelloWorldWithApp extends App {
  println(2 + 3)
}

object TypesAndAllALL extends App {
  var x: Int  = 1
  val x1: Int = 2

  val l1: Long = 10000000000L
  val l2: Long = 1000000000

  val d1: Double = 1.5

  val str = "Vlad"

  val div = x / x1

  val u: Unit = println("")

  val b: Boolean = x1 == x
}

object StringSmthng extends App {
  var x: Int  = 1
  val x1: Int = 2

  val str1 = s"$x + $x1 = ${x + x1}"
  println(str1)
  println("---------------------")
  val str2 =
    """
      |aaa
      |bbb
      |"""
  println(str2)
  println("---------------------")
  val str3 =
    """
      |ccc
      |ddd
      |""".stripMargin
  println(str3)
}

object TupleSmthng extends App {
  val t1: (Int, Int, String, Boolean) = (1, 2, "6", true)
  println(t1._3)
  val t2: (Int, String)            = 1 -> "1"
  val t3: ((Int, String), Boolean) = 1 -> "1" -> true
  println(t3._1._2)

  val (i, s) = t2
}

object DefFun extends App {
  def myPrint(str: String): Unit = println(str)
  myPrint("s")
  def myPrint1(str: String, i: Int): Int = {
    println(i)
    println(str)
    i
  }
  myPrint1("s", 1)
  val x1: Int => Int = myPrint1("s", _)
  def myPrint2(str: String)(i: Int): Int = {
    println(i)
    println(str)
    i
  }
  val x: Int => Int = myPrint2("s")(_)
  x(1)

  val x2: Int => Int = (i: Int) => i * 2
  val x3: Int => Int = i => i * 2
  val x4: Int => Int = _ * 2

  x2.apply(1)
}

object DefaultDefParam extends App {
  def myPrint1(str: String = "None", i: Int, d: Double): Int = {
    println(i)
    println(str)
    i
  }
  myPrint1(
    d = 16d,
    i = 10
  )
}