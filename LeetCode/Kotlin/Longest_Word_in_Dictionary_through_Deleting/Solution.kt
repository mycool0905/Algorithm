package Longest_Word_in_Dictionary_through_Deleting

// Longest Word in Dictionary through Deleting
// URI: https://leetcode.com/explore/challenge/card/february-leetcoding-challenge-2021/587/week-4-february-22nd-february-28th/3649/

class Solution {
    fun findLongestWord(s: String, d: List<String>): String {
        val dict = d.sorted()
        var answer = ""

        for (curStr in dict) {
            var curStrIdx = 0
            var sIdx = 0
            while (sIdx < s.length && curStrIdx < curStr.length) {
                if (s[sIdx] == curStr[curStrIdx]) {
                    curStrIdx++
                    if (curStrIdx == curStr.length) {
                        break
                    }
                }
                sIdx++
            }

            if (curStrIdx == curStr.length) {
                if (curStr.length > answer.length) {
                    answer = curStr
                }
            }
        }

        return answer
    }
}

fun main(args: Array<String>) {
    Solution().findLongestWord("abpcplea", listOf("ale", "apple", "monkey", "plea"))
}