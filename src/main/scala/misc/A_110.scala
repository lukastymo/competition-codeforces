import scala.io.StdIn._

object A_110 extends App {
  val str = readLine()

  println(
    str.toCharArray.count(c => c == '4' || c == '7').toString.toCharArray.forall(c => c == '4' || c == '7') match {
      case true  => "YES"
      case false => "NO"
    }
  )
}
