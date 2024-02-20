package leet.yandex

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/?envType=study-plan-v2&envId=top-interview-150
 */
fun removeDuplicates2(nums: IntArray): Int {
  var i = 0
  var j = 0
  var k = 0
  var occurrences = 0
  while (i < nums.size) {
    if (i == 0 || nums[i - 1] != nums[i]) {
      occurrences = 1
      k++
      nums[j] = nums[i]
      i++
      j++
    } else {
      while (i < nums.size && nums[i - 1] == nums[i]) {
        if (occurrences >= 2) {
          i++
        } else {
          occurrences++
          k++
          nums[j] = nums[i]
          i++
          j++
        }
      }
    }
  }
  return k
}

class RemoveDuplicatesFromSortedArray2Test {
  @Test
  fun `test removeDuplicates2`() {

    var arr = intArrayOf(0, 0, 1, 1, 1, 1, 2, 3, 3)
    assertEquals(
      7,
      removeDuplicates2(arr)
    )

    println(arr.joinToString())
//
//    var arr = intArrayOf(1, 1, 1, 2, 2, 3)
//    assertEquals(
//      5,
//      removeDuplicates2(arr)
//    )
////
//    println(arr.joinToString())
//
//    var arr = intArrayOf(1,2,3,4,5)
//    assertEquals(
//      5,
//      removeDuplicates2(arr)
//    )
//
//    println(arr.joinToString())

//    val arr = intArrayOf(0,1,1,3)
//    assertEquals(
//      4,
//      removeDuplicates2(arr)
//    )
//
//    println(arr.joinToString())

//    val arr = intArrayOf(0, 1, 1, 1, 3)
//    assertEquals(
//      4,
//      removeDuplicates2(arr)
//    )
//
//    println(arr.joinToString())
  }
}