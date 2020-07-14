import scala.collection.mutable
import scala.io.StdIn._
import scala.util.Random

object Lesson1A extends App {
//  val str    = "ababba"
  val s = readLine()

  def log2(x: Int) = Math.ceil(Math.log10(x) / Math.log10(2.0)).toInt

  def solve(str: String): String = {
    if (str.length == 1) return "1 0"

    val cyclic = (str + "$" + str + "$" + str + "$").toCharArray

    val sorted = (str + "$").toCharArray.sorted

    var classes = mutable.Map[String, Int]()
    sorted.foreach {
      case '$' => classes("$") = 0
      case x   => classes(x.toString) = (x - 'a' + 1)
    }

    //  sorted.foreach(println)
    //  println(classes.mkString(","))

    var sortedValues: Seq[Int] = Seq[Int]()

    var size = 0
    val last = Math.ceil(log2(str.length)).toInt
    for (k <- 1 to last) {
      size = Math.pow(2.0, k).toInt
//      println(s"k = $k")
//      println(s"size = $size")

      var (currA, currB) = cyclic.take(size).toVector.splitAt(size / 2)
//      println(s"split to 2: ${currA.mkString} ${currB.mkString}")

      val values = for (i <- 0 to str.length)
        yield {
//          val (a, b) = curr.mkString.splitAt(curr.length / 2)
//          curr = curr.tail :+ cyclic((i + size) % (str.length + 1))
          val answer = (i, classes(currA.mkString), classes(currB.mkString))
//          println(currA.mkString + " " + currB.mkString + " " + answer)

          currA = currA.tail :+ currB.head
          currB = currB.tail :+ cyclic((size + i) % (str.length + 1))
          answer
        }

      sortedValues = values.sortBy(x => (x._2, x._3)).map(_._1)

      classes = mutable.Map[String, Int]()
      if (k < last) {
        var eqv = 0
        sortedValues.foreach { i =>
          val word = cyclic.subSequence(i, i + size).toString
          if (!classes.contains(word)) {
            classes(word) = eqv
            eqv += 1
          }
        }
      }

      //    sortedValues.foreach(println)
      //    println(classes.mkString(","))
    }

    sortedValues.mkString(" ")
  }

//  def randomStr(size: Int): String = {
//    (1 to size map { _ =>
//      ('a' + Random.nextInt('b' - 'a' + 1)).toChar
//    }).mkString
//  }
//
//  def bruteForce(s: String): String = {
//    var ss     = s + "$"
//    var answer = List(ss)
//    while (ss.tail.nonEmpty) {
//      ss = ss.tail
//      answer = ss :: answer
//    }
//    val sorted = answer.sorted
////    println(sorted.mkString(","))
//
//    val xs = sorted
//      .map { v =>
//        s.length + 1 - v.length
//      }
////    println(xs.mkString(","))
//
//    xs.mkString(" ")
//  }

  //bbabbabbabbabbabbab

  println(solve(s))
//  println(solve("a"))
//  println(solve("bbabbabbabbabbabbab"))
//  println(bruteForce("bbabbabbabbabbabbab"))

//  for {
//    size <- 1 to 30
//    s    <- 1 to 50 map (_ => randomStr(size))
//  } {
//    val x1 = solve(s)
//    val x2 = bruteForce(s)
//    if (x1 != x2) {
//      println(s"testing for $s")
//      println(x1)
//      println(x2)
//    }
//  }

}
