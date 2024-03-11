package yandex.interview

import leet.yandex.TreeNode
import org.junit.jupiter.api.Test
import kotlin.math.max
import kotlin.test.assertContentEquals
import kotlin.test.assertEquals

fun IntArray.swap(index1: Int, index2: Int) {
  val holder = get(index1)
  set(index1, get(index2))
  set(index2, holder)
}

fun IntArray.reverse() {
  val pivot = size / 2
  var i = 0
  while (i < pivot) {
    swap(i, size - i - 1)
    i++
  }
}

fun TreeNode.leafSum(): Int {
  fun TreeNode.findLeafAndSum(): Int {
    if (left == null && right == null) {
      return `val`
    }
    return (left?.findLeafAndSum() ?: 0) + (right?.findLeafAndSum() ?: 0)
  }
  return findLeafAndSum()
}

fun longestUniqueSubArraySize(array: IntArray): Int {
  val acc = mutableSetOf<Int>()
  var subArraySize = 0
  var left = 0
  var i = 0
  while (i < array.size) {
    if (acc.contains(array[i])) {
      subArraySize = max(subArraySize, acc.size)

      var foundNewLeft = false
      while(!foundNewLeft) {
        if(array[left] == array[i]) {
          foundNewLeft = true
        }
        acc.remove(array[left++])
      }
    }
    acc.add(array[i])
    i++
  }
  return max(subArraySize, acc.size)
}


/**
 * https://www.youtube.com/watch?v=aYuAd-IDigc
 */
class OpenWebinarTests {
  @Test
  fun `test reverse`() {
    assertContentEquals(
      intArrayOf(3, 2, 1),
      intArrayOf(1, 2, 3).apply { reverse() }
    )

    assertContentEquals(
      intArrayOf(1, 2, 3, 4),
      intArrayOf(4, 3, 2, 1).apply { reverse() }
    )

    assertContentEquals(
      intArrayOf(),
      intArrayOf().apply { reverse() }
    )
  }

  @Test
  fun `test leafSum`() {
    assertEquals(
      1,
      TreeNode(1).leafSum()
    )

    assertEquals(
      3,
      TreeNode(1).apply {
        left = TreeNode(3)
      }.leafSum()
    )

    assertEquals(
      8,
      TreeNode(1).apply {
        left = TreeNode(3)
        right = TreeNode(5)
      }.leafSum()
    )

    assertEquals(
      10,
      TreeNode(1).apply {
        left = TreeNode(3).apply {
          left = TreeNode(5)
        }
        right = TreeNode(5)
      }.leafSum()
    )
  }

  @Test
  fun `test longestUniqueSubArraySize`() {
    assertEquals(
      3,
      longestUniqueSubArraySize(intArrayOf(1, 2, 3))
    )
    assertEquals(
      3,
      longestUniqueSubArraySize(intArrayOf(1, 2, 3, 3, 3, 3))
    )
    assertEquals(
      5,
      longestUniqueSubArraySize(intArrayOf(1, 2, 3, 3, 3, 4, 5, 6, 7))
    )

    assertEquals(
      7,
      longestUniqueSubArraySize(intArrayOf(1, 2, 3, 5, 2, 4, 7, 8, 9))
    )

  }
}