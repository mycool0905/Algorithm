package Next_Permutation

// Next Permutation
// https://leetcode.com/explore/challenge/card/january-leetcoding-challenge-2021/583/week-5-january-29th-january-31st/3623/

class Solution {
    fun nextPermutation(nums: IntArray): Unit {
        nums.sort(swapAndFindIndex(nums), nums.size)
    }

    fun swapAndFindIndex(nums: IntArray): Int {
        var changeIndex = -1
        for (idx in nums.lastIndex - 1 downTo 0) {
            if (nums[idx] < nums[idx + 1]) {
                changeIndex = idx
                break
            }
        }

        if (changeIndex == -1) {
            return 0
        }

        val temp = nums.slice(changeIndex + 1..nums.lastIndex)
        var beChangedIndex = -1
        var beChangedValue = Int.MAX_VALUE
        for (idx in temp.indices) {
            if (nums[changeIndex] < temp[idx]) {
                if (temp[idx] < beChangedValue) {
                    beChangedValue = temp[idx]
                    beChangedIndex = idx
                }
            }
        }

        val swap = nums[changeIndex]
        nums[changeIndex] = nums[changeIndex + 1 + beChangedIndex]
        nums[changeIndex + 1 + beChangedIndex] = swap


        return changeIndex + 1
    }
}

fun main(args: Array<String>) {
    Solution().nextPermutation(intArrayOf(3, 2, 1))
}