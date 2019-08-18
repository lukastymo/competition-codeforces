package round

import scala.io.StdIn

object D_525 extends App {
  def readInts = StdIn.readLine().split(" ").map(_.toInt)
  def readInt = StdIn.readInt()
  def readLong = StdIn.readLong()

  val max = 1073741824L // 2^30

  val a = 10L
  val b = 5L

//  def guess(c: Long, d: Long) = {
//    println(s"? $c $d")
//    Console.flush()
//
//    if (a % c > b % d) 1
//    else if (a % c == b % d) 0
//    else -1
//  }

  def guess(c: Long, d: Long): Long = {
    println(s"? $c $d")
    Console.flush()
    readInt
  }

  def solve() = {
    var left = 0L
    var right = max
    var reply = 1L
    var answer1 = 0L

    while (reply != 0) {
      answer1 = (left + right) / 2
      reply = guess(answer1, 0)
      if (reply == 1) right = answer1 - 1
      else if (reply == -1) left = answer1 + 1
    }

    left = 0L
    right = max
    reply = 1
    var answer2 = 0L

    while (reply != 0) {
      answer2 = (left + right) / 2
      reply = guess(answer1, answer2)
      if (reply == -1) right = answer2 - 1
      else if (reply == 1) left = answer2 + 1
    }

    println(s"! $answer1 $answer2")
    Console.flush()
  }

  solve()
}