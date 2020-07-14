package codeforces

import scala.io.StdIn._

object A extends App {

  val t = readInt()
  1 to t foreach { _ =>
    val A = readLine().toCharArray
    val a = A(0)
    val b = A(1)

    val rest = 3 until A.length by 2 map { i =>
      A(i)
    }

    println("" + a + b + rest.mkString)
  }

}
