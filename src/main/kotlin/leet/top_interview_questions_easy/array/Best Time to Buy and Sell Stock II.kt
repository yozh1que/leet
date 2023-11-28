package leet.top_interview_questions_easy.array

fun maxProfit(prices: IntArray): Int {
  var profit = 0
  var i = 0
  var boughtStockIndex = -1
  while (i < prices.size - 1) {
    if (prices[i] < prices[i + 1]) {
      if (boughtStockIndex == -1) {
        boughtStockIndex = i
      }
    } else if (boughtStockIndex != -1) {
      profit += prices[i] - prices[boughtStockIndex]
      boughtStockIndex = -1
    }
    i++
  }
  if (boughtStockIndex != -1 && prices[i] > prices[boughtStockIndex]) {
    profit += prices[i] - prices[boughtStockIndex]
  }
  return profit
}