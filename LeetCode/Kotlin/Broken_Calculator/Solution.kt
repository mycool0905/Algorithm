package Broken_Calculator

// Broken Calculator
// https://leetcode.com/explore/challenge/card/february-leetcoding-challenge-2021/586/week-3-february-15th-february-21st/3647/

class Solution {
    fun brokenCalc(X: Int, Y: Int): Int {
        var answer = 0
        var curNum = Y
        while (curNum > X) {
            if (curNum % 2 == 1) {
                curNum++
            } else {
                curNum /= 2
            }
            answer++
        }

        return answer + X - curNum
    }
}