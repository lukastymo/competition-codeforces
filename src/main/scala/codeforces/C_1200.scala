package codeforces

import scala.io.StdIn._

object C_1200 extends App {
  def gcd(a: Long, b: Long): Long = {
    var aa = a
    var bb = b

    while (true) {
      if (bb == 0) return aa
      val m = aa % bb
      aa = bb
      bb = m
    }

    1
  }

  val Array(n, m, q) = readLine().split(" ").map(_.toLong)
  val g              = gcd(n, m)

  def pivot1(i: Long)         = {
    if (i == 0) 0L
    else if (i % (n / g) == 0) i / (n / g) - 1
    else i / (n / g)
  }

  def pivot2(i: Long)         = {
    if (i == 0) 0L
    else if (i % (m / g) == 0) i / (m / g) - 1
    else i / (m / g)
  }

  1 to q.toInt foreach { _ =>
    val Array(sx, sy, ex, ey) = readLine().split(" ").map(_.toLong)
    if (g <= 1) println("YES")
    else {
      val r1 = if (sx == 1) {
        pivot1(sy)
      } else {
        pivot2(sy)
      }

      val r2 = if (ex == 1) {
        pivot1(ey)
      } else {
        pivot2(ey)
      }

      println(
        if (r1 == r2) "YES" else "NO"
      )
    }
  }

}
