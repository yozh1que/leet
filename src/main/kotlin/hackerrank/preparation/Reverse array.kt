package hackerrank.preparation

//https://www.hackerrank.com/challenges/arrays-ds/problem?isFullScreen=true

fun reverseArray(a: Array<Int>): Array<Int> {
  var i = 0
  var tmp: Int?
  while (i < a.size / 2) {
    tmp = a[a.lastIndex - i]
    a[a.lastIndex - i] = a[i]
    a[i] = tmp
    i++
  }
  return a
}


fun main() {
  val t = Thread {
    throw IllegalArgumentException()
  }.apply { start() }

  Thread.sleep(1000)
  println("End.. ${Thread.currentThread().isInterrupted} ${Thread.currentThread().isAlive} ${t.isInterrupted} ${t.isAlive} ${t.state}")
}