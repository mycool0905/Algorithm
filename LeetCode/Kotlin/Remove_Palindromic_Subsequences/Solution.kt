package Remove_Palindromic_Subsequences

// Remove Palindromic Subsequences
// URI: https://leetcode.com/explore/challenge/card/march-leetcoding-challenge-2021/589/week-2-march-8th-march-14th/3665/

class Solution {
    fun removePalindromeSub(s: String): Int {
        if(s.isEmpty()){
            return 0
        }

        return return if(isPalindrome(s)){
            1
        }else{
            2
        }
    }

    fun isPalindrome(s: String): Boolean {
        var start = 0
        var end = s.lastIndex

        while(start < end){
            if(s[start] != s[end]){
                return false
            }
            start++
            end--
        }

        return true
    }
}