package leet.top_interview_questions_easy.array

fun rotate(nums: IntArray, k: Int): Unit {
  if (nums.size <= 1) return
  val updatedK = k % nums.size
  nums.reverse()
  nums.reverse(0, updatedK)
  nums.reverse(updatedK, nums.size)
}

fun IntArray.reverse(fromIndex: Int, toIndex: Int) {
  val midPoint = (fromIndex + toIndex) / 2
  if (fromIndex == midPoint) return
  var reverseIndex = toIndex - 1
  for (index in fromIndex until midPoint) {
    val tmp = this[index]
    this[index] = this[reverseIndex]
    this[reverseIndex] = tmp
    reverseIndex--
  }
}