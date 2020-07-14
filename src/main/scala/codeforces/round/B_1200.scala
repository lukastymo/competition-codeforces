package codeforces

import scala.io.StdIn._

object B_1200 extends App {
  val t = readInt()

  1 to t foreach { _ =>
    val Array(n, m, k) = readLine().split(" ").map(_.toInt)
    val H = readLine().split(" ").map(_.toInt)

    var B = m.toLong

    def isPossible: Boolean = {
      for (i <- 0 until n - 1) {
        val x = H(i) - H(i + 1)

        // take as many blocks as possible
        if (x >= 0) {
          B += Math.min(H(i), x + k)
        } else if (x < 0 && -x <= k) {
          B += Math.min(H(i), x + k)
        } else {
          B -= -x - k
        }
        if (B < 0) return false
      }

      true
    }

    println(if (isPossible) "YES" else "NO")
  }

}
