package top_interview_questions_easy.array

fun rotate(matrix: Array<IntArray>): Unit {
  var rowIndex = 0
  var colIndex = 0
  var sideLength = matrix.size
  var holder: Int

  fun swap(
    rowIndex1: Int,
    colIndex1: Int,
    rowIndex2: Int,
    colIndex2: Int
  ) {
    holder = matrix[rowIndex1][colIndex1]
    matrix[rowIndex1][colIndex1] = matrix[rowIndex2][colIndex2]
    matrix[rowIndex2][colIndex2] = holder
  }

  var sideHolder = IntArray(sideLength)
  var i = 0
  fun swapTopToRight(
    rowIndex: Int,
    colIndex: Int,
    offset: Int
  ) {
    i = offset
    while (i < sideLength - offset) {
      sideHolder[sideLength-i-1] = matrix[sideLength-i-1][colIndex]
      matrix[sideLength-i-1][colIndex] = matrix[rowIndex][colIndex - i]
      i++
    }
  }

  fun swapRightToBottom(
    rowIndex: Int,
    colIndex: Int,
    offset: Int
  ) {
    i = offset
    while (i < sideLength - offset) {
      sideHolder[i] = matrix[rowIndex][i]
      matrix[rowIndex][i] = sideHolder[sideLength - i - 1]
      i++
    }
  }


  swapTopToRight(0, 2, 0)
  swapRightToBottom(2, 2,0)
  return

//  var i = 0
//  while (rowIndex < sideLength) {
//    while (i < sideLength) {
//      val rowIndex1 = rowIndex
//      val colIndex1 = i
//      val rowIndex2 = sideLength - i - 1
//      val colIndex2 = colIndex
//
//      swap(
//        rowIndex1 = rowIndex1,
//        colIndex1 = colIndex1,
//        rowIndex2 = rowIndex2,
//        colIndex2 = colIndex2,
//      )
//      i++
////      colIndex++
//    }
//    return
//  }

}


