package old

import scala.io.StdIn._

object A_1187 extends App {
  val q = readInt()

  1 to q foreach { _ =>
    val Array(n, a, b) = readLine().split(" ").map(_.toInt)
    val answer = if (a + b == n) {
      Math.max(a, b) + 1
    } else {
      if (n == Math.max(a, b)) {
        Math.max(a, b) - Math.min(a, b) + 1
      } else {
        n - Math.min(a, b) + 1
      }
    }

    println(answer)
  }

}
