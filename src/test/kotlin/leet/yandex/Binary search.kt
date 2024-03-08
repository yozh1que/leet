package leet.yandex

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

private const val NOT_FOUND = -1

fun IntArray.search(value: Int): Int {

  fun bSearch(startIndex: Int, endIndex: Int): Int {
    if (startIndex >= endIndex) {
      return NOT_FOUND
    }

    val peekIndex = startIndex + (endIndex - startIndex) / 2
    val peekValue = get(peekIndex)

    return when {
      value == peekValue -> return peekIndex
      value < peekValue -> bSearch(
        startIndex = startIndex,
        endIndex = peekIndex
      )

      else -> bSearch(
        startIndex = peekIndex,
        endIndex = endIndex
      )
    }
  }

  return bSearch(
    startIndex = 0,
    endIndex = size
  )

}

class BinarySearchTest {
  @Test
  fun `test binary search`() {
    assertEquals(
      NOT_FOUND,
      intArrayOf().search(1)
    )

    assertEquals(
      0,
      intArrayOf(1).search(1)
    )

    assertEquals(
      1,
      intArrayOf(1, 2).search(2)
    )

    assertEquals(
      2,
      intArrayOf(1, 2, 3).search(3)
    )
    assertEquals(
      3,
      intArrayOf(1, 2, 3, 4).search(4)
    )
  }
}