package Valid_Anagram

// Valid Anagram
// URI: https://leetcode.com/explore/challenge/card/february-leetcoding-challenge-2021/585/week-2-february-8th-february-14th/3636/

class Solution {
    fun isAnagram(s: String, t: String): Boolean {
        val from = s.toCharArray().toMutableList().groupingBy { it }.eachCount()
        val to = t.toCharArray().toMutableList().groupingBy { it }.eachCount()

        if(from.keys != to.keys){
            return false
        }

        for((k,v) in from){
            if(to[k] != v){
                return false
            }
        }

        return true
    }
}