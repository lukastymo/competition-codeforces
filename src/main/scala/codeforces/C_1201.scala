package codeforces

import scala.io.StdIn._

object C_1201 extends App {

  val Array(n, k) = readLine().split(" ").map(_.toInt)
  var A = readLine().split(" ").map(_.toLong).sorted
//  println(A.mkString(","))

  val prefix = Array.ofDim[Long](n)

  val m = n / 2
  prefix(m) = A(m)
  for (i <- m + 1 until n) {
    prefix(i) = prefix(i - 1) + A(i)
  }
//  println(prefix.mkString(","))

  def binSearch(x: Long) = {
    var l = m
    var r = n - 1

    while (l < r) {
      val mid = ((l.toLong + r.toLong) / 2).toInt
      if (A(mid) >= x) r = mid - 1
      else l = mid + 1
    }

    if (r < n && A(r) < x) r else r - 1

    // m/2 .. r => < x
  }

  def findMax = {
    var max = A(m)
    var l = A(m) + 1
    var r = A(m) + k
    while (l <= r) {
      val mid = (l + r) / 2
      val j = binSearch(mid)
      if (prefix(j) + k >= (j - m + 1) * mid) {
        max = mid
        l = mid + 1
      } else {
        r = mid - 1
      }
    }
//    for (i <- A(m) + 1 to A(m) + k) {
//      val j = binSearch(i)
//      if (prefix(j) + k >= (j - m + 1) * i) max = i
//    }
    max
  }

  println(findMax)
}
