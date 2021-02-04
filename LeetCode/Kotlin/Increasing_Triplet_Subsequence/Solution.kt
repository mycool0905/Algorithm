package Increasing_Triplet_Subsequence

// Increasing Triplet Subsequence
// URI: https://leetcode.com/explore/challenge/card/december-leetcoding-challenge/571/week-3-december-15th-december-21st/3570/

class Solution {
    fun increasingTriplet(nums: IntArray): Boolean {
        return increasingTripletFaster(nums)
    }

    private fun increasingTripletFaster(nums: IntArray): Boolean {
        var first = 0
        var min = Int.MAX_VALUE
        for(i in nums.indices) {
            if (nums[i] > min) {
                return true
            } else if (nums[i] <= nums[first]) {
                first = i
            } else if (nums[i] < min) {
                min = nums[i]
            }
        }
        return false
    }

    private fun increasingTripletMine(nums: IntArray): Boolean {
        val sequenceMap = mutableMapOf<Int, MutableList<Int>>()

        for (value in nums) {
            var check = true

            for (key in sequenceMap.keys) {
                if (key < value) {
                    sequenceMap[key]?.let {
                        if (it.last() < value) {
                            it.add(value)
                        } else {
                            it.removeAt(it.lastIndex)
                            it.add(value)
                        }
                    }
                    check = false
                }
                if (sequenceMap[key]!!.size == 3)
                    return true
            }

            if (check && sequenceMap[value] == null)
                sequenceMap[value] = mutableListOf<Int>(value)
        }

        return false
    }
}

fun main(args: Array<String>) {
    val solution = Solution()
    solution.increasingTriplet(intArrayOf(0, 0, 2, 0, 0, -1, -1, 3))
}
