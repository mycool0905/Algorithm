package Roman_to_Integer

// Roman to Integer
// URI: https://leetcode.com/explore/challenge/card/february-leetcoding-challenge-2021/586/week-3-february-15th-february-21st/3646/

class Solution {
    fun romanToInt(s: String): Int {
        var answer = 0
        val translation = mutableMapOf<Char, Int>()

        translation['I'] = 1
        translation['V'] = 5
        translation['X'] = 10
        translation['L'] = 50
        translation['C'] = 100
        translation['D'] = 500
        translation['M'] = 1000

        var beforeChar = '-'

        s.forEach {
            answer += translation[it]!!
            when(it){
                'V','X' -> {
                    if(beforeChar == 'I'){
                        answer -= 2
                    }
                }
                'L','C' -> {
                    if(beforeChar == 'X'){
                        answer -= 20
                    }
                }
                'D','M' -> {
                    if(beforeChar == 'C'){
                        answer -= 200
                    }
                }
            }
            beforeChar = it
        }

        return answer
    }
}