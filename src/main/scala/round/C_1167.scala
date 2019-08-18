package round

import scala.io.StdIn._

object C_1167 extends App {

  val Array(n, m) = readLine().split(" ").map(_.toInt)

  val routes  = Array.ofDim[List[Int]](m + 1)
  val visited = Array.ofDim[Boolean](n + 1)
  val answer  = Array.ofDim[Int](n + 1)

  1 to n foreach { i =>
    visited(i) = false
  }

  1 to m foreach { i =>
    val A = readLine().split(" ").map(_.toInt)
    if (A(0) == 0) routes(i) = Nil
    else routes(i) = A.tail.toList
  }

  var groups = 0
  1 to m foreach { route =>
    val nodes      = routes(route)
    var wasVisited = false

    for (j <- nodes.indices) {
      if (visited(nodes(j))) {
        wasVisited = true
      }
      visited(nodes(j)) = true
    }

    if (!wasVisited) groups += 1
  }

}
