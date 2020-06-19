package codeforces

import scala.io.StdIn._

object B_1206 extends App {
  val n = readInt()
  val A = readLine().split(" ").map(_.toInt)

  var value = 0L
  var pos = 0
  var neg = 0

  for (i <- 0 until n) {
    A(i) = if (A(i) > 0) {
      value += A(i) - 1
      pos += 1
      1
    } else if (A(i) < 0) {
      value += -A(i) - 1
      neg += 1
      -1
    } else {
      0
    }
  }

  val zeroes = n - pos - neg
  if (zeroes == 0) {
    if (neg % 2 == 1) value += 2
  } else {
    value += zeroes
  }

  println(value)
}
