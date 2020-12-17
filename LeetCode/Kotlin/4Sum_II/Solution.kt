package `4Sum_II`

// URI: https://leetcode.com/explore/challenge/card/december-leetcoding-challenge/571/week-3-december-15th-december-21st/3569/

class Solution {
    fun fourSumCount(A: IntArray, B: IntArray, C: IntArray, D: IntArray): Int {
        var answer = 0
        val mapAB = mutableMapOf<Int, Int>()

        for (a in A) {
            for (b in B) {
                val sum = a + b
                mapAB[sum] = mapAB.getOrDefault(sum, 0) + 1
            }
        }

        for (c in C) {
            for (d in D) {
                val sum = c + d
                answer += mapAB.getOrDefault(-1 * sum, 0)
            }
        }

        return answer
    }
}