package leet.yandex

import org.junit.jupiter.api.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue


private fun String.toAvailableChars(): MutableMap<Char, Int> {
  val magazineMap = mutableMapOf<Char, Int>()
  forEach { c ->
    magazineMap[c] = magazineMap[c]?.inc() ?: 1
  }
  return magazineMap
}

/**
 * ransomNote = "a", magazine = "b" -> false
 *
 * https://leetcode.com/problems/ransom-note/?envType=study-plan-v2&envId=top-interview-150
 */
fun canConstruct(ransomNote: String, magazine: String): Boolean {
  magazine
    .toAvailableChars().let { availableChars ->
      ransomNote.forEach { c ->
        val availableAmount = availableChars[c]
        if (availableAmount == null || availableAmount <= 0) {
          return false
        } else {
          availableChars[c] = availableAmount - 1
        }
      }
      return true
    }
}

class RansomNoteTest() {

  @Test
  fun `test canConstruct`() {
    assertFalse(
      canConstruct("a", "b")
    )

    assertFalse(
      canConstruct("aa", "ab")
    )

    assertTrue(
      canConstruct("aa", "aab")
    )
  }

}