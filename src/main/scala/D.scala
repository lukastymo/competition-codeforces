import scala.io.StdIn._

object D extends App {

  def display(A: Array[Array[Int]]): Unit = {
    var maxR = -1
    var minR = Int.MaxValue

    var maxC = -1
    var minC = Int.MaxValue

    for {
      row <- A.indices
    } {
      val s = A(row).sum
      maxR = Math.max(maxR, s)
      minR = Math.min(minR, s)
    }

    val B = A.transpose
    for {
      row <- B.indices
    } {
      val s = B(row).sum
      maxC = Math.max(maxC, s)
      minC = Math.min(minC, s)
    }

    val left  = (maxR - minR)
    val right = (maxC - minC)
    println(left * left + right * right)
    for {
      row <- A.indices
    } {
      println(A(row).mkString)
    }
  }

  val t = readInt()
  1 to t foreach { _ =>
    val Array(n, k) = readLine().split(" ").map(_.toInt)
    val A           = Array.fill(n, n)(0)

    var row       = 0
    var col       = 0
    var colOffset = 1

    for (i <- 0 until k) {
      A(row)(col) = 1

      row += 1
      col += 1
      if (row == n) {
        row = 0
        col = colOffset
        colOffset += 1
      } else {
        col = col % n
        row = row % n
      }
    }

    display(A)
  }
}
