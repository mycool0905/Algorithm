package Validate_Stack_Sequences

// Validate Stack Sequences
// URI: https://leetcode.com/explore/challenge/card/february-leetcoding-challenge-2021/587/week-4-february-22nd-february-28th/3653/

import java.util.Stack

class Solution {
    fun validateStackSequences(pushed: IntArray, popped: IntArray): Boolean {
        var pushIdx = 0
        var popIdx = 0
        val stack = Stack<Int>()

        while(pushIdx < pushed.size){
            stack.push(pushed[pushIdx++])


            while(stack.isNotEmpty() && stack.peek() == popped[popIdx]){
                popIdx++
                stack.pop()
            }
        }

        return stack.isEmpty()
    }
}

fun main(args: Array<String>){
    Solution().validateStackSequences(intArrayOf(1,2,3,4,5), intArrayOf(4,5,3,1,2))
}