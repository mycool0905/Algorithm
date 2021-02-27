package Divide_Two_Integers

// Divide Two Integers
// URI: https://leetcode.com/explore/challenge/card/february-leetcoding-challenge-2021/587/week-4-february-22nd-february-28th/3654/

import kotlin.math.ceil
import kotlin.math.floor

class Solution {
    fun divide(dividend: Int, divisor: Int): Int {
        val result = dividend.toDouble() / divisor
        return if (result > 0) floor(result).toInt()
        else ceil(result).toInt()
    }
}