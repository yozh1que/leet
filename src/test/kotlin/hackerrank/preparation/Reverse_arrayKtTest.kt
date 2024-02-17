package hackerrank.preparation

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class Reverse_arrayKtTest {

  @Test
  fun `1 4 3 2 to 2 3 4 1`() {
    Assertions.assertArrayEquals(
      arrayOf(2, 3, 4, 1),
      reverseArray(arrayOf(1, 4, 3, 2))
    )

  }
}