package oi.oi04

import scala.io.StdIn._

object Tro extends App {
  val n = readInt()
  val m = readInt()

  val black = Array.ofDim[Int](n + 1)
  1 to m foreach { _ =>
    val  Array(a, b) = readLine().split(" ").map(_.toInt)
    black(a) += 1
    black(b) += 1
  }

  val total = n * (n - 1) * (n - 2) / 6

  var diffTotal = 0
  for (i <- 1 to n) {
    diffTotal += black(i) * (n - 1 - black(i))
  }
  diffTotal /= 2

  println(total - diffTotal)
}
