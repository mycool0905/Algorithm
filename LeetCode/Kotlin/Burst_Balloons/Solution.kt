package Burst_Balloons

// Leet Code Solutions added
// URI: https://leetcode.com/explore/featured/card/december-leetcoding-challenge/570/week-2-december-8th-december-14th/3564/
// ref: http://easyleetcode.blogspot.com/2016/02/leetcode-312-burst-balloons.html

class Solution {
    fun maxCoins(nums: IntArray): Int {
        val balloons = IntArray(nums.size + 2) {
            if (it == 0 || it == nums.size + 1) 1 else nums[it - 1]
        }

        val dp = Array(balloons.size) {
            IntArray(balloons.size)
        }

        for (right in 1 until balloons.size - 1) {
            for (left in right downTo 1) {
                for (burst in left..right) {
                    dp[left][right] = maxOf(
                        balloons[left - 1] * balloons[burst] * balloons[right + 1] + dp[left][burst - 1] + dp[burst + 1][right],
                        dp[left][right]
                    )
                }
            }
        }

        return dp[1][balloons.lastIndex - 1]
    }
}

fun main(args: Array<String>) {
    val solution = Solution()
    println(solution.maxCoins(intArrayOf(3, 1, 5, 8)))
}
