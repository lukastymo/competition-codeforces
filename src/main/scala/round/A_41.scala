package round

import scala.io.StdIn._

object A_41 extends App {
  val a = readLine()
  val b = readLine()

  println(
    if (a == b.reverse) "YES" else "NO"
  )
}
