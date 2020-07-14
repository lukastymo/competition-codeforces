package codeforces.round654

import scala.io.StdIn._

object D extends App {

  val t = readInt()
  1 to t foreach { _ =>
    val Array(n, k) = readLine().split(" ").map(_.toInt)
    val f =
      if (k % n == 0) 0
      else 2

    var y     = 0
    var x     = 0
    val A     = Array.ofDim[Int](n, n)
    var round = 0
    for (i <- 0 until k) {
      A(y)(x) = 1
      y = (y + 1) % n
      if (y == 0) round += 1
      x = (x + 1 + round) % n
    }

    println(f)
    println(A.map(xs => xs.mkString).mkString("\n"))
  }
}
