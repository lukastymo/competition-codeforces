package oi.oi13

import scala.io.StdIn._

object Kra extends App {
  val Array(n, m) = readLine().split(" ").map(_.toInt)
  val A = readLine().split(" ").map(_.toLong)
  val B = readLine().split(" ").map(_.toLong)

  for (i <- 1 until n) {
    A(i) = Math.min(A(i-1), A(i))
  }

  val start = 0
  var end = n // shows where the last thing was installed, so end - 1 is free
  var answer = 0

  // find the most-right index i which A(i) >= b
  // side effect: end = i - 1
  def find(b: Long): Int = {
    var l = start
    var r = end - 1

    if (r == 0) {
      if (b <= A(r)) {
        end = 0
      } else {
        end = -1
      }
    } else if (l > r) {
      end = -1
    } else {
      while (l <= r) {
        if (b > A(l)) {
          end = l - 1
          return end
        } else {
          if (r - l <= 10) {
            while (l <= r && b <= A(l)) l += 1
            l -= 1
            end = l
            return end
          } else {
            val mid = (l + r) / 2
//            println(s"BEFORE mid: $mid, l: $l, r: $r")
            if (b <= A(mid)) {
              l = mid
            } else {
              r = mid - 1
            }
//            println(s"AFTER  mid: $mid, l: $l, r: $r")

          }
        }

        end = r
      }

      ???
    }

    end
  }

//  println(A.mkString(","))

  B.foreach { b =>
//    println(s"BEFORE -- $start ${end - 1}, looking for $b")
    val found = find(b)
    answer = found
//    println(s"FOUND: $found, $start ${end - 1}, looking for $b")
  }

  println(answer + 1)
}

/*
7 3
5 6 4 3 6 2 3
3 2 5
 */