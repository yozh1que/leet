package leet.yandex

import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

/**
 * nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3 -> [1,2,2,3,5,6]
 * nums1 = [1], m = 1, nums2 = [], n = 0 -> [1]
 * nums1 = [0], m = 0, nums2 = [1], n = 1 -> [1]
 * nums1 = [4,5,6,0,0,0], m = 3, [1,2,3], n = 3 -> [1,2,3,4,5,6]
 * nums1 = [1,2,4,5,6,0], m = 5, [3], n = 3 ->  [1,2,3,4,5,6]
 */
fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
  if (n == 0) return
  var i = m - 1
  var j = n - 1
  var endIndex = nums1.size - 1
  while (
    i >= 0 || j >= 0
  ) {
    nums1[endIndex--] = if (i < 0) {
      nums2[j--]
    } else if (j < 0) {
      nums1[i--]
    } else {
      if (nums2[j] > nums1[i]) {
        nums2[j--]
      } else {
        nums1[i--]
      }
    }
  }
}

class MergeSortedArrayTest {
  @Test
  fun `test merge`() {

    intArrayOf(1, 2, 3, 0, 0, 0).let { nums1 ->
      merge(nums1, 3, intArrayOf(2, 5, 6), 3)
      assertContentEquals(
        intArrayOf(1, 2, 2, 3, 5, 6),
        nums1
      )
    }

    intArrayOf(1).let { nums1 ->
      merge(nums1, 1, intArrayOf(), 0)
      assertContentEquals(
        intArrayOf(1),
        nums1
      )
    }

    IntArray(1).let { nums1 ->
      merge(nums1, 0, intArrayOf(1), 1)
      assertContentEquals(
        intArrayOf(1),
        nums1
      )
    }

    intArrayOf(4, 5, 6, 0, 0, 0).let { nums1 ->
      merge(nums1, 3, intArrayOf(1, 2, 3), 3)
      assertContentEquals(
        intArrayOf(1, 2, 3, 4, 5, 6),
        nums1
      )
    }

    intArrayOf(4, 0, 0, 0, 0, 0).let { nums1 ->
      merge(nums1, 1, intArrayOf(1, 2, 3, 5, 6), 5)
      assertContentEquals(
        intArrayOf(1, 2, 3, 4, 5, 6),
        nums1
      )
    }

    intArrayOf(1, 2, 4, 5, 6, 0).let { nums1 ->
      merge(nums1, 5, intArrayOf(3), 1)
      assertContentEquals(
        intArrayOf(1, 2, 3, 4, 5, 6),
        nums1
      )
    }
  }
}