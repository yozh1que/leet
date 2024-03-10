package leet.yandex

import org.junit.jupiter.api.Test
import kotlin.math.max
import kotlin.test.assertEquals

fun lengthOfLongestSubstring(s: String): Int {
  var left = 0
  var right = 0
  val occurrences = mutableSetOf<Char>()
  var max = 0

  while (right < s.length) {
    while (occurrences.contains(s[right])) {
      occurrences.remove(s[left])
      left++
    }
    occurrences.add(s[right])
    max = max(max, right - left + 1)
    right++
  }
  return max
}

class LongestSubstringWithoutRepeatingCharactersTest {
  @Test
  fun `test lengthOfLongestSubstring`() {
    assertEquals(
      3,
      lengthOfLongestSubstring("abcabcbb")
    )
    assertEquals(
      1,
      lengthOfLongestSubstring("bbbbb")
    )

  }
}