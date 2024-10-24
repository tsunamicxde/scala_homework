package homework.homework3

class Book(val title: String, val author: String, val year: Int) {
  override def toString: String = s"Book(title=$title, author=$author, year=$year)"
}

object Book {
  def createBook(title: String, author: String, year: Int): Book = new Book(title, author, year)
}

object TestLibrary {
  def main(args: Array[String]): Unit = {
    val myBook = Book.createBook("Побег из шоушенка", "Стивен Хокинг", 1982)
    println(myBook)
  }
}