package leet.yandex

import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals
import kotlin.test.assertEquals

/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class TreeNode(val value: Int) {
  var left: TreeNode? = null
  var right: TreeNode? = null
}


fun TreeNode.toLevelValuesMap(acc: MutableMap<Int, MutableList<Int>>, level: Int) {
  left?.toLevelValuesMap(acc, level + 1)
  right?.toLevelValuesMap(acc, level + 1)
  acc.getOrPut(level, { mutableListOf() }).add(value)
}

fun averageOfLevels(root: TreeNode?): DoubleArray {
  if (root == null) {
    return DoubleArray(0)
  }

  mutableMapOf<Int, MutableList<Int>>().apply {
    root.toLevelValuesMap(this, 1)
    var i = 0
    val res = DoubleArray(size)
    while (i < size) {
      res[i] = get(i+1)?.average() ?: 0.0
      i++
    }
    return res
  }
}

class AverageOfLevelsInBinaryTreeTest {
  @Test
  fun `test averageOfLevels`() {
    val acc = mutableMapOf<Int, MutableList<Int>>()
    val root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(3)

    root.toLevelValuesMap(acc, 1)

    println(acc.entries.joinToString())
    assertContentEquals(
      doubleArrayOf(1.0, 2.5),
      averageOfLevels(root)
    )
  }
}