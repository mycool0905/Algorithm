package Integer_to_Roman

// Integer to Roman
//URI: https://leetcode.com/explore/challenge/card/march-leetcoding-challenge-2021/589/week-2-march-8th-march-14th/3667/

import java.lang.StringBuilder

class Solution {
    fun intToRoman(num: Int): String {
        val answer = StringBuilder("")
        var rest = num
        val unitArray = intArrayOf(1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1)
        val romanArray = arrayOf("M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I")
        val countArray = IntArray(unitArray.size)

        for (idx in unitArray.indices) {
            countArray[idx] = rest / unitArray[idx]
            rest %= unitArray[idx]
        }

        for (idx in countArray.indices){
            for(i in 0 until countArray[idx]){
                answer.append(romanArray[idx])
            }
        }

        return answer.toString()
    }
}