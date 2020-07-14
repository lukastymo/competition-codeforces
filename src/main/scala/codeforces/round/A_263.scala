package codeforces

import scala.io.StdIn._

object A_263 extends App {

  var i = 0
  var j = 0
  0 to 4 foreach { row =>
    val S = readLine().split(" ").map(_.toInt)
    val k = S.indexOf(1)
    if (k >= 0) {
      i = row
      j = k
    }
  }

  println(Math.abs(2 - i) + Math.abs(2 - j))
}
