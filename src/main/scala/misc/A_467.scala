import scala.io.StdIn._

object A_467 extends App {
  val n = readInt()
  println(
    1 to n count { _ =>
      val Array(a, b) = readLine().split(" ").map(_.toInt)
      b - a >= 2
    }
  )
}
