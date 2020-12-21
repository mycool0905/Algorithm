package Smallest_Range_II

// URI: https://leetcode.com/explore/challenge/card/december-leetcoding-challenge/571/week-3-december-15th-december-21st/3573/
// ref: https://www.tutorialspoint.com/smallest-range-ii-in-cplusplus

class Solution {
    fun smallestRangeII(A: IntArray, K: Int): Int {
        if (A.size <= 1) return 0

        val sortedA = A.sorted()
        var answer = sortedA.last() - sortedA.first()
        val left = sortedA.first() + K
        val right = sortedA.last() - K

        for (i in 0 until A.size - 1) {
            val min = minOf(sortedA[i + 1] - K, left)
            val max = maxOf(sortedA[i] + K, right)
            answer = minOf(answer, max-min)
        }

        return answer
    }
}