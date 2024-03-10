import org.junit.jupiter.api.Test
import kotlin.math.absoluteValue
import kotlin.math.max
import kotlin.math.min
import kotlin.test.assertEquals

fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
  fun Int.deduceIndex(max: Int): Int = this.takeIf {
    this >= 0
  } ?: if (this.absoluteValue > max) {
    max
  } else {
    this * -1 - 1
  }

  fun IntArray.findIndex(value: Int): Int? = if (!isEmpty()) {
    binarySearch(value).apply {
      println(this@findIndex.joinToString() + ", index: $this")
    }.deduceIndex(size - 1)
  } else {
    null
  }

  var ints1 = nums1.takeIf { it.isNotEmpty() } ?: nums2
  var ints2 = nums2.takeIf { it.isNotEmpty() } ?: nums1

  val average = (min(ints1[0], ints2[0]) + max(ints1[ints1.size - 1], ints2[ints2.size - 1])) / 2
  val index1: Int? = ints1.findIndex(average)
  val index2: Int? = ints2.findIndex(average)

  return when {
    index1 == null && index2 == null -> 0.toDouble()
    index1 == null && index2 != null -> ints2[index2].toDouble()
    index2 == null && index1 != null -> ints1[index1].toDouble()
    ints1.size % 2 == 0 && ints2.size % 2 == 0 -> (ints1[index1!!] + ints2[index2!!]) / 2.0
    else -> ints1[index1!!].takeIf { it - average <= ints2[index2!!] - average }?.toDouble()
      ?: ints2[index2!!].toDouble()
  }
}


//  if (nums1.size % 2 == 0 && nums2.size % 2 == 0) {
//    (nums1[index1] + nums2[index2]) / 2.0
//  } else {
//    nums1[index1].takeIf { it - average <= nums2[index2] - average }?.toDouble() ?: nums2[index2].toDouble()
//  }

// merge O(m+n)
//  fun merge(nums1: IntArray, nums2: IntArray): IntArray {
//    var i = 0
//    var j = 0
//    var k = 0
//    var combined = IntArray(size = nums1.size + nums2.size)
//    while (i < nums1.size || j < nums2.size) {
//      when {
//        i < nums1.size && j < nums2.size -> if (nums1[i] < nums2[j]) {
//          combined[k++] = nums1[i++]
//        } else {
//          combined[k++] = nums2[j++]
//        }
//
//        i < nums1.size -> combined[k++] = nums1[i++]
//        else -> combined[k++] = nums2[j++]
//      }
//
//    }
//    return combined
//  }
//  return merge(nums1, nums2).let { combined ->
//    return@let if (combined.size % 2 == 0) {
//      (combined[combined.size / 2] + combined[combined.size / 2 - 1]) / 2.0
//    } else {
//      combined[combined.size / 2].toDouble()
//    }
//  }
//}


// brute force
//=
//  nums1
//    .plus(nums2).let { combined ->
//      combined.sort()
//      return@let if (combined.size % 2 == 0) {
//        (combined[combined.size / 2] + combined[combined.size / 2 - 1]) / 2.0
//      } else {
//        combined[combined.size / 2].toDouble()
//      }
//    }


class MedianOfTwoSortedArraysTest {
  @Test
  fun `test findMedianSortedArrays`() {
    assertEquals(
      2.5,
      findMedianSortedArrays(intArrayOf(1, 3), nums2 = intArrayOf(2, 7))
    )
//    assertEquals(
//      2.0,
//      findMedianSortedArrays(intArrayOf(1, 3), nums2 = intArrayOf(2))
//    )
//    assertEquals(
//      2.5,
//      findMedianSortedArrays(intArrayOf(1, 2), nums2 = intArrayOf(3, 4))
//    )
//    assertEquals(
//      1.0,
//      findMedianSortedArrays(intArrayOf(), nums2 = intArrayOf(1))
//    )
  }

  @Test
  fun xx() {

    val x = null?.takeIf { true } ?: 0
    println(x)
  }

  @Test
  fun x() {
    fun Int.deduceIndex(max: Int): Int = this.takeIf {
      this >= 0
    } ?: if (this.absoluteValue > max) {
      max
    } else {
      this * -1 - 1
    }

//    val nums1 = intArrayOf(1, 3)
//    val nums2 = intArrayOf(4)
//
//
//    val average = (min(nums1[0], nums2[0]) + max(nums1[nums1.size - 1], nums2[nums2.size - 1])) / 2
//    println("$average ${nums1.binarySearch(average)} ${nums2.binarySearch(average)}")

    val nums1 = intArrayOf(1, 2)
    val nums2 = intArrayOf(9, 12)


    val average = (min(nums1[0], nums2[0]) + max(nums1[nums1.size - 1], nums2[nums2.size - 1])) / 2
    val index1 = nums1.binarySearch(average).deduceIndex(nums1.size - 1)
    val index2 = nums2.binarySearch(average).deduceIndex(nums2.size - 1)

    println("$average ${nums1.binarySearch(average)} ${nums2.binarySearch(average)} $index1 $index2")
    var median = -100.0
    if (nums1.size % 2 == 0 && nums2.size % 2 == 0) {
      median = (nums1[index1] + nums2[index2]) / 2.0
    } else {
      median = nums1[index1].takeIf { it - average <= nums2[index2] - average }?.toDouble() ?: nums2[index2].toDouble()
    }

    println("median: $median")
//    nums1.binarySearch(average)
  }
}