package leet.top_interview_questions_easy.array

import leet.top_interview_questions_easy.array.singleNumber
import org.junit.jupiter.api.Assertions.*
import kotlin.test.Test

internal class Single_NumberTest {

  @Test
  fun `2,2,1 contains single 1`() {
    assertEquals(
      1,
      singleNumber(intArrayOf(2, 2, 1))
    )
  }

  @Test
  fun `4,1,2,1,2 contains single 4`() {
    assertEquals(
      4,
      singleNumber(intArrayOf(4, 1, 2, 1, 2))
    )
  }

  @Test
  fun `1 contains single 1`() {
    assertEquals(
      1,
      singleNumber(intArrayOf(1))
    )
  }

}