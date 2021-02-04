package Longest_Harmonious_Subsequence

// Longest Harmonious Subsequence
// https://leetcode.com/explore/challenge/card/february-leetcoding-challenge-2021/584/week-1-february-1st-february-7th/3628/

class Solution {
    fun findLHS(nums: IntArray): Int {
        val map = nums.toMutableList().groupingBy { it }.eachCount().toSortedMap()
        var answer = 0
        var beforeKey = Int.MIN_VALUE
        var beforeValue = Int.MIN_VALUE

        map.forEach {
            (k,v) ->
            if(k-beforeKey == 1){
                answer = maxOf(answer, beforeValue + v)
            }

            beforeKey = k
            beforeValue = v
        }

        return answer
    }
}

fun main(args: Array<String>){
    Solution().findLHS(intArrayOf(1,3,2,2,5,2,3,7))
}