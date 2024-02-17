package leet.yandex

import org.junit.jupiter.api.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

/**
 * "lol" -> true
 * "race a car" -> false
 * " " -> true (s is an empty string "" after removing non-alphanumeric characters)
 * "A man, a plan, a canal: Panama" -> true
 *
 * https://leetcode.com/problems/valid-palindrome/description/?envType=study-plan-v2&envId=top-interview-150
 */
fun isPalindrome(s: String): Boolean {
  var start = 0
  var end = s.length - 1

  while (start <= end) {
    if (!s[start].isLetterOrDigit()) {
      start++
      continue
    }
    if (!s[end].isLetterOrDigit()) {
      end--
      continue
    }

    if (s[start].lowercaseChar() != s[end].lowercaseChar()) {
      return false
    }
    start++
    end--
  }
  return true
}

class Palindrome {

  @Test
  fun `test isPalindrome`() {
    assertTrue(isPalindrome("lol"))
    assertTrue(isPalindrome(" "))
    assertFalse(isPalindrome("race a car"))
    assertTrue(isPalindrome("A man, a plan, a canal: Panama"))
    assertFalse(isPalindrome("0P"))
  }


}