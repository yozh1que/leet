package leet.yandex

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

fun removeElement(nums: IntArray, `val`: Int): Int {
  var offset = 0
  var i = 0
  while (i < nums.size) {
    if (nums[i] == `val`) {
      offset++
    } else {
      nums[i - offset] = nums[i]
    }
    i++
  }
  return nums.size - offset
}

class RemoveElementTest {
  @Test
  fun `test removeElement`() {
    var arr = intArrayOf(3, 2, 2, 3, 2)
    var k = 0
    assertEquals(
      3,
      removeElement(arr, 3).also {
        k = it
      }
    )
    println(arr.joinToString())

  }
}