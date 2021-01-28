package `Smallest_String_With_A_Given_Numeric_Value `

// Smallest String With A Given Numeric Value
// https://leetcode.com/explore/challenge/card/january-leetcoding-challenge-2021/582/week-4-january-22nd-january-28th/3619/

class Solution {
    fun getSmallestString(n: Int, k: Int): String {

        val answer = CharArray(n) {
            'z'
        }
        var count = 26 * n
        var curIdx = 0

        while (count != k) {
            if (answer[curIdx] == 'a') {
                curIdx++
                continue
            }

            count--
            answer[curIdx]--
        }

        return answer.joinToString("")
    }
}