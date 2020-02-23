package codeforces

import scala.io.StdIn._

object A_337 extends App {
  val Array(n, m) = readLine().split(" ").map(_.toInt)
  val A = readLine().split(" ").map(_.toInt).sorted(Ordering[Int].reverse)

  var min = Integer.MAX_VALUE
  var i = 0
  while (i + n <= m) {
    min = Math.min(min, A(i) - A(i  + n - 1))
    i += 1
  }

  println(min)
}
