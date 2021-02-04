package Longest_Substring_Without_Repeating_Characters

// Longest Substring Without Repeating Characters
// URI: https://leetcode.com/explore/challenge/card/january-leetcoding-challenge-2021/579/week-1-january-1st-january-7th/3595/

class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        if (s.isEmpty()) return 0

        var answer = Int.MIN_VALUE
        var saveIdx = 0
        val set = mutableSetOf<Char>()

        s.forEach {
            while (set.contains(it)) {
                set.remove(s[saveIdx++])
            }
            set.add(it)
            answer = maxOf(answer, set.size)
        }

        return answer
    }
}
