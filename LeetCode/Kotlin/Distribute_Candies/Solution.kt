package Distribute_Candies

// Distribute Candies
// URI: https://leetcode.com/explore/challenge/card/march-leetcoding-challenge-2021/588/week-1-march-1st-march-7th/3657/

class Solution {
    fun distributeCandies(candyType: IntArray): Int {
        val candySet = candyType.toSet()
        return if (candySet.size >= candyType.size / 2) candyType.size / 2 else candySet.size
    }
}