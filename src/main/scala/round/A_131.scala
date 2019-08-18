package round

import scala.io.StdIn._

object A_131 extends App {
  val str = readLine()
  (str.forall(c => c >= 'A' && c <= 'Z')) match {
    case true => println(str.toLowerCase())
    case false =>
      (str.tail.forall(c => c >= 'A' && c <= 'Z')) match {
        case true => println(str.toLowerCase().capitalize)
        case false => println(str)
      }
  }
}
