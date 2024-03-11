package leet.yandex

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

fun reverseList(head: ListNode?): ListNode? {
  var curr: ListNode? = head
  var prev: ListNode? = null
  while (curr != null) {
    val next = curr.next
    curr.next = prev
    prev = curr
    curr = next
  }
  return prev


//  var curr: ListNode? = head
//  var nextHolder: ListNode? = null
//  var nextNextHolder: ListNode?
//  var prev: ListNode? = null
//  while (curr?.next != null) {
//    println("${curr.`val`}")
//    nextHolder = curr.next
//    nextNextHolder = curr.next?.next
//    curr.next?.next = curr
//    curr.next = prev
//    prev = nextHolder
//    curr = nextNextHolder
//  }
//
//  curr?.next = prev
//  return curr?.apply {
//    next = prev
//  } ?: prev
}

class ReverseLinkedListTest {
  @Test
  fun `test reverseList`() {
    reverseList(ListNode(1).apply {
      next = ListNode(2).apply {
        next = ListNode(3).apply {
          next = ListNode(4).apply {
            next = ListNode(5)
          }
        }
      }
    }).assertSequence(5, 4, 3, 2, 1)

    reverseList(ListNode(1)).assertSequence(1)
    reverseList(ListNode(1).apply {
      next = ListNode(2)
    }).assertSequence(2, 1)

    reverseList(ListNode(1).apply {
      next = ListNode(2).apply {
        next = ListNode(3)
      }
    }).assertSequence(3, 2, 1)
  }

  private fun ListNode?.assertSequence(vararg sequence: Int) {
    assertNotNull(this)
    var curr: ListNode? = this
    var i = 0
    while (curr != null) {
      assertEquals(
        sequence[i++],
        curr.`val`
      )
      curr = curr.next
    }

  }
}