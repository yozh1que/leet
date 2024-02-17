package leet.yandex

import org.junit.jupiter.api.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

/**
 * s = "abc", t = "ahbgdc" -> true
 * s = "axc", t = "ahbgdc" -> false
 */
fun isSubsequence(s: String, t: String): Boolean {
  var i = 0
  var j = 0
  while (j < t.length && i < s.length) {
    if (t[j] == s[i]) {
      i++
    }
    j++
  }
  return i == s.length
}

class IsSubsequenceTest {

  @Test
  fun `test isSubsequence`() {
    assertTrue(
      isSubsequence("abc", "ahbgdc")
    )

    assertFalse(
      isSubsequence("axc", "ahbgdc")
    )
  }

}