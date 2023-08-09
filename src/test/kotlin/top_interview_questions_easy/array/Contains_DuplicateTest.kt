package top_interview_questions_easy.array

import org.junit.jupiter.api.Assertions.*
import kotlin.test.Test

internal class Contains_DuplicateTest {
  @Test
  fun `1,2,3,1 true`() {
    assertTrue(containsDuplicate(intArrayOf(1,2,3,1)))
  }
}