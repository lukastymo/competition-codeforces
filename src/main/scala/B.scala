import scala.io.StdIn._

object B extends App {
  val t = readInt()
  1 to t foreach { _ =>
    val Array(n, x) = readLine().split(' ').map(_.toInt)

    val A = readLine().toCharArray.map(_.asDigit).map {
      case 0 => 1
      case 1 => -1
    }
    val B = Array.fill(n)(0)
    B(0) = A(0)

    for (i <- 1 until B.length) {
      B(i) = B(i - 1) + A(i)
    }

    val firstInSecondPrefix = B.last + A(0)
    val delta = firstInSecondPrefix - A(0)

    if (x == 0 && !B.contains(0)) {
      println(1)
    } else if ((x > A(0) && delta < 0) || (x < A(0) && delta > 0)) {
      println(0)
    } else if (delta == 0) {
      val answer = B.count(_ == x)
      if (answer == 0) println(0) else println(-1)
    } else {
      val answer = B.map { b =>
        val k = (x - b) / delta
        b + k * delta
      }
      println(answer.count(_ == x))
    }

  }
}
