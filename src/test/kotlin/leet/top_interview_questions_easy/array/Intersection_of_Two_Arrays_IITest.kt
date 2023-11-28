package leet.top_interview_questions_easy.array

import leet.top_interview_questions_easy.array.intersect
import org.junit.jupiter.api.Assertions.*
import kotlin.test.Test

internal class Intersection_of_Two_Arrays_IITest {

  @Test
  fun `1,2,2,1 intersects 2,2 with 2,2` () {
    assertArrayEquals(
      intArrayOf(2,2),
      intersect(nums1 = intArrayOf(1,2,2,1), nums2 = intArrayOf(2,2))
    )
  }

  @Test
  fun `4,9,5 intersects 9,4,9,8,4 with 4,9` () {
    assertArrayEquals(
      intArrayOf(4,9),
      intersect(nums1 = intArrayOf(4,9,5), nums2 = intArrayOf(9,4,9,8,4 )).apply { sorted() }
    )
  }
}