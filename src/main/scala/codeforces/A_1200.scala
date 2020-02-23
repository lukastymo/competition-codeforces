package codeforces

import scala.io.StdIn._

object A_1200 extends App {
  val n = readInt()
  val A = readLine()
  var S = Array.ofDim[Boolean](10)

  A.foreach { x =>
    if (x == 'L') {
      var left = 0
      while (S(left)) left += 1
      S(left) = true
      left += 1
    } else if (x == 'R') {
      var right = 9
      while (S(right)) right -= 1
      S(right) = true
      right -= 1
    } else {
      val xx = ("" + x).toInt
      S(xx) = false
    }
  }

  println(
    S.map(x => if (x) 1 else 0).mkString
  )
}
