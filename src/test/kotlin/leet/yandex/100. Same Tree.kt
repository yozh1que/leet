package leet.yandex

import org.junit.jupiter.api.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

//fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
//  val pQueue = LinkedList<TreeNode>()
//  val qQueue = LinkedList<TreeNode>()
//
//  pQueue.addLast(p)
//  qQueue.addLast(q)
//
//  while (pQueue.isNotEmpty() || qQueue.isNotEmpty()) {
//    val pNode = pQueue.removeFirstOrNull()
//    val qNode = qQueue.removeFirstOrNull()
//    if (pNode?.`val` != qNode?.`val`
//      || pNode?.left?.`val` != qNode?.left?.`val`
//      || pNode?.right?.`val` != qNode?.right?.`val`
//    ) {
//      return false
//    }
//
//    pNode?.left?.let(pQueue::addLast)
//    qNode?.left?.let(qQueue::addLast)
//    pNode?.right?.let(pQueue::addLast)
//    qNode?.right?.let(qQueue::addLast)
//  }
//  return true
//}

fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
  if (p == null && q == null) {
    return true
  }
  return p?.`val` == q?.`val` && isSameTree(p?.left, q?.left) && isSameTree(p?.right, q?.right)
}

class SameTreeTest {
  @Test
  fun `test isSameTree`() {

    assertFalse(
      isSameTree(TreeNode(1).apply {
        left = TreeNode(2)
      }, TreeNode(1).apply {
        left = null
        right = TreeNode(2)
      })
    )


    assertTrue(
      isSameTree(null, null)
    )


    assertTrue(
      isSameTree(
        p = TreeNode(236).apply {
          left = TreeNode(104).apply {
            right = TreeNode(227)
          }
          right = TreeNode(701).apply {
            right = TreeNode(911)
          }
        },
        q = TreeNode(236).apply {
          left = TreeNode(104).apply {
            right = TreeNode(227)
          }
          right = TreeNode(701).apply {
            right = TreeNode(911)
          }
        })
    )


  }
}