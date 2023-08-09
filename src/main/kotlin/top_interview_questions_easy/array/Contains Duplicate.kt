package top_interview_questions_easy.array

fun containsDuplicate(nums: IntArray): Boolean {
  val s = mutableSetOf<Int>()
  var i = 0
  while (i < nums.size) {
    if (s.contains(nums[i])) {
      return true
    } else {
      s.add(nums[i])
    }
    i++
  }
  return false
}