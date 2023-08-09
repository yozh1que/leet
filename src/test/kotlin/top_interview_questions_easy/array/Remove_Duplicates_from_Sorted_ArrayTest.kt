package top_interview_questions_easy.array

import org.junit.jupiter.api.Assertions.*
import kotlin.test.Test

internal class Remove_Duplicates_from_Sorted_ArrayTest {
  companion object {
    private const val emptyInt = -1
  }

  @Test
  fun `from 1, 1, 2 to 1, 2, _ `() {
    val arr = intArrayOf(1, 1, 2)

    assertEquals(
      2, // unique count
      removeDuplicates(arr)
    )
    assertArrayEquals(
      intArrayOf(1, 2),
      arr.copyOfRange(0, 2)
    )
  }

  @Test
  fun `from 0,0,1,1,1,2,2,3,3,4 to 0,1,2,3,4,_,`() {
    val arr = intArrayOf(0, 0, 1, 1, 1, 2, 2, 3, 3, 4)

    assertEquals(
      5, // unique count
      removeDuplicates(arr)
    )
    assertArrayEquals(
      intArrayOf(0, 1, 2, 3, 4),
      arr.copyOfRange(0, 5)
    )
  }

}