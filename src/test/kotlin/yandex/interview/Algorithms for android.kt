package yandex.interview

import kotlin.math.abs
import kotlin.test.Test
import kotlin.test.assertContentEquals

/**
 * [-3, 2, 4] -> [4, 9, 16]
 */
// n*log(n)
fun Array<Int>.squareInts(): Array<Int> = when {
  isEmpty() -> emptyArray()
  else -> map { n -> n * n }
    .let { squared ->
      squared
        .takeIf { first() >= 0 }
        ?: squared.sorted()
    }
    .toTypedArray()
}

// linear
fun Array<Int>.squareInts2(): Array<Int> {
  var startIndex = 0
  var endIndex = size - 1
  var i = size - 1
  val dest = Array(size) { 0 }
  while (startIndex <= endIndex) {
    if (abs(get(startIndex)) < abs(get(endIndex))) {
      dest[i] = get(endIndex) * get(endIndex)
      endIndex--
    } else {
      dest[i] = get(startIndex) * get(startIndex)
      startIndex++
    }
    i--
  }
  return dest
}


// https://www.youtube.com/watch?v=tfvm2k5c9JI
class SampleTest {
  @Test
  fun `test squareInts`() {
    assertContentEquals(
      arrayOf(4, 9, 16),
      arrayOf(-3, 2, 4).squareInts2()
    )
    assertContentEquals(
      arrayOf(4, 9, 16),
      arrayOf(2, 3, 4).squareInts2()
    )
    assertContentEquals(
      arrayOf(4, 9, 16),
      arrayOf(-4, 2, 3).squareInts2()
    )
  }

}