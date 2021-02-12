package Number_of_Steps_to_Reduce_a_Number_to_Zero

// Number of Steps to Reduce a Number to Zero
// URI: https://leetcode.com/explore/challenge/card/february-leetcoding-challenge-2021/585/week-2-february-8th-february-14th/3637/

class Solution {
    fun numberOfSteps(num: Int): Int {
        var answer = 0
        var curNum = num

        while (curNum != 0) {
            if (curNum % 2 == 1) {
                curNum--
            } else {
                curNum = curNum shr 1
            }
            answer++
        }

        return answer
    }
}