package leet.yandex

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

fun reverseWords(s: String): String {
  fun reverseWord(sentence: CharArray, start: Int, end: Int) {
    var left = start
    var right = end
    var holder: Char
    while (left <= right) {
      holder = sentence[right]
      sentence[right] = sentence[left]
      sentence[left] = holder
      left++
      right--
    }
  }

  var left = 0
  var right = 0
  val sentence = s.toCharArray()
  while (right <= sentence.size) {
    if (right == sentence.size || s[right] == ' ') {
      reverseWord(sentence, left, right - 1)
      right++
      left = right
    } else {
      right++
    }
  }
  return String(sentence)
}

class ReverseWordsInAStringIIITest {

  @Test
  fun `test reverseWords`() {
    assertEquals(
      "s'teL ekat edoCteeL tsetnoc",
      reverseWords("Let's take LeetCode contest")
    )
    assertEquals(
      "ti sah",
      reverseWords("it has")
    )

  }

}
