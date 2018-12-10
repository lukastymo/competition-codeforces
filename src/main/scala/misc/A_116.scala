import scala.io.StdIn._

object A_116 extends App {
  val n = readInt()
  var total = 0
  var capacity = 0
  1 to n foreach { _ =>
    val Array(a, b) = readLine().split(" ").map(_.toInt)
    total += b - a
//    println(total)
    capacity = Math.max(capacity, total)
  }

  println(capacity)
}
