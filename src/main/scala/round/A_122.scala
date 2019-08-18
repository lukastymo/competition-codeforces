package round

import scala.io.StdIn._

object A_122 extends App {
  val n = readInt()

  def isLucky(x: Int) = x.toString.toCharArray.toSet.forall(x => x == '4' || x == '7')

  val L = 1 to 1000 filter isLucky

  if (L.contains(n) || L.exists(l => n % l == 0)) println("YES")
  else println("NO")
}
