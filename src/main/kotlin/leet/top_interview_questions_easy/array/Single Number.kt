package leet.top_interview_questions_easy.array

fun singleNumber(nums: IntArray): Int {
  if (nums.size == 1) {
    return nums[0]
  }

  nums.sort()
  var i = 0
  while (i < nums.size) {
    if (i + 1 >= nums.size
      || nums[i] != nums[i + 1]
    ) {
      return nums[i]
    }
    i += 2
  }
  return 0
}