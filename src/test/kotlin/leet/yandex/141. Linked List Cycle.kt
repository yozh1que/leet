package leet.yandex

import org.junit.jupiter.api.Test
import kotlin.test.assertTrue

class ListNode(var `val`: Int) {
  var next: ListNode? = null
}

fun hasCycle(head: ListNode?): Boolean {
  var slow: ListNode? = head
  var fast: ListNode? = head?.next?.next

  do {
    if (slow != null && slow == fast) return true
    slow = slow?.next ?: return false
    fast = fast?.next?.next ?: return false
  } while (fast?.next != null)
  return false


//  val passedNodes = mutableSetOf<ListNode>()
//  var current = head ?: return false
//  while (current.next != null) {
//    if (current.next == current || passedNodes.contains(current.next)) {
//      return true
//    }
//    passedNodes.add(current)
//    current = current.next!!
//  }
//  return false
}


class LinkedListCycleTest {
  @Test
  fun `test hasCycle`() {

  }
}