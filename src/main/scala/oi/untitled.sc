def rotCh(ch: Char, n: Int): Char = {
  val m = ('z' - 'a' + 1)
  val v = ch.toInt + n - 'a'

  val answer = if (v < 0) m - (Math.abs(v) % m) else v % m
  (answer + 'a').toChar
}

def rot(s: String, n: Int): String =
  s.toCharArray.map(ch => rotCh(ch, n)).mkString

0 to 30 foreach { x =>
  println(s"$x => " + rot("rzzo xzcytyr, gtpeylx!", x))
}
