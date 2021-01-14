package Minimum_Operations_to_Reduce_X_to_Zero

// Minimum Operations to Reduce X to Zero
// URI: https://leetcode.com/explore/challenge/card/january-leetcoding-challenge-2021/580/week-2-january-8th-january-14th/3603/

class Solution {
    fun minOperations(nums: IntArray, x: Int): Int {
        val find = nums.sum() - x
        if (find < 0) return -1

        var first = 0
        var last = 0
        var sum = 0
        var maxCnt = Int.MIN_VALUE

        while (last != nums.size) {
            when {
                sum < find -> {
                    sum += nums[last++]
                }
                sum == find -> {
                    maxCnt = maxOf(maxCnt, last - first)
                    sum += nums[last++]
                }
                else -> {
                    sum -= nums[first++]
                }
            }
        }

        if(sum==find){
            maxCnt = maxOf(maxCnt, last - first)
        }

        return if (maxCnt == Int.MIN_VALUE) -1 else nums.size - maxCnt
    }
}

fun main(args:Array<String>){
    Solution().minOperations(intArrayOf(5,2,3,1,1),5)
}
