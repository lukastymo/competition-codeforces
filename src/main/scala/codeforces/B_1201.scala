package codeforces

import scala.io.StdIn._

object B_1201 extends App {
  val n = readInt()
  val A = readLine().split(" ").map(_.toLong).sorted

  if (A.sum % 2 == 1 || A.init.sum < A.last) println("NO")
  else println("YES")

}
