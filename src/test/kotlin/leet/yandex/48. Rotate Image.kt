package leet.yandex

import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

fun rotate(matrix: Array<IntArray>): Unit {
  var i = 0
  var j: Int
  var offset = 0
  var holder: Int = -1
  var holder2: Int = -1
  while (i < matrix.size / 2) {
    offset = 0
    while (offset < matrix.size - 1 - i*2) {
      j = 0
      while (j < 4) {
        when (j) {
          // top to right
          0 -> {
            holder = matrix[i + offset][matrix.size - 1 - i]
            matrix[i + offset][matrix.size - 1 - i] = matrix[i][offset + i]
          }
          // right to bottom
          1 -> {
            holder2 = matrix[matrix.size - 1 - i][matrix.size - 1 - i - offset]
            matrix[matrix.size - 1 - i][matrix.size - 1 - i - offset] = holder
            holder = holder2
          }
          // bottom to left
          2 -> {
            holder2 = matrix[matrix.size - 1 - i - offset][i]
            matrix[matrix.size - 1 - i - offset][i] = holder
            holder = holder2
          }
          // left to top
          3 -> {
            matrix[i][offset + i] = holder
          }
        }
        j++
      }
      offset++
    }
    i++
  }
}

class RotateImageTest {
  @Test
  fun `test rotateImage`() {

//    val arr = arrayOf(
//      intArrayOf(5, 1, 9, 11),
//      intArrayOf(2, 4, 8, 10),
//      intArrayOf(13, 3, 6, 7),
//      intArrayOf(15, 14, 12, 16),
//    )
//    rotate(arr)
////    [15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]
//    assertContentEquals(
//      intArrayOf(15, 13, 2, 5),
//      arr[0]
//    )
//    assertContentEquals(
//      intArrayOf(14, 3, 4, 1),
//      arr[1]
//    )
//    assertContentEquals(
//      intArrayOf(12, 6, 8, 9),
//      arr[2]
//    )
//    assertContentEquals(
//      intArrayOf(16, 7, 10, 11),
//      arr[3]
//    )


    val arr = arrayOf(
      intArrayOf(1, 2, 3),
      intArrayOf(4, 5, 6),
      intArrayOf(7, 8, 9)
    )
    rotate(arr)
    assertContentEquals(
      intArrayOf(7, 4, 1),
      arr[0]
    )
    assertContentEquals(
      intArrayOf(8, 5, 2),
      arr[1]
    )
    assertContentEquals(
      intArrayOf(9, 6, 3),
      arr[2]
    )

  }
}
