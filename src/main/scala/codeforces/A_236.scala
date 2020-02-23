package codeforces

import scala.io.StdIn._

object A_236 extends App {
  println(if (readLine().toCharArray.toSet.size % 2 == 1) "IGNORE HIM!" else "CHAT WITH HER!")
}
