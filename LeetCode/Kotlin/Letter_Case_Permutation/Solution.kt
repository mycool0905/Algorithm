package Letter_Case_Permutation

// Letter Case Permutation
// https://leetcode.com/explore/challenge/card/february-leetcoding-challenge-2021/586/week-3-february-15th-february-21st/3642/

class Solution {
    fun letterCasePermutation(S: String): List<String> {
        val answer = mutableListOf<String>()
        val gap = 'a' - 'A'

        fun permutation(curIdx: Int, curStr: String) {
            if (curIdx == S.length) {
                answer.add(curStr)
                return
            }

            when (S[curIdx]) {
                in '0'..'9' -> permutation(curIdx + 1, curStr + S[curIdx])
                else -> {
                    if (S[curIdx] in 'a'..'z') {
                        permutation(curIdx + 1, curStr + S[curIdx])
                        permutation(curIdx + 1, curStr + (S[curIdx] - gap))
                    } else {
                        permutation(curIdx + 1, curStr + S[curIdx])
                        permutation(curIdx + 1, curStr + (S[curIdx] + gap))
                    }
                }
            }
        }

        permutation(0, "")

        return answer
    }
}