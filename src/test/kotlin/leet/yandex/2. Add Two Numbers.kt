package leet.yandex

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

private const val order = 10
fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
  var l1CurrentNode = l1
  var l2CurrentNode = l2
  var resultCurrentNode: ListNode? = null
  var resultStart: ListNode? = null
  var carriage = 0
  var sum: Int

  while (l1CurrentNode != null || l2CurrentNode != null || carriage != 0) {
    sum = (l1CurrentNode?.`val` ?: 0) + (l2CurrentNode?.`val` ?: 0) + carriage
    carriage = sum / order

    val nextNode = ListNode(sum % order)
    if (resultCurrentNode == null) {
      resultStart = nextNode
      resultCurrentNode = nextNode
    } else {
      resultCurrentNode.next = nextNode
      resultCurrentNode = nextNode
    }
    l1CurrentNode = l1CurrentNode?.next
    l2CurrentNode = l2CurrentNode?.next
  }

  return resultStart
}

class AddTwoNumbersTest {

  @Test
  fun `test addTwoNumbers`() {

//    l1 = [9,9,9,9,9,9,9]
//    l2 = [9,9,9,9]
//    Output = [8,9,9,9,0,0,0,1]
    addTwoNumbers(
      ListNode(9).apply {
        next = ListNode(9).apply {
          next = ListNode(9).apply {
            next = ListNode(9).apply {
              next = ListNode(9).apply {
                next = ListNode(9).apply {
                  next = ListNode(9)
                }
              }
            }
          }
        }
      },
      ListNode(9).apply {
        next = ListNode(9).apply {
          next = ListNode(9).apply {
            next = ListNode(9)
          }
        }
      }
    ).assertSequence(8, 9, 9, 9, 0, 0, 0, 1)

//    l1 = [2,4,3]
//    l2 = [5,6,4]
//    Output = [7,0,8]
    addTwoNumbers(
      ListNode(2).apply {
        next = ListNode(4).apply {
          next = ListNode(3)
        }
      },
      ListNode(5).apply {
        next = ListNode(6).apply {
          next = ListNode(4)
        }
      }
    ).assertSequence(7, 0, 8)
  }

  private fun ListNode?.assertSequence(vararg digits: Int) {
    var curr: ListNode? = this
    var i = 0

    while (curr != null) {
      assertEquals(
        digits[i++],
        curr.`val`
      )
      curr = curr.next
    }

  }
}