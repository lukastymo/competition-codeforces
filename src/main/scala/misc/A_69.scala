import scala.io.StdIn._

object A_69 extends App {
  val n = readInt()
  val A = Array.ofDim[Int](n, 3)

  0 until n foreach { i =>
    A(i) = readLine().split(" ").map(_.toInt)
  }

  def hasEqulibrium(): Boolean = {
    0 until 3 foreach { col =>
      var counter = 0
      0 until n foreach { row =>
        counter += A(row)(col)
      }
      if (counter != 0) return false
    }

    true
  }

  if (hasEqulibrium()) println("YES")
  else println("NO")

}
