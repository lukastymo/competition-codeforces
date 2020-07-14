package codeforces

import scala.io.StdIn._

object B_1181 extends App {
  val l = readInt()
  val A = readLine()

  def split(i: Int): BigInt = {
    if (i < 1 || i >= l) return BigInt("0")

    var (a, b) = A.splitAt(i)

    val aa = BigInt(a)
    val bb = BigInt(b)

//    println(a + " + " + b + " = " + (aa + bb))

    aa + bb
  }

  def getLeft(i: Int) = {
    var left = i
    while (left >= 0 && A(left) == '0') left -= 1
    left
  }

  def getRight(i: Int) = {
    var right = i
    while (right < l && A(right) == '0') right += 1
    right
  }

  val l1 = getLeft(l / 2)
  val l2 = getLeft(l / 2 - 1)
  val r1 = getRight(l / 2)
  val r2 = getRight(l / 2 + 1)

  val l3 = r1
  val l4 = r2
  val r3 = l1
  val r4 = l2

  val result = Set(l1, l2, l3, l4, r1, r2, r3, r4)
    .map { i =>
      split(i)
    }
    .filterNot(_ == 0)
    .min

  println(result)
}
