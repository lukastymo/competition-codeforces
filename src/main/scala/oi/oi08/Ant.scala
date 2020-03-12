package oi.oi08

import scala.util.control.Breaks._
import scala.io.StdIn._

object Ant extends App {
  val primes = Array(1, 2, 3, 5, 7, 11, 13, 17, 19, 23)

  val A = Array(1L, 2L,4L,8L,16L,32L,64L,128L,256L,512L,1024L,2048L,4096L,8192L,16384L,32768L,65536L,131072L,262144L,524288L,1048576L,2097152L,4194304L,8388608L,16777216L,33554432L,67108864L,134217728L,268435456L,536870912L,1073741824L)
  val B = Array(1L, 3L,9L,27L,81L,243L,729L,2187L,6561L,19683L,59049L,177147L,531441L,1594323L,4782969L,14348907L,43046721L,129140163L,387420489L,1162261467L)
  val C = Array(1L, 5L,25L,125L,625L,3125L,15625L,78125L,390625L,1953125L,9765625L,48828125L,244140625L,1220703125L)
  val D = Array(1L, 7L,49L,343L,2401L,16807L,117649L,823543L,5764801L,40353607L,282475249L,1977326743L)
  val E = Array(1L, 11L,121L,1331L,14641L,161051L,1771561L,19487171L,214358881L)
  val F = Array(1L, 13L,169L,2197L,28561L,371293L,4826809L,62748517L,815730721L)
  val G = Array(1L, 17L,289L,4913L,83521L,1419857L,24137569L,410338673L)
  val H = Array(1L, 19L,361L,6859L,130321L,2476099L,47045881L,893871739L)
  val I = Array(1L, 23L,529L,12167L,279841L,6436343L,148035889L)

  def printSeq(prime: Long): Unit = {
    var p = prime
    (1 to 30).foreach { _ =>
      if (p <= 2000000000L) print(p + ",") else return
      p = p * prime
    }
  }

//  primes.foreach(x => {
//    printSeq(x)
//    println
//  })

  def mul(id: Int) = {
    val p = Array(A, B, C, D, E, F, G, H, I).map(_(id)).product
    println(p + " " + (p <= 2000000000))
  }

  val n = readLong()

  var answer = n
  var maxDivs = 0L

  var a = 0
  var b = 0
  var c = 0
  var d = 0
  var e = 0
  var f = 0
  var g = 0
  var h = 0
  var i = 0

  def findMax(): Unit = {
    breakable {
      for {
        a <- A.indices
        r1 = A(a)
      } {
        if (r1 > n) break
        breakable {
          for {
            b <- 0 to Math.min(a, B.length - 1)
            r2 = r1 * B(b)
          } {
            if (r2 > n) break
            breakable {
              for {
                c <- 0 to Math.min(b, C.length - 1)
                r3 = r2 * C(c)
              } {
                if (r3 > n) break
                breakable {
                  for {
                    d <- 0 to Math.min(c, D.length - 1)
                    r4 = r3 * D(d)
                  } {
                    if (r4 > n) break
                    breakable {
                      for {
                        e <- 0 to Math.min(d, E.length - 1)
                        r5 = r4 * E(e)
                      } {
                        if (r5 > n) break
                        breakable {
                          for {
                            f <- 0 to Math.min(e, F.length - 1)
                            r6 = r5 * F(f)
                          } {
                            if (r6 > n) break
                            breakable {
                              for {
                                g <- 0 to Math.min(f, G.length - 1)
                                r7 = r6 * G(g)
                              } {
                                if (r7 > n) break
                                breakable {
                                  for {
                                    h <- 0 to Math.min(g, H.length - 1)
                                    r8 = r7 * H(h)
                                  } {
                                    if (r8 > n) break
                                    breakable {
                                      for {
                                        i <- 0 to Math.min(h, I.length - 1)
                                        r9 = r8 * I(i)
                                      } {
                                        if (r9 > n) break
                                        val divs = Array(a, b, c, d, e, f, g, h, i).map(x => (x + 1).toLong).product
                                        if ((divs > maxDivs && r9 <= n) || (divs == maxDivs && r9 < answer)) {
                                          maxDivs = divs
                                          answer = r9
//                                          println(Array(a, b, c, d, e, f, g, h, i).mkString(","))
                                        }
                                      }
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }

  findMax()

  println(answer)

}
