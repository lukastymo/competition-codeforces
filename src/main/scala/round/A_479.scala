package round

import scala.io.StdIn._

object A_479 extends App {
  val a = readInt()
  val b = readInt()
  val c = readInt()

  var max = a + b + c
  max = Math.max(max, a + b * c)
  max = Math.max(max, (a + b) * c)
  max = Math.max(max, a * b + c)
  max = Math.max(max, a * (b + c))
  max = Math.max(max, a * b * c)

  println(max)
}
