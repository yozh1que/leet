package top_interview_questions_easy.array

fun removeDuplicates(nums: IntArray): Int {
  var k = 0
  var i = 1
  var lastDupIndex = 0
  while (i < nums.size) {
    if (nums[i] != nums[lastDupIndex]) {
      k++
      nums[k] = nums[i]
      lastDupIndex = i
    }
    i++
  }
  return k + 1
}