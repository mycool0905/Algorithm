package Count_Sorted_Vowel_Strings

// Count Sorted Vowel Strings
// URI: https://leetcode.com/explore/challenge/card/january-leetcoding-challenge-2021/581/week-3-january-15th-january-21st/3607/

class Solution {
    fun countVowelStrings(n: Int): Int {
        val arr = Array(6) {
            IntArray(51)
        }

        for (i in 1..5) {
            arr[i][1] = 1
        }

        for (i in 2..n) {
            for (j in 1..5) {
                for (k in j..5) {
                    arr[j][i] += arr[k][i - 1]
                }
            }
        }

        return arr.fold(0) { acc, array ->
            acc + array[n]
        }
    }
}
