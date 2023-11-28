package leet.top_interview_questions_easy.string

import leet.top_interview_questions_easy.string.reverseString
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class Reverse_StringTest {
  @Test
  fun `"h","e","l","l","o" to "o","l","l","e","h"`() {
    assertArrayEquals(
      "olleh".toCharArray(),
      "hello".toCharArray().apply {
        reverseString(this)
      }
    )
  }

  @Test
  fun `"H","a","n","n","a","h" to "h","a","n","n","a","H"`() {
    assertArrayEquals(
      "Hannah".toCharArray(),
      "hannaH".toCharArray().apply {
        reverseString(this)
      }
    )
  }
}