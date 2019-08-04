package old

import scala.io.StdIn._

object B_1187 extends App {

  def howManyToBuy(ch: Char, howMany: Int): Int =
    S(ch)(howMany - 1)._2

  val n = readInt()
  val s = readLine().toCharArray
  val m = readInt()

  val S = s.zipWithIndex.sortBy(y => (y._1, y._2)).groupBy(_._1)

  1 to m foreach { _ =>
    val x = readLine().toCharArray
    val max = x
      .groupBy(identity)
      .mapValues(_.length)
      .map {
        case (ch, amount) => howManyToBuy(ch, amount)
      }
      .max

    println(max + 1)
  }

}
