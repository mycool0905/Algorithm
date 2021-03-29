package Reconstruct_Original_Digits_from_English

// Reconstruct Original Digits from English
// URI: https://leetcode.com/explore/challenge/card/march-leetcoding-challenge-2021/591/week-4-march-22nd-march-28th/3687/

import java.lang.StringBuilder

/*
zero
one
two
three
four
five
six
seven
eight
nine

zero(z) -> six(x) -> seven(s) -> five(v) -> four(f) -> eight(g) -> three(h) -> nine(i) -> two(w) -> one(o)
 */

data class Unit(
    val rep: Char,
    val str: String,
    val num: Char
)

class Solution {
    fun originalDigits(s: String): String {
        val answer = StringBuilder()
        val map = s.groupingBy { it }.eachCount().toMutableMap()
        val units = arrayOf(
            Unit('z', "zero", '0'),
            Unit('x', "six", '6'),
            Unit('s', "seven", '7'),
            Unit('v', "five", '5'),
            Unit('f', "four", '4'),
            Unit('g', "eight", '8'),
            Unit('h', "three", '3'),
            Unit('i', "nine", '9'),
            Unit('w', "two", '2'),
            Unit('o', "one", '1')
        )

        for (unit in units) {
            val count = map[unit.rep] ?: continue
            if(map[unit.rep] == 0){
                continue
            }
            repeat(count) {
                answer.append(unit.num)
            }
            for (char in unit.str) {
                map[char] = map[char]!! - count
            }
        }

        return answer.toList().sorted().joinToString("")
    }
}

fun main(args: Array<String>){
    val solution = Solution().originalDigits("fviefuro")
}