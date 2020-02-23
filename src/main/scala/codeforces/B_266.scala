package codeforces

import scala.io.StdIn._

object B_266 extends App {
  val Array(n, t) = readLine().split(" ").map(_.toInt)
  val Q = readLine().toCharArray

  1 to t foreach { _ =>
    var i = Q.length - 1
    while (i > 0) {
      if (i - 1 >= 0 && Q(i - 1) < Q(i)) {
        val tmp = Q(i)
        Q(i) = Q(i - 1)
        Q(i - 1) = tmp
        i -= 2
      } else {
        i -= 1
      }
    }
  }

  println(Q.mkString)
}
