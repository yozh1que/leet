package leet.yandex

import org.junit.jupiter.api.Test
import kotlin.math.abs
import kotlin.test.assertContentEquals


/**
 * https://leetcode.com/problems/summary-ranges/?envType=study-plan-v2&envId=top-interview-150
 */
fun summaryRanges(nums: IntArray): List<String> {
  if (nums.isEmpty()) return emptyList()

  var i = 1
  var start = 0
  val res = mutableListOf<String>()
  while (i <= nums.size) {
    if (i == nums.size || abs( nums[i] - nums[i - 1]) > 1) {
      res.add(
        if (i - 1 != start) {
          "${nums[start]}->${nums[i - 1]}"
        } else {
          "${nums[start]}"
        }
      )
      start = i
    }
    i++
  }
  return res
}

class SummaryRangesTest {

  @Test
  fun `test summaryRanges`() {
    assertContentEquals(
      listOf("0->2", "4->5", "7"),
      summaryRanges(intArrayOf(0, 1, 2, 4, 5, 7))
    )
    assertContentEquals(
      listOf("0", "2->4", "6", "8->9"),
      summaryRanges(intArrayOf(0, 2, 3, 4, 6, 8, 9))
    )

    assertContentEquals(
      listOf("-2147483648->-2147483647","2147483647"),
      summaryRanges(intArrayOf(-2147483648,-2147483647,2147483647))
    )


  }

}