package codeforces

import scala.io.StdIn._

object A_1206 extends App {
  val n = readInt()
  val A = readLine().split(" ").map(_.toInt)
  val m = readInt()
  val B = readLine().split(" ").map(_.toInt)

  val AA = A.toSet
  val BB = B.toSet

  def find(): (Int, Int) = {
    for {
      i <- 0 until n
      j <- 0 until m
    } {
      val x = A(i) + B(j)
      if (!AA.contains(x) && !BB.contains(x)) {
        return (A(i), B(j))
      }
    }

    (0, 0)
  }

  val (a, b) = find()
  println(a + " " + b)
}
