package codeforces.round654

import scala.io.StdIn._

object B extends App {

  val t = readInt()
  1 to t foreach { _ =>
    val Array(n, r) = readLine().split(" ").map(_.toInt)

    val answer =
      if (n <= r) {
        (n - 1).toLong * (n) / 2 + 1
      } else {
        r.toLong * (r + 1) / 2
      }
    println(answer)
  }
}
