package codeforces

import scala.io.StdIn._

object A_133 extends App {
  val str = readLine()
  if (Set('H', 'Q', '9').intersect(str.toCharArray.toSet).nonEmpty) {
    println("YES")
  } else {
    println("NO")
  }
}
