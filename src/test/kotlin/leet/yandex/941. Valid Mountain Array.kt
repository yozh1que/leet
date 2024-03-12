package leet.yandex

import org.junit.jupiter.api.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

fun validMountainArray(arr: IntArray): Boolean {
  var shouldClimb = true
  var startedClimbing = false

  var i = 1
  while (i < arr.size) {
    when {
      arr[i] == arr[i - 1] -> return false
      arr[i] < arr[i - 1] -> if (shouldClimb) {
        shouldClimb = false
      }
      else -> {
        startedClimbing = true
        if (!shouldClimb) {
          return false
        }
      }
    }
    i++
  }
  return !shouldClimb && startedClimbing
}

class ValidMountainArrayTest {
  @Test
  fun `test validMountainArray`() {
    assertTrue(validMountainArray(intArrayOf(0, 3, 2, 1)))
    assertFalse(validMountainArray(intArrayOf(3, 5, 5)))
    assertFalse(validMountainArray(intArrayOf(2, 1)))
  }
}
