package leet.top_interview_questions_easy.array

import leet.top_interview_questions_easy.array.rotate
import org.junit.jupiter.api.Assertions.*
import kotlin.test.Test

internal class Rotate_ArrayTest {
  @Test
  fun `1,2,3,4,5,6,7 k = 3 to 5,6,7,1,2,3,4`() {
    val arr = intArrayOf(1, 2, 3, 4, 5, 6, 7)
    rotate(arr, k = 3)
    assertArrayEquals(
      intArrayOf(5, 6, 7, 1, 2, 3, 4),
      arr
    )
  }

  @Test
  fun `-1,-100,3,99 k = 2 to 3,99,-1,-100`() {
    val arr = intArrayOf(-1, -100, 3, 99)
    rotate(arr, k = 2)
    println(arr)
    assertArrayEquals(
      intArrayOf(3, 99, -1, -100),
      arr
    )
  }

  @Test
  fun `1,2 k = 3 to 2, 1`() {
    val arr = intArrayOf(1,2)
    rotate(arr, k = 3)
    println(arr)
    assertArrayEquals(
      intArrayOf(2, 1),
      arr
    )
  }
}