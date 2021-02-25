package Shortest_Unsorted_Continuous_Subarray

// Shortest Unsorted Continuous Subarray
// URI: https://leetcode.com/explore/challenge/card/february-leetcoding-challenge-2021/587/week-4-february-22nd-february-28th/3652/

class Solution {
    fun findUnsortedSubarray(nums: IntArray): Int {
        val sorted = nums.sorted()
        var head = -1
        var tail = -2

        for (idx in 0..nums.lastIndex) {
            if (nums[idx] != sorted[idx]) {
                head = idx
                break
            }
        }

        for (idx in nums.lastIndex downTo 0) {
            if (nums[idx] != sorted[idx]) {
                tail = idx
                break
            }
        }

        return tail - head + 1
    }
}