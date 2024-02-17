package leet.yandex

import org.junit.jupiter.api.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

/**
 *
 * https://leetcode.com/problems/isomorphic-strings/?envType=study-plan-v2&envId=top-interview-150
 */
fun isIsomorphic(s: String, t: String): Boolean {
  val charRelations = mutableMapOf<Char, Char>()
  val storedSCharacters = mutableSetOf<Char>()
  var i = 0
  while (i < s.length) {
    if(!charRelations.contains(t[i])) {
      if (storedSCharacters.contains(s[i])) {
        return false
      } else {
        storedSCharacters.add(s[i])
      }
      charRelations[t[i]] = s[i]
    } else if(charRelations[t[i]] != s[i]) {
      return false
    }
    i++
  }
  return true
}

class IsomorphicStringsTest {
  @Test
  fun `test isIsomorphic`() {
    assertFalse(isIsomorphic("badc", "baba"))
    assertTrue(isIsomorphic("egg", "add"))
    assertFalse(isIsomorphic("foo", "bar"))
    assertTrue(isIsomorphic("paper", "title"))
    assertFalse(isIsomorphic("bbbaaaba", "aaabbbba"))
  }
}