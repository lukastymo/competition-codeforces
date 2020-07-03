package codeforces

import scala.io.StdIn._

object B extends App {

  val t = readInt()
  1 to t foreach { _ =>
    readInt()
    val A = readLine().split(" ").map(_.toInt)

    var counter = 0
    var moves   = 0
    for (i <- 0 until A.length) {
      if (A(i) % 2 != i % 2) {
        moves += 1
        if (i % 2 == 0) {
          counter -= 1
        } else counter += 1
      }
    }

    if (counter != 0) println(-1)
    else println(moves / 2)

  }
}
