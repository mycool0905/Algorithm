package Determine_if_Two_Strings_Are_Close

// Determine if Two Strings Are Close
// URI: https://leetcode.com/explore/challenge/card/january-leetcoding-challenge-2021/582/week-4-january-22nd-january-28th/3613/

class Solution {
    fun closeStrings(word1: String, word2: String): Boolean {
        if(word1.length != word2.length) return false
        if(word1 == word2) return true
        val word1Map = word1.toMutableList().groupingBy{it}.eachCount()
        val word2Map = word2.toMutableList().groupingBy{it}.eachCount()

        if(word1Map.keys != word2Map.keys) return false

        val word1CountMap = word1Map.values.groupingBy { it }.eachCount()
        val word2CountMap = word2Map.values.groupingBy { it }.eachCount()

        for((k,v) in word1CountMap){
            if(word2CountMap[k] == null || word2CountMap[k] != v){
                return false
            }
        }

        return true
    }
}

fun main(args: Array<String>){
    Solution().closeStrings("abc","cba")
}
