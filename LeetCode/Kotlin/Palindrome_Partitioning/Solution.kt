package Palindrome_Partitioning

// URI: https://leetcode.com/explore/featured/card/december-leetcoding-challenge/570/week-2-december-8th-december-14th/3565/

class Solution {

    private val answer = mutableListOf<List<String>>()

    private fun isPalindrome(input: String) = input == input.reversed()

    /* This Palindrome check function is faster than upper about 200ms */
    private fun isPalindromeFaster(input: String, startIdx: Int, endIdx: Int): Boolean {
        var backward = startIdx
        var forward = endIdx

        while (forward > backward) {
            if (input[forward--] != input[backward++]) return false
        }
        return true
    }

    private fun search(input: String, curIdx: Int, curList: MutableList<String>) {
        if (curIdx == input.length) {
            answer.add(curList.toList())
            return
        }

        for (i in 0..input.length) {
            if (curIdx + i >= input.length) break
            if (isPalindromeFaster(input, curIdx, curIdx + i)) {
                curList.add(input.slice(curIdx..curIdx + i))
                search(input, curIdx + i + 1, curList)
                curList.removeAt(curList.lastIndex)
            }
        }
    }

    fun partition(s: String): List<List<String>> {
        search(s, 0, mutableListOf())

        return answer
    }
}

fun main(args: Array<String>){
    val solution = Solution()
    solution.partition("aab")
}