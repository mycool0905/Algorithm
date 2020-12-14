package Pairs_of_Songs_With_Total_Durations_Divisible_by_60

// URI: https://leetcode.com/explore/featured/card/december-leetcoding-challenge/570/week-2-december-8th-december-14th/3559/

class Solution {
    fun numPairsDivisibleBy60(time: IntArray): Int {
        val timeMap = time.groupBy { it % 60 }
        var answer = 0

        for (key in 0..30) {
            answer +=
                if (key == 0 || key == 30) combinationWith2(timeMap[key]?.size ?: 0)
                else (timeMap[key]?.size ?: 0) * (timeMap[60 - key]?.size ?: 0)
        }

        return answer
    }

    private fun combinationWith2(n: Int): Int {
        return n * (n - 1) / 2
    }
}

fun main(args: Array<String>) {
    val solution = Solution()
    solution.numPairsDivisibleBy60(intArrayOf(60, 60, 60))
}