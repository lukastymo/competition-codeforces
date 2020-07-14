package codeforces.round654

import scala.io.StdIn._

object C extends App {

  val t = readInt()
  1 to t foreach { _ =>
    val Array(a, b, n, m) = readLine().split(" ").map(_.toLong)
    if (m > Math.min(a, b) || n + m > a + b) println("NO")
    else println("YES")
  }
}
