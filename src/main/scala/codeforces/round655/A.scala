package codeforces.round655

import scala.io.StdIn._

object A extends App {

  val t = readInt()
  1 to t foreach { _ =>
    val n = readInt()
    println((1 to n map (_ => 1)).mkString(" "))
  }

}
