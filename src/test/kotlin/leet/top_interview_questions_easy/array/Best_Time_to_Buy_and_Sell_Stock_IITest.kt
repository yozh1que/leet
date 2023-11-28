package leet.top_interview_questions_easy.array

import leet.top_interview_questions_easy.array.maxProfit
import kotlin.test.Test
import kotlin.test.assertEquals

internal class Best_Time_to_Buy_and_Sell_Stock_IITest {
  @Test
  fun `7,1,5,3,6,4 profits 7`() {
    assertEquals(
      7,
      maxProfit(intArrayOf(7,1,5,3,6,4))
    )
  }

  @Test
  fun `1,2,3,4,5 profits 4`() {
    assertEquals(
      4,
      maxProfit(intArrayOf(1,2,3,4,5))
    )
  }

  @Test
  fun `7,6,4,3,1 profits 0`() {
    assertEquals(
      0,
      maxProfit(intArrayOf(7,6,4,3,1))
    )
  }
}