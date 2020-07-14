package codeforces.round655

import scala.io.StdIn._

object B extends App {

  val t = readInt()

  def lcm(originalA: Int, originalB: Int): Int = {
    var a = originalA
    var b = originalB

    var temp = a
    if (a < b) {
      a = b
      b = temp
    }

    // a > b
    while (b > 0) {
      temp = a
      a = b
      b = temp % b
    }
    val gcd = a
    ((originalA.toLong * originalB) / gcd).toInt
  }

  1 to t foreach { _ =>
    val n = readInt()
    if (n % 2 == 0) {
      println(n / 2 + " " + n / 2)
    } else {
      var answer  = Int.MaxValue
      var answerA = 0
      var answerB = 0

      for {
        k <- 2 to (Math.sqrt(n).toInt + 1)
        a = n / k if n % k == 0
        b = n - a
      } {
        val x = lcm(a, b)
        if (x < answer) {
          answer = x
          answerA = a
          answerB = b
        }
      }

      if (answer == Int.MaxValue || n - 1 <= answer) {
        println(1 + " " + (n - 1))
      } else {
        println(answerA + " " + answerB)
      }
    }
  }

}
