package round525

import scala.collection.mutable.ArrayBuffer
import scala.io.StdIn

object C extends App {
  def readInts = StdIn.readLine().split(" ").map(_.toInt)
  def readInt = StdIn.readInt()

  val n = readInt
  val A = readInts

//  val n = 3
//  val A = Array(7, 6, 3)

  def solve() = {
    var sum = 0
    println(n + 1)
    (0 until n).reverse.foreach { i =>
      val diff = (i - (A(i) + sum) % n + n) % n
      sum += diff
      println(s"1 ${i + 1} $diff")
    }
    println(s"2 $n $n")
  }

  solve()
}
