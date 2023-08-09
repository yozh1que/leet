package top_interview_questions_easy.array

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class Rotate_ImageTest() {

  /**
   *
   * [1,2,3] [7,4,1]
   * [4,5,6] [8,5,2]
   * [7,8,9] [9,6,3]
   *
   */
  @Test
  fun `1,2,3 4,5,6 7,8,9 to 1,2,3 4,5,6 7,8,9`() {
    val arr = arrayOf(intArrayOf(1,2,3), intArrayOf(4,5,6), intArrayOf(7,8,9))
    assertArrayEquals(
      arrayOf(intArrayOf(7,4,1), intArrayOf(8,5,2), intArrayOf(9,6,3)),
      arr.apply(::rotate)
    )
  }
}