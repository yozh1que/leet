package leet.yandex

import org.junit.jupiter.api.Test
import java.util.*
import kotlin.test.assertFalse
import kotlin.test.assertTrue

fun isValid(s: String): Boolean {
  val stack = Stack<Char>()
  s.forEach { c ->
    when (c) {
      ']' -> if (stack.isEmpty() || stack.pop() != '[') return false
      ')' -> if (stack.isEmpty() || stack.pop() != '(') return false
      '}' -> if (stack.isEmpty() || stack.pop() != '{') return false
      else -> stack.push(c)
    }
  }
  return stack.isEmpty()
}

class ValidParenthesesTest {
  @Test
  fun testIsValid() {
    assertTrue(isValid("()"))
    assertTrue(isValid("()[]{}"))
    assertFalse(isValid("(]"))
    assertFalse(isValid("((]()())"))
    assertFalse(isValid("("))
    assertFalse(isValid(")"))
  }
}