package Decode_Ways

// URI: https://leetcode.com/explore/challenge/card/december-leetcoding-challenge/572/week-4-december-22nd-december-28th/3581/
// ref: https://leetcode.com/problems/decode-ways/discuss/985718/Java-Share-My-Easy-Dp-Solution

class Solution {
    fun numDecodings(s: String): Int {
        return dynamicProgrammingMethod(s)
    }

    fun recursiveMethod(s: String): Int {
        var answer = 0
        val check = mutableSetOf<String>()

        for (num in 1..26) {
            check.add(num.toString())
        }

        fun bruteForce(curIdx: Int) {
            if (curIdx == s.length) {
                answer++
                return
            }

            for (cut in 0..1) {
                if (curIdx + cut > s.lastIndex) continue
                if (check.contains(s.slice(curIdx..curIdx + cut))) {
                    bruteForce(curIdx + cut + 1)
                }
            }
        }

        bruteForce(0)

        return answer
    }

    fun dynamicProgrammingMethod(s: String): Int {
        val dp = IntArray(s.length)

        for (i in s.indices) {
            if (s[i] != '0') {
                dp[i] += if (i - 1 >= 0) dp[i - 1] else 1
            }
            if (i >= 1 && s[i - 1] != '0' && s.slice(i - 1..i).toInt() <= 26) {
                dp[i] += if (i - 2 >= 0) dp[i - 2] else 1
            }
        }

        return dp.last()
    }
}