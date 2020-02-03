package oi.oi18

import scala.annotation.tailrec
import scala.collection.mutable
import scala.io.StdIn._

object liz extends App {
  val Array(n, m) = readLine().split(' ').map(_.toInt)

  val A = readLine().toCharArray.map {
    case 'T' => 2
    case 'W' => 1
  }

  val V = mutable.Map[Int, (Int, Int)]()

  val total1 = A.sum

  val (l, r, arr) = {
    val left = A.indexOf(1)
    val right = A.length - A.reverse.indexOf(1) - 1
    if (left == -1) (-1, -1, Array.empty[Int])
    else {
      val leftSubarray = A.take(right)
      val rightSubarray = A.drop(left + 1)

      if (leftSubarray.sum >= rightSubarray.sum) {
        (0, right - 1, leftSubarray)
      } else {
        (left + 1, n - 1, rightSubarray)
      }
    }
  }

  @tailrec
  def calc(left: Int, right: Int, desired: Int): Unit = {
    if (desired <= 0 || V.contains(desired) || left < 0 || right >= n || left > right) return
    V.put(desired, (left, right))

    if (A(left) == 2) calc(left + 1, right, desired - 2)
    else if (A(right) == 2) calc(left, right - 1, desired - 2)
    else calc(left + 1, right - 1, desired - 2)
  }

  calc(0, n - 1, A.sum)
  if (l > -1) calc(l, r, arr.sum)

//  println(arr.mkString(","))

  1 to m foreach { _ =>
    val k = readInt()
    V.get(k) match {
      case None => println("NIE")
      case Some((l, r)) => println((l + 1) + " " + (r + 1))
    }
  }
}
// 5 3
// TWTWT
// 5
// 1
// 7