package problems

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class `1 Two Sum Test` {
  @Test
  fun `2 plus 7 gives 9`() {
    assertArrayEquals(
      intArrayOf(0, 1),
      twoSum(nums = intArrayOf(2, 7, 11, 15), target = 9)
    )
  }

  @Test
  fun `2 plus 4 gives 6`() {
    println(twoSum(nums = intArrayOf(3,2,4), target = 6).contentToString())
    assertArrayEquals(
      intArrayOf(1, 2),
      twoSum(nums = intArrayOf(3,2,4), target = 6)
    )

  }
}