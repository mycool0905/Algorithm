package Kth_Largest_Element_in_an_Array

// URI: https://leetcode.com/explore/challenge/card/january-leetcoding-challenge-2021/581/week-3-january-15th-january-21st/3606/

class Solution {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        return nums.sortDescending().let { nums[k-1] }
    }
}