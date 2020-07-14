import scala.io.StdIn._

object A extends App {

  def solve(A: Array[Int]): Option[Array[Int]] = {
    var a = 0
    var c = A.length - 1
    var b = 1

    while (a < b && b < c) {
      while (b < c) {
        if (A(a) < A(b) && A(b) > A(c)) return Some(Array(a, b, c))
        b += 1
      }

      if (A(a) < A(c)) c -= 1 else a += 1
      b = a + 1
    }

    None
  }

  val t = readInt()
  1 to t foreach { _ =>
    readInt()
    val A = readLine().split(" ").map(_.toInt)
    solve(A) match {
      case Some(xs) =>
        println("YES")
        println((xs(0) + 1) + " " + (xs(1) + 1) + " " + (xs(2) + 1))
      case None =>
        println("NO")
    }

  }

}
