import scala.io.StdIn._

object A extends App {
  /*
  0 - 6 x
  1 - 2
  2 - 5 x
  3 - 5 x
  4 - 4 x
  5 - 5 x
  6 - 6 x
  7 - 3
  8 - x
  9 - x

  2 - 1
  3 - 7
  4 - 11
  5 - 71
  6 - 111
  7 - 711
  8 - 1111
  9 - 7111


   */
  val t = readInt()
  1 to t foreach { _ =>
    val n = readInt()
    val answer =
      if (n % 2 == 0) "1" * (n / 2)
      else "7" + ("1" * (n / 2 - 1))

    println(answer)
  }
}
