package leet.yandex.tryouts.corman.c2

import kotlin.test.Test
import kotlin.test.assertContentEquals

fun IntArray.insertionSort(): IntArray {
  var i = 1
  var j: Int
  var num: Int
  while (i < size) {
    num = get(i)
    j = i
    while (j > 0 && get(j - 1) > num) {
      set(j, get(j - 1))
      j--
    }
    set(j, num)
    i++
  }
  return this
}

class InsertionSortTest {
  @Test
  fun `test insertionSort`() {
    assertContentEquals(
      intArrayOf(1, 2, 3, 4, 5),
      intArrayOf(5, 4, 3, 2, 1).insertionSort()
    )
    assertContentEquals(
      intArrayOf(1, 2, 3),
      intArrayOf(1, 3, 2).insertionSort()
    )
  }
}