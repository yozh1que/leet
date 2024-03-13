package leet.yandex

import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

fun duplicateZeros(arr: IntArray): Unit {
  var zeroes = arr.count { anInt -> anInt == 0 }
  var i = arr.size - 1
  while (i >= 0) {
    if (i + zeroes <= arr.size - 1) {
      arr[i + zeroes] = arr[i]
    }
    if (arr[i] == 0) {
      if(i + zeroes <= arr.size) {
        arr[i + zeroes - 1] = arr[i]
      }
      zeroes--
    }
    i--
  }
}

class DuplicateZerosTest {
  @Test
  fun `test duplicateZeros`() {


    intArrayOf(8, 4, 5, 0, 0, 0, 0, 7).apply {
      duplicateZeros(this)
      assertContentEquals(
        intArrayOf(8, 4, 5, 0, 0, 0, 0, 0),
        this
      )
    }

    intArrayOf(1, 0, 2, 3, 0, 4, 5, 0).apply {
      duplicateZeros(this)
      assertContentEquals(
        intArrayOf(1, 0, 0, 2, 3, 0, 0, 4),
        this
      )
    }

    intArrayOf(1, 0).apply {
      duplicateZeros(this)
      assertContentEquals(
        intArrayOf(1, 0),
        this
      )
    }
    intArrayOf(0, 1).apply {
      duplicateZeros(this)
      assertContentEquals(
        intArrayOf(0, 0),
        this
      )
    }
  }
}
