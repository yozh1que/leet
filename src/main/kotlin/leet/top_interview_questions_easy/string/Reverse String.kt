package leet.top_interview_questions_easy.string

fun reverseString(s: CharArray): Unit {
  val pivot = s.size / 2
  var i = 0
  var holder: Char
  while (i < pivot) {
    holder = s[i]
    s[i] = s[s.size - (i +1)]
    s[s.size - (i +1)] = holder
    i++
  }
}