package oi.oi05

import scala.annotation.tailrec
import scala.io.StdIn._

object sum extends App {
  val n = readInt()
  val m = readInt()

  /*
  n=1, m=0 -> 0
  n=2, m=1 -> 0,1
       m=-1 -> 0,-1

 ...
  n, m -> 0,a1,a2,...,an-1,an
          I)  sum(0..an-1)=m-an-1-1 => an=an-1+1,
          II) sum         =m+1 => an=an-1-1
   */

  val A = Array.ofDim[Int](n)

  @tailrec
  def solve(prev: Int, k: Int, sum: Int): Boolean = {
    if (k == n) return sum == m

    if (k == n - 1) {
      if (sum == m - prev - 1) solve(prev + 1, k + 1, sum + prev + 1)
      else if (sum == m - prev + 1) solve(prev - 1, k + 1, sum + prev - 1)
      else return false
    } else {
???
    }
  }

  val answer = solve(0, 0, 0)
  if (!answer) println("NIE")
  else println(A.mkString("\n"))
}
