package round

import scala.io.StdIn._

object A_58 extends App {
  val str = readLine()

  try {
    val a = str
      .dropWhile(_ != 'h')
      .dropWhile(_ != 'e')
      .dropWhile(_ != 'l')
      .drop(1)
      .dropWhile(_ != 'l')
      .dropWhile(_ != 'o')
    if (a.nonEmpty) {
      println("YES")
    } else {
      println("NO")
    }
  } catch {
    case e: Exception =>
      println("NO")
  }

}
