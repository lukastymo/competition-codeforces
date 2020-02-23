package codeforces

import scala.collection.mutable
import scala.io.StdIn._

object C_1187 extends App {
  val Array(n, m) = readLine().split(" ").map(_.toInt)

  var sorted   = mutable.ArrayBuffer[(Int, Int)]()
  var unsorted = mutable.ArrayBuffer[(Int, Int)]().sortBy(_._1)

  val answer = Array.ofDim[Int](n)

  1 to m foreach { _ =>
    val Array(t, l, r) = readLine().split(" ").map(_.toInt)
    if (t == 1) sorted.append((l, r))
    else unsorted.append((l, r))
  }

  var counter    = 1
  var lastSorted = counter - 1

  sorted.foreach {
    case (l, r) =>
      l to r foreach { i =>
        answer(i - 1) = counter
        lastSorted = counter
        counter += 1
      }
  }

  (0 until n).reverse foreach { i =>
    if (answer(i) == 0) {
      answer(i) = counter
      counter += 1
    }
  }

  unsorted.foreach {
    case (l, r) => {
      l to r foreach { i =>
        answer(i - 1) = counter
        counter += 1
      }

      if (answer(l - 1) < answer(r - 1)) {
        val tmp = answer(l - 1)
        answer(l - 1) = answer(r - 1)
        answer(r - 1) = tmp
      } else {
        // cannot fix or it's fixed
      }
    }
  }

  val isSorted = {
    sorted.forall {
      case (l, r) =>
        l + 1 until r forall { i =>
          answer(i - 1) <= answer(i)
        }
    }
  }

  if (isSorted) {
    println("YES")
    println(answer.mkString(" "))
  } else {
    println("NO")
  }
}
