package round

import scala.collection.mutable
import scala.io.StdIn._

object C_1187_editorial extends App {
  val Array(n, m) = readLine().split(" ").map(_.toInt)

  val A         = Array.fill[Int](n + 1)(1)
  val notSorted = mutable.ArrayBuffer[(Int, Int)]()
  val sorted    = mutable.ArrayBuffer[(Int, Int)]()

  1 to m foreach { _ =>
    val Array(t, l, r) = readLine().split(" ").map(_.toInt)

    if (t == 1) {
      sorted += ((l, r))
      (l until r).foreach { i =>
        A(i) = 0
      }
    } else {
      notSorted += ((l, r))
      (l until r).foreach { i =>
        if (A(i) == 1) A(i) = -1
      }
    }
  }

  def isSorted: Boolean = {
    sorted.foreach {
      case (l, r) =>
        (l + 1 to r).foreach { i =>
          if (A(i - 1) > A(i)) {
            return false
          }
        }
    }
    true
  }

  def isNotSorted: Boolean = {
    notSorted.foreach {
      case (l, r) =>
        val allSorted = (l + 1 to r).forall { i =>
          A(i - 1) <= A(i)
        }
        if (allSorted) return false
    }
    true
  }

  var delta = A(1)
  A(1) = 1000000000 / 2

  (2 to n).foreach { i =>
    if (A(i) == 1) A(i) = -1
    val newDelta = A(i)
    A(i) = A(i - 1) + delta
    delta = newDelta
  }

//  println("YES")
//  println(A.tail.mkString(" "))

  if (isSorted && isNotSorted) {
    println("YES")
    println(A.tail.mkString(" "))
  } else {
    println("NO")
  }

}
