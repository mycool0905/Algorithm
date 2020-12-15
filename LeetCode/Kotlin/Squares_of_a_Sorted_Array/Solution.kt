package Squares_of_a_Sorted_Array

// URI: https://leetcode.com/explore/challenge/card/december-leetcoding-challenge/571/week-3-december-15th-december-21st/3567/

import kotlin.math.absoluteValue

class Solution {
    fun sortedSquares(nums: IntArray): IntArray {
        return sortedSquaresFaster(nums)
    }

    private fun sortedSquaresNormal(nums: IntArray): IntArray {
        val squareList = nums.map { it*it }

        return squareList.sorted().toIntArray()
    }

    private fun sortedSquaresFaster(nums: IntArray): IntArray {
        val answer = IntArray(nums.size)
        var idx = nums.lastIndex
        var left = 0
        var right = nums.lastIndex

        while(left <= right){

            if(nums[left].absoluteValue >= nums[right].absoluteValue){
                answer[idx--] = nums[left] * nums[left]
                left++
            }
            else{
                answer[idx--] = nums[right] * nums[right]
                right--
            }
        }

        return answer
    }
}