package misc

import scala.collection.mutable
import scala.io.StdIn._

object B_1175 extends App {
  val Max   = 4294967295L
  var n     = readInt()
  var value = 0L
  val stack = mutable.Stack[Long]()

  stack.push(1)

  var overflow = false

  1 to n foreach { _ =>
    val line = readLine()
    if (!overflow) {
      line.split(" ") match {
        case Array("add") =>
          value += stack.top
          if (value > Max) overflow = true
        case Array("for", x) =>
          val mul = x.toInt * stack.top
          if (mul < Max) stack.push(mul)
          else stack.push(Max + 1)
        case Array("end") => stack.pop()
      }
    }

  }

  println(if (value >= 0 && value <= Max) value else "OVERFLOW!!!")

}
