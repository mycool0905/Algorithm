package Create_Sorted_Array_through_Instructions

// URI: https://leetcode.com/explore/challenge/card/january-leetcoding-challenge-2021/580/week-2-january-8th-january-14th/3599/

import kotlin.math.pow

class Solution {
    fun createSortedArray(instructions: IntArray): Int {
        val MODULO = (10.0.pow(9)+7).toInt()
        var answer = 0
        val nums = mutableListOf<Int>()

        fun findIndex(target: Int, lower: Boolean): Int {
            var start = 0
            var end = nums.size

            while (start < end) {
                val mid = (start + end) / 2

                if(lower) {
                    if (nums[mid] < target) {
                        start = mid + 1
                    } else {
                        end = mid
                    }
                }
                else {
                    if (nums[mid] <= target) {
                        start = mid + 1
                    } else {
                        end = mid
                    }
                }
            }

            return start
        }

        instructions.forEach {
            val minIdx = findIndex(it, true)
            val maxIdx = findIndex(it, false)

            answer += minOf(minIdx, nums.size-maxIdx)
            answer %= MODULO

            nums.add(maxIdx, it)
        }

        return answer
    }
}

fun main(args: Array<String>) {
    Solution().createSortedArray(intArrayOf(1,3,3,3,2,4,2,1,2))
}