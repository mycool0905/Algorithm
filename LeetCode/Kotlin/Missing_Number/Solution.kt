package Missing_Number

// Missing Number
// URI: https://leetcode.com/explore/challenge/card/march-leetcoding-challenge-2021/588/week-1-march-1st-march-7th/3659/

class Solution {
    fun missingNumber(nums: IntArray): Int {
        return fasterSolution(nums)
    }

    fun mySolution(nums: IntArray): Int {
        val set = nums.toMutableSet()

        for(i in 0..nums.size){
            if(!set.remove(i)){
                return i
            }
        }

        return nums.first()
    }

    fun fasterSolution(nums: IntArray): Int {
        val sum = nums.sum()
        val expectedSum = nums.size * (nums.size + 1) / 2

        return expectedSum - sum
    }
}