package oi.oi09

import scala.io.StdIn._

object Min extends App {
  val n = readInt()
  val A = Array.ofDim[Boolean](n - 1) // false -, true +

  for (i <- 0 until n - 1) {
    A(i) = readChar() == '+'
  }

  def solve(): Unit = {
    var i = 0

    while (true) {
      if (i + 1 >= A.length) {
        print('-')
        return
      } else if (!A(i + 1)) {
        print('-')
        i += 1
      } else {
        print("-(")
        i += 1
        while (i < A.length && A(i)) {
          print('-')
          i += 1
        }
        print(")")
        if (i == A.length) return
      }
    }

    println
  }

  solve()


}
