package leet.yandex

import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals
import kotlin.test.assertEquals

fun removeDuplicates(nums: IntArray): Int {
  if (nums.isEmpty()) return 0
  var k = 1
  var i = 1
  while (i < nums.size) {
    if(nums[k-1] != nums[i]) {
      nums[k] = nums[i]
      k++
    }
    i++
  }
  return k
}

class RemoveDuplicatesFromSortedArrayTest {
  @Test
  fun `test removeDuplicates`() {
    var arr = intArrayOf(0, 1, 1, 1, 2, 3)
    assertEquals(
      4,
      removeDuplicates(arr)
    )
    assertContentEquals(
      intArrayOf(0, 1, 2, 3, 2, 3),
      arr
    )
    println(arr.joinToString())

    arr = intArrayOf(0, 0, 1, 1, 1, 2, 2, 3, 3, 4)
    assertEquals(
      5,
      removeDuplicates(arr)
    )
    assertContentEquals(
      intArrayOf(0, 1, 2, 3, 4, 2, 2, 3, 3, 4),
      arr
    )

    println(arr.joinToString())
  }
}