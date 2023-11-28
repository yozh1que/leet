package leet.problems

// https://leetcode.com/problems/two-sum/

fun twoSum(nums: IntArray, target: Int): IntArray {
// Можно дешевле наполнять словарь в цикле
//  nums.mapIndexed { index, i -> i to index }.toMap().let { map ->
//    nums.forEachIndexed { index, i ->
//      if (map.contains(target - i) && map[target - i] != index) {
//        return intArrayOf(index, map[target - i]!!)
//      }
//    }
//  }
//  return intArrayOf()

  val map = hashMapOf<Int, Int>()
  var x: Int
  var xIndex: Int?
  nums.forEachIndexed { index, i ->
    x = target - i
    xIndex = map[x]
    if (xIndex != null) {
      return intArrayOf(xIndex!!, index, )
    } else {
      map[i] = index
    }
  }
  return intArrayOf()
}