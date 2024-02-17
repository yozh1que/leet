package leet.yandex

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

/**
 * target = 7, nums = [2,3,1,2,4,3] -> 2
 * target = 4, nums = [1,4,4] -> 1
 * target = 11, nums = [1,1,1,1,1,1,1,1] -> 0
 *
 * https://leetcode.com/problems/minimum-size-subarray-sum/description/?envType=study-plan-v2&envId=top-interview-150
 */
fun minSubArrayLen(target: Int, nums: IntArray): Int {
  var q: Int? = null
  var start = 0
  var end = 0
  var sum = nums[end]

  while (end < nums.size -1|| sum >= target) {
    if (sum < target) {
      if (q == null) {
        sum += nums[++end]
      } else {
        sum -= nums[start++]
        sum += nums[++end]
      }
    } else {
      q = end - start + 1
      sum-=nums[start++]
    }
  }

  return q ?: 0
}

class MinimumSizeSubarraySumTest {
  @Test
  fun `test minSubArrayLen`() {
    assertEquals(
      8,
      minSubArrayLen(213, intArrayOf(12, 28, 83, 4, 25, 26, 25, 2, 25, 25, 25, 12))
    )

//    assertEquals(
//      2,
//      minSubArrayLen(7, intArrayOf(2, 3, 1, 2, 4, 3))
//    )

//    assertEquals(
//      1,
//      minSubArrayLen(4, intArrayOf(1,4,4))
//    )
//
//    assertEquals(
//      0,
//      minSubArrayLen(11, intArrayOf(1,1,1,1,1,1,1,1))
//    )
  }
}



//  while (i < nums.size) {
//    sum += nums[end++]
//
//    if (sum >= target) {
//      q = q?.let { min(it, end - start) } ?: (end - start)
//      if (q == 1) {
//        return q
//      }
//
//      sum -= nums[start]
//      start++
//    }
//    i++
//  }