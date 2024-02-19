package leet.yandex

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

fun removeDuplicates(nums: IntArray): Int {
  var k = 0
  var uniqueElementIndex = 0
  var i = 0
  val last = nums[nums.size - 1]
  while (i < nums.size) {
    if (i == nums.size - 1 || nums[i] != nums[i + 1]) {
      k++
      nums[uniqueElementIndex++] = nums[i]
    }
    if (last == nums[i]) return k + 1
    i++
  }
  return k
}

class RemoveDuplicatesFromSortedArrayTest {
  @Test
  fun `test removeDuplicates`() {
    var arr = intArrayOf(1, 1, 2)
    assertEquals(
      2,
      removeDuplicates(arr)
    )
    println(arr.joinToString())

    arr = intArrayOf(0, 0, 1, 1, 1, 2, 2, 3, 3, 4)
    assertEquals(
      5,
      removeDuplicates(arr)
    )

    println(arr.joinToString())
  }
}