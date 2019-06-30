package misc

import scala.io.StdIn._

object A_1167 extends App {
  val t = readInt()

  def isPossible(x: Array[Char], n: Int): Boolean = {
    for (i <- 0 to n - 11) {
      if (x(i) == '8') return true
    }
    false
  }

  1 to t foreach { _ =>
    val n = readInt()
    val x = readLine().toArray
    if (isPossible(x, n)) println("YES") else println("NO")
  }
}
