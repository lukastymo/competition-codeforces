package codeforces.round655

import scala.io.StdIn._

object C extends App {

  val t = readInt()
  1 to t foreach { _ =>
    val n = readInt()
    val A = readLine().split(" ").map(_.toInt)

    var rightMostMatched = 0
    var leftMostMatched  = A.length - 1

    var atLeastOneNotMatched = false

    for (i <- A.indices) {
      if (A(i) != i + 1) {
        atLeastOneNotMatched = true
        if (i > rightMostMatched) rightMostMatched = i
        if (i < leftMostMatched) leftMostMatched = i
      }
    }

    if (!atLeastOneNotMatched) println(0)
    else {
      def containsMatched(): Boolean = {
        for (i <- leftMostMatched to rightMostMatched)
          if (A(i) == i + 1) return true

        false
      }

      if (containsMatched) println(2)
      else println(1)
    }

  }
}
