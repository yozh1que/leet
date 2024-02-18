package leet.yandex

import org.junit.jupiter.api.Test
import kotlin.math.abs
import kotlin.math.min
import kotlin.test.assertEquals


// надо просто обойти сортированное дерево и сравнить попарно элементы (чем ближе элементы друг к другу тем меньше дифф, а чем дальше - тем больше)
fun getMinimumDifference(root: TreeNode?): Int {
  if (root == null) return 0

  var minDiff: Int = Int.MAX_VALUE
  var previousLesserNode: TreeNode? = null

  fun updateMinDiff(node: TreeNode) {
    node.left?.let(::updateMinDiff)
    previousLesserNode?.let { prevNode ->
      minDiff = min(minDiff, abs(node.`val` - prevNode.`val`))
    }
    previousLesserNode = node // storing previous lesser element to compare with the `node` (next sorted element)
    node.right?.let(::updateMinDiff)
  }

  updateMinDiff(root)
  return minDiff
}

class MinimumAbsoluteDifferenceInBSTTest {
  @Test
  fun `test getMinimumDifference`() {
//[236,104,701,null,227,null,911]
    assertEquals(
      9,
      getMinimumDifference(TreeNode(236).apply {
        left = TreeNode(104).apply {
          right = TreeNode(227)
        }
        right = TreeNode(701).apply {
          right = TreeNode(911)
        }
      })
    )

//    [1,null,5,3]
//    assertEquals(
//      2,
//      getMinimumDifference(TreeNode(1).apply {
//        right = TreeNode(5).apply {
//          left = TreeNode(3)
//        }
//      })
//    )
//    assertEquals(
//      1,
//      getMinimumDifference(TreeNode(4).apply {
//        left = TreeNode(2).apply {
//          left = TreeNode(1)
//          right = TreeNode(3)
//        }
//        right = TreeNode(6)
//      })
//    )
//
//    assertEquals(
//      1,
//      getMinimumDifference(TreeNode(1).apply {
//        left = TreeNode(0)
//        right = TreeNode(48).apply {
//          left = TreeNode(12)
//          right = TreeNode(49)
//        }
//
//      })
//    )
  }
}