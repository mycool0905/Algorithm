package Wiggle_Subsequence

// Wiggle Subsequence
// URI: https://leetcode.com/explore/challenge/card/march-leetcoding-challenge-2021/590/week-3-march-15th-march-21st/3676/

class Solution {
    fun wiggleMaxLength(nums: IntArray): Int {
        val up = IntArray(nums.size)
        val down = IntArray(nums.size)

        up[0] = 1
        down[0] = 1

        for (curIdx in 1..nums.lastIndex) {
            val cur = nums[curIdx] - nums[curIdx - 1]
            when {
                cur > 0 -> {
                    up[curIdx] = down[curIdx - 1] + 1
                    down[curIdx] = down[curIdx - 1]
                }
                cur < 0 -> {
                    down[curIdx] = up[curIdx - 1] + 1
                    up[curIdx] = up[curIdx - 1]
                }
                cur == 0 -> {
                    up[curIdx] = up[curIdx - 1]
                    down[curIdx] = down[curIdx - 1]
                }
            }
        }
        return maxOf(up.last(), down.last())
    }
}

fun main(args: Array<String>){
    Solution().wiggleMaxLength(intArrayOf(1,7,4,9,2,5))
}