package Reach_a_Number

// URI: https://leetcode.com/explore/challenge/card/december-leetcoding-challenge/572/week-4-december-22nd-december-28th/3583/
// ref: https://leetcode.com/problems/reach-a-number/discuss/112968/Short-JAVA-Solution-with-Explanation

import kotlin.math.absoluteValue

class Solution {
    fun reachNumber(target: Int): Int {
        val absoluteTarget = target.absoluteValue
        var curIdx = 0
        var curStep = 0

        while (curIdx < absoluteTarget || (curIdx - absoluteTarget) % 2 != 0) {
            curStep++
            curIdx += curStep
        }

        return curStep
    }
}

fun main(args: Array<String>) {
    println(Solution().reachNumber(4))
}