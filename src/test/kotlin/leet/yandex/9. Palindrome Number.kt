package leet.yandex

import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

fun isPalindrome(x: Int): Boolean {
  if (x < 0) {
    return false
  }
  var xLong = x.toLong()
  var i = xLong
  var xReversed = 0L
  var multiplier = 1L


  while (i > 0) {
    multiplier *= 10
    i /= 10
  }

  i = xLong
  while (multiplier > 0) {
    xReversed += ((i % 10) * multiplier)
    multiplier /= 10
    i /= 10
  }

  return xReversed / 10 == xLong
}
//x.toString().reversed() == x.toString()

class PalindromeNumberTest {
  @Test
  fun `test isPalindrome`() {

//    assertTrue(isPalindrome(121))
//    assertFalse(isPalindrome(-121))
//    assertFalse(isPalindrome(10))
    assertTrue(isPalindrome(1000000001))
  }
}