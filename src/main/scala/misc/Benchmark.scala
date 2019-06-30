package misc

object Benchmark {

  def time[B](f: => B): B = {
    val t0 = System.currentTimeMillis()
    val r  = f
    println((System.currentTimeMillis() - t0) / 1000.0 + "sec.")
    r
  }

}
