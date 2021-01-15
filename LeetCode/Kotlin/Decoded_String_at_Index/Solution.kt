package Decoded_String_at_Index

// Decoded String at Index
// URI: https://leetcode.com/explore/challenge/card/december-leetcoding-challenge/571/week-3-december-15th-december-21st/3572/

class Solution {
    fun decodeAtIndex(S: String, K: Int): String {
        var curCount: Long = 0
        var lastStr = ""

        for (idx in S.indices) {
            when (S[idx]) {
                in 'a'..'z' -> {
                    curCount++
                    lastStr = S[idx].toString()
                }
                in '2'..'9' -> curCount *= S[idx].toString().toInt()
            }

            if (curCount == K.toLong()) return if (S[idx] in 'a'..'z') S[idx].toString() else lastStr
            else if (curCount > K) {
                curCount /= S[idx].toString().toInt()
                return if (K % curCount.toInt() == 0) lastStr
                else decodeAtIndex(S.slice(0 until idx), K % curCount.toInt())
            }
        }

        return ""
    }
}

fun main(args: Array<String>) {
    val solution = Solution()
    println(
        solution.decodeAtIndex(
            "czjkk9elaqwiz7s6kgvl4gjixan3ky7jfdg3kyop3husw3fm289thisef8blt7a7zr5v5lhxqpntenvxnmlq7l34ay3jaayikjps",
            768077956
        )
    )
}
