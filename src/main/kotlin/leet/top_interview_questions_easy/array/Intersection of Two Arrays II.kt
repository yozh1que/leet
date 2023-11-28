package leet.top_interview_questions_easy.array

import kotlin.math.min

fun intersect(nums1: IntArray, nums2: IntArray): IntArray {

  nums1.sort()
  nums2.sort()
  var i = 0
  var j = 0

  val list = mutableListOf<Int>()
  while (i < nums1.size && j < nums2.size) {
    if(nums1[i] == nums2[j]) {
      list.add(nums1[i])
      i++
      j++
    } else if(nums1[i] < nums2[j]) {
      i++
    } else {
      j++
    }
  }
  return list.toIntArray()
}