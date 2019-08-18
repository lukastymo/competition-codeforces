package round

import scala.io.StdIn

object A_525 extends App {
  val x = StdIn.readInt()

  def solve(): Unit = {
    for {
      a <- 1 to x
      b <- (1 to a).filter(y => a % y == 0)
    } {
      if (a * b > x && a < b * x) {
        println(a + " " + b)
        return
      }
    }
    println(-1)
  }

  solve()
}
