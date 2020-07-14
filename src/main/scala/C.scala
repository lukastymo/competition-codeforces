import scala.io.StdIn._

object C extends App {

  val t = readInt()
  1 to t foreach { _ =>
    val Array(n, x) = readLine().split(" ").map(_.toInt)
    val A           = readLine().split(" ").map(_.toInt).sorted

    var teams   = 0
    var current = 0
    for {
      i <- A.length - 1 to 0 by -1
    } {
      current += 1
      if (A(i) * current >= x) {
        teams += 1
        current = 0
      }
    }
    println(teams)
  }
}
