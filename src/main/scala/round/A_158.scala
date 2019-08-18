package round

import scala.io.StdIn._

object A_158 extends App {

  def sgn(i: Int) = if (i > 0) 1 else 0

  val n = readInt()
  val S = readLine().split(" ").map(_.toInt).groupBy(identity).mapValues(_.length).withDefaultValue(0)

  val restOnes = Math.max(0, S(1) - S(3))
  val answer = S(4) + S(3) + S(2) / 2 + (S(2) % 2 match {
    case 0 =>  restOnes / 4 + sgn(restOnes % 4)
    case 1 =>  1 + Math.max(0, restOnes - 2) / 4 + sgn(Math.max(0, restOnes - 2) % 4)
  })

  println(answer)
}
