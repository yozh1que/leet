package leet.yandex

import org.junit.jupiter.api.Test
import kotlin.math.max
import kotlin.test.assertEquals

fun maxDepth(root: TreeNode?): Int {
  fun step(node: TreeNode, level: Int): Int {
    return when {
      node.left == null && node.right == null -> level
      node.left != null && node.right != null -> max(step(node.left!!, level + 1), step(node.right!!, level + 1))
      node.left != null -> step(node.left!!, level + 1)
      else -> step(node.right!!, level + 1)
    }
  }
  return root?.let { root -> step(root, 1) } ?: 0
}

class MaximumDepthOfBinaryTreeTest {

  @Test
  fun `test maxDepth`() {
    assertEquals(
      3,
      maxDepth(TreeNode(236).apply {
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