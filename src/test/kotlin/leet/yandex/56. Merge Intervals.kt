package leet.yandex

import org.junit.jupiter.api.Test
import kotlin.math.max

fun merge(intervals: Array<IntArray>): Array<IntArray> {
  intervals.sortBy { interval ->
    if (interval.size == 2) {
      interval[0]
    } else {
      -1
    }
  }

  var i = 1
  val result = mutableListOf<IntArray>().apply {
    add(intervals[0])
  }
  var j = 0
  while (i < intervals.size) {
    while (
      i < intervals.size &&
      intervals[i][0] >= result[j][0] && intervals[i][0] <= result[j][1]
    ) {
      result[j] = intArrayOf(result[j][0], max(result[j][1], intervals[i][1]))
      i++
    }

    if (i < intervals.size) {
      result.add(intervals[i])
      j++
      i++
    }
  }
  return result.toTypedArray()
}

class MergeIntervalsTest {
  @Test
  fun `test merge`() {
    TODO()
  }
}
