package codeforces

import scala.io.StdIn._

object A_271 extends App {
  val a = readInt()
  var b = a + 1
  while (b.toString.length != b.toString.distinct.length) {
    b += 1
  }
  println(b)
}
