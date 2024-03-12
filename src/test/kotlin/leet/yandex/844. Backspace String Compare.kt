package leet.yandex

import org.junit.jupiter.api.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

fun backspaceCompare(s: String, t: String): Boolean {
  val backspace = '#'
  var i = s.length - 1
  var iSkips = 0
  var j = t.length - 1
  var jSkips = 0

  while (i >= 0 || j >= 0) {
    if (i >= 0 && s[i] == backspace) {
      iSkips++
      i--
      continue
    } else {
      if (iSkips > 0) {
        i--
        iSkips--
        continue
      }
    }

    if (j >= 0 && t[j] == backspace) {
      jSkips++
      j--
      continue
    } else {
      if (jSkips > 0) {
        j--
        jSkips--
        continue
      }
    }

    if (i < 0 || j < 0 || s[i] != t[j]) {
      return false
    }
    i--
    j--
  }
  return true
}

class BackspaceStringCompareTest {
  @Test
  fun `test backspaceCompare`() {
    assertTrue(backspaceCompare("ba#c", "bc"))
    assertTrue(backspaceCompare("", "bc##"))
    assertTrue(backspaceCompare("a#b#", "bc##"))
    assertTrue(backspaceCompare("bxj##tw", "bxo#j##tw"))

    assertTrue(backspaceCompare("xywrrmp", "xywrrmu#p"))
    assertFalse(backspaceCompare("bxj##tw", "bxj###tw"))
  }
}
