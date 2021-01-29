package Concatenation_of_Consecutive_Binary_Numbers

// Concatenation of Consecutive Binary Numbers
// URI: https://leetcode.com/explore/challenge/card/january-leetcoding-challenge-2021/582/week-4-january-22nd-january-28th/3618/

import kotlin.math.log2
import kotlin.math.pow

class Solution {

    fun calculateShiftLeft(n: Int): Int =
        (log2(n.toFloat()) + 1).toInt()

    fun concatenatedBinary(n: Int): Int {
        val dp = LongArray(100001)
        val MODULO = 10.0.pow(9).toInt() + 7
        dp[1] = 1

        for (i in 2..n) {
            dp[i] = ((dp[i - 1] shl calculateShiftLeft(i)) + i) % MODULO
        }

        return dp[n].toInt()
    }
}