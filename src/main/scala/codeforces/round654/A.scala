package codeforces.round654

import scala.io.StdIn._

object A extends App {

  val t = readInt()
  1 to t foreach { _ =>
    val i = readInt()
    println((i - 1) / 2 + 1)
  }

}
