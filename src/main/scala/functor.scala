import cats._
import cats.implicits._

object functor extends App {

  trait Printable[A] {
    def format(value: A): String
  }

  object PrintableInstances {
    implicit val stringPrintable: Printable[String] =
      new Printable[String] {
        override def format(value: String): String = value
      }

    implicit val intPrintable: Printable[Int] =
      new Printable[Int] {
        override def format(value: Int): String = value.toString
      }

    implicit val catPrintable: Printable[Cat] =
      new Printable[Cat] {
        override def format(value: Cat): String = s"${value.name} is a ${value.color} cat."
      }
  }

  object Printable {

    def format[A](input: A)(implicit p: Printable[A]): String = p.format(input)

    def print[A](input: A)(implicit p: Printable[A]): Unit = println(p.format(input))
  }

  import PrintableInstances._
  Printable.print(123)

  final case class Cat(name: String, age: Int, color: String)

  val cat = Cat("Zoey", 10, "Blonde")

  Printable.print(cat)

  implicit class PrintableOps[A](value: A) {
    def format(implicit printable: Printable[A]): String = printable.format(value)
    def print(implicit printable: Printable[A]): Unit = println(printable.format(value))
  }

  cat.print

  implicit val catShow: Show[Cat] = Show.show(value => s"${value.name} is a ${value.color} cat.")
  println(cat.show)
}
