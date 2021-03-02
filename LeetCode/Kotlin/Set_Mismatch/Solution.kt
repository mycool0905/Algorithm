package Set_Mismatch

// Set Mismatch
// URI: https://leetcode.com/explore/challenge/card/march-leetcoding-challenge-2021/588/week-1-march-1st-march-7th/3658/

class Solution {
    fun findErrorNums(nums: IntArray): IntArray {
        val eachCount = IntArray(nums.size + 1)
        val answer = intArrayOf(-1, -1)
        for (i in nums.indices) {
            eachCount[nums[i]]++
        }

        for (i in 1..nums.size) {
            if (eachCount[i] == 0) {
                answer[1] = i
            } else if (eachCount[i] == 2) {
                answer[0] = i
            }

            if (answer[0] != -1 && answer[1] != -1) {
                break
            }
        }

        return answer
    }
}