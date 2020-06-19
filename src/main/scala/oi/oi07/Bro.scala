package oi.oi07

import scala.io.StdIn._

object Bro extends App {
  val n = readInt()
  val z = Array.ofDim[Int](n)
  val d = Array.ofDim[Int](n)

  0 until n foreach { i =>
    val Array(need, distance) = readLine().split(" ").map(_.toInt)
    z(i) = need
    d(i) = distance
  }

  var l = 1
  var Dl = 0L
  var r = 0
  var Dr = 0L
  var Zl = 0L
  var Zr = 0L
  var total = 0L
  var minTotal = Long.MaxValue

  for (i <- n - 1 to 1 by -1) {
    Dl = Dl + d(i)
    Zl = Zl + z(i)
    total = total + Dl * z(i)
  }

  def moveRight() = {
    while (Dr + d(r) < Dl) {
      total = total + (Dr + d(r)) * z(l) - Dl * z(l)

      Dr = Dr + d(r)
      Dl = Dl - d(l)
      Zr = Zr + z(l)
      Zl = Zl - z(l)
      l = (l + 1) % n
      r = (r + 1) % n
    }
    minTotal = Math.min(minTotal, total)
  }

  moveRight()

  for (i <- 1 until n) {
    total = total - d(i - 1) * Zr + d(i - 1) * (Zl + z(i - 1))

    Dl = Dl + d(i - 1)
    Dr = Dr - d(i - 1)
    Zl = Zl + z(i - 1)
    Zr = Zr - z(i)

    moveRight()
  }

  println(minTotal)
}
