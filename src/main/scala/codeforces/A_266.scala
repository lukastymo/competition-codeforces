package codeforces

import scala.io.StdIn._

object A_266 extends App {

  val n = readInt()
  val S = readLine().map(_ - 'A').toArray

  var cursor = 0
  var deleted = 0
  (1 until n).foreach { i =>
    if (S(cursor) == S(i)) {
      deleted += 1
    } else {
      cursor = i
    }
  }
  println(deleted)
}
