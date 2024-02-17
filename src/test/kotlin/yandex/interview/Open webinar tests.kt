package yandex.interview

import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

fun IntArray.swap(index1: Int, index2: Int) {
  val holder = get(index1)
  set(index1, get(index2))
  set(index2, holder)
}

fun IntArray.reverse() {
  val pivot = size / 2
  var i = 0
  while (i < pivot) {
    swap(i, size - i - 1)
    i++
  }
}

/**
 * https://www.youtube.com/watch?v=aYuAd-IDigc
 */
class OpenWebinarTests {
  @Test
  fun `test reverse`() {
    assertContentEquals(
      intArrayOf(3, 2, 1),
      intArrayOf(1, 2, 3).apply { reverse() }
    )

    assertContentEquals(
      intArrayOf(1, 2, 3, 4),
      intArrayOf(4, 3, 2, 1).apply { reverse() }
    )

    assertContentEquals(
      intArrayOf(),
      intArrayOf().apply { reverse() }
    )


  }
}