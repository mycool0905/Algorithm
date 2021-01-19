package Longest_Palindromic_Substring

// Longest Palindromic Substring
// URI: https://leetcode.com/explore/challenge/card/january-leetcoding-challenge-2021/581/week-3-january-15th-january-21st/3609/

class Solution {

    var maxLength = Int.MIN_VALUE
    var leftIndex = 0
    var rightIndex = 0

    fun palindromeCheck(s: String, leftPoint: Int, rightPoint: Int) {
        var toLeft = leftPoint
        var toRight = rightPoint
        while (toLeft in s.indices && toRight in s.indices && s[toLeft] == s[toRight]){
            toLeft--
            toRight++
        }

        val result = toRight - toLeft - 1
        if (maxLength < result) {
            maxLength = result
            leftIndex = toLeft + 1
            rightIndex = toRight - 1
        }
    }

    fun longestPalindrome(s: String): String {
        for (idx in s.indices) {
            palindromeCheck(s, idx, idx)
            palindromeCheck(s, idx, idx + 1)
        }

        return s.slice(leftIndex..rightIndex)
    }
}

fun main(args: Array<String>){
    Solution().longestPalindrome("babad")
}
