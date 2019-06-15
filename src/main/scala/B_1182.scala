import scala.io.StdIn._

object B_1182 extends App {
  val Array(h, w) = readLine().split(" ").map(_.toInt)
  val A           = Array.ofDim[Boolean](h, w)

  for (i <- 0 until h) {
    A(i) = readLine().map(_ != '.').toArray
  }

  def findCenter: Option[(Int, Int)] = {
    for {
      i <- 1 until h - 1
      j <- 1 until w - 1
    } {
      if (A(i)(j) && A(i - 1)(j) && A(i + 1)(j) && A(i)(j - 1) && A(i)(j + 1)) return Some((i, j))
    }

    None
  }

  def hasOnlyCross: Boolean = {
    findCenter match {
      case None =>
        false
      case Some((row, col)) =>
        for {
          i <- 0 until h
          j <- 0 until w
          if i != row && j != col
        } {
          if (A(i)(j)) return false
        }

        var left   = 0
        var right  = w - 1
        var top    = 0
        var bottom = h - 1

        while (!A(row)(left)) left += 1
        while (!A(row)(right)) right -= 1
        while (!A(top)(col)) top += 1
        while (!A(bottom)(col)) bottom -= 1

        for (i <- left to right) if (!A(row)(i)) return false
        for (j <- top to bottom) if (!A(j)(col)) return false

        true
    }

  }

  if (hasOnlyCross) println("YES")
  else println("NO")
}
