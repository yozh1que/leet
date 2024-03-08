package leet.yandex

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

fun twoSum(nums: IntArray, target: Int): IntArray {
  val numsMap = hashMapOf<Int, Int>() // value to index
  var i = 0

  while (i < nums.size) {
    val remainder = target - nums[i]
    val anotherI = numsMap[remainder]
    if (anotherI != null) {
      return intArrayOf(anotherI, i)
    } else {
      numsMap[nums[i]] = i // gradually map population instead of constructing map with all the values at the start
    }
    i++
  }
  return intArrayOf()
}

class TwoSumTest {
  @Test
  fun `test twoSum`() {
    assertArrayEquals(
      intArrayOf(0, 1),
      twoSum(nums = intArrayOf(2, 7, 11, 15), target = 9)
    )
    assertArrayEquals(
      intArrayOf(1, 2),
      twoSum(nums = intArrayOf(3, 2, 4), target = 6)
    )
    assertArrayEquals(
      intArrayOf(0, 1),
      twoSum(nums = intArrayOf(3,3), target = 6)
    )
  }
}