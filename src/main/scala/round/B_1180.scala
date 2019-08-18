package round

import scala.io.StdIn._

object B_1180 extends App {
  val n = readInt()
  var A = readLine().split(" ").map(_.toInt)

  A = A.map { v =>
    if (v >= 0) -v - 1 else v
  }

  if (A.count(_ < 0) % 2 == 1) {
    val (_, minId) = A.zipWithIndex.minBy(_._1)
    A(minId) = -A(minId) - 1
  }

  println(A.mkString(" "))

}
