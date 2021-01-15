package Check_If_Two_String_Arrays_are_Equivalent

// Check If Two String Arrays are Equivalent
// URI: https://leetcode.com/explore/challenge/card/january-leetcoding-challenge-2021/580/week-2-january-8th-january-14th/3597/

class Solution {
    fun arrayStringsAreEqual(word1: Array<String>, word2: Array<String>): Boolean =
        word1.joinToString("") == word2.joinToString("")
}
