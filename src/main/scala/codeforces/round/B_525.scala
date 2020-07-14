package codeforces

import scala.io.StdIn

object B_525 extends App {
  def readInts = StdIn.readLine().split(" ").map(_.toInt)

  val Array(n, k) = readInts
  val A = readInts.distinct.sorted

  def solve() = {
    var i = 0
    var offset = 0

    (0 until k).map { _ =>
      while (i < A.length && (A(i) - offset) == 0) i += 1
      if (i >= A.length) 0
      else {
        val res = A(i) - offset
        offset = A(i)
        res
      }
    }
  }

  println(solve().mkString("\n"))
}
