package round

import scala.io.StdIn._

object A_1201 extends App {
  val Array(n, m) = readLine().split(" ").map(_.toInt)
  val C           = Array.ofDim[Int](m, 5)

  0 until n foreach { _ =>
    readLine().toCharArray.zipWithIndex.foreach {
      case (ch, j) =>
        C(j)(ch - 'A') += 1
    }
  }

  val W = readLine().split(" ").map(_.toInt) ++ Array(0, 0, 0, 0, 0)

  var counter = 0
  0 until m foreach { j =>
    counter += C(j).max * W(j)
  }

  println(counter)
}
