import scala.io.StdIn._

object B extends App {
  val t = readInt()
  1 to t foreach { _ =>
    val A      = readLine().toCharArray
    val (x, _) = A.groupBy(identity).mapValues(_.length).maxBy(_._2)
    val answer = x match {
      case 'R' => 'P'
      case 'S' => 'R'
      case 'P' => 'S'
    }
    println(Array.fill(A.length)(answer).mkString)
  }
}
