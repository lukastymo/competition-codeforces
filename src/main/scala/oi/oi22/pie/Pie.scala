package oi.oi22.pie

import scala.io.StdIn._

object Pie extends App {
  val q = readInt()

  0 until q foreach { _ =>
    var Array(n, m, a, b) = readLine().split(" ").map(_.toInt)

    val A = Array.fill(n, m)(false)
    var B = Array.fill(a, b)(false)

    0 until n foreach { a =>
      val stampLine = readLine().toCharArray.map(_ == 'x')
      A(a) = stampLine
    }

    var leftCol = Integer.MAX_VALUE
    var rightCol = -1
    var bottomRow = -1
    var topRow = -1
    var topCol = -1

    0 until a foreach { aa =>
      val stampLine = readLine().toCharArray.map(_ == 'x')
      val foundLeft = stampLine.indexOf(true)
      val foundRight = stampLine.lastIndexOf(true)

      if (stampLine.contains(true)) bottomRow = aa
      if (foundLeft > -1 && foundLeft < leftCol) leftCol = foundLeft
      if (foundRight > -1 && foundRight > rightCol) rightCol = foundRight

      if (topRow == -1 && stampLine.contains(true)) topRow = aa

      B(aa) = stampLine
    }

    def normalize() = {
      for (row <- 0 until a) {
        B(row) = B(row).slice(leftCol, rightCol + 1)
      }

      B = B.slice(topRow, bottomRow + 1)
      topRow = 0
      topCol = B(0).indexOf(true)

      a = B.length
      b = B(0).length
    }

    normalize()

    require(topRow > -1, "topRow")
    require(topCol > -1, "topCol")

    def update: Boolean = {
      for {
        row <- 0 until n
        col <- 0 until m if A(row)(col)
      } {
        //      debug

        var rowPattern = topRow
        var colPattern = topCol

        while (rowPattern < a) {
          if (row + rowPattern - topRow < 0) return false
          if (col + colPattern - topCol < 0) return false
          if (row + rowPattern - topRow >= n) return false
          if (col + colPattern - topCol >= m) return false

          if (A(row + rowPattern - topRow)(col + colPattern - topCol)) {
            if (B(rowPattern)(colPattern)) A(row + rowPattern - topRow)(col + colPattern - topCol) = false
          } else {
            if (B(rowPattern)(colPattern)) return false
          }

          colPattern += 1
          if (colPattern == b) {
            rowPattern += 1
            colPattern = 0
          }
        }

      }

      true
    }

    //  def debug = {
    //    A.foreach { a =>
    //       val xs = a.map {
    //        case true => "x"
    //        case false => "."
    //      }
    //      println(xs.mkString(""))
    //    }
    //    println("--")
    //  }

    if (update) println("TAK") else println("NIE")
  }
}
