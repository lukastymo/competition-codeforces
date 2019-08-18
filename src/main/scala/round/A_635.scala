package round

import scala.io.StdIn._

object A_635 extends App {
  val Array(r, c, n, k) = readLine().split(" ").map(_.toInt)

  val A = Array.fill[Boolean](r, c)(false)

  1 to n foreach { _ =>
    val Array(x, y) = readLine().split(" ").map(_.toInt)
    A(x - 1)(y - 1) = true
  }

  def rectangle(size: Int): Int = {
    var x = 0
    var y = 0

    var counter = 0

    for {
      xx <- 0 until r
      yy <- 0 until c
    } yield {
      var counter2 = 0
      for {
        xxx <- xx until xx + size if xx + size < r
        yyy <- yy until yy + size if yy + size < c
      } yield {
        if (A(xxx)(yyy)) counter2 += 1
      }

      if (counter2 == k) counter += 1
    }

    counter
  }

  val answers = for {
    s <- 1 to Math.min(r, c)
  } yield rectangle(s)

  println(answers.sum)
}
