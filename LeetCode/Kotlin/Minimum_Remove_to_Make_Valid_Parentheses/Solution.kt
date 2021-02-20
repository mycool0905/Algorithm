package Minimum_Remove_to_Make_Valid_Parentheses

// Minimum Remove to Make Valid Parentheses
// URI: https://leetcode.com/explore/challenge/card/february-leetcoding-challenge-2021/586/week-3-february-15th-february-21st/3645/

import java.util.Stack

class Solution {
    fun minRemoveToMakeValid(s: String): String {
        val stack = Stack<Int>()
        val remove = Stack<Int>()
        var answer = StringBuilder()

        s.forEachIndexed { idx, c ->

            if (c == '(') {
                stack.push(idx)
            } else if(c == ')') {
                if (stack.isEmpty()) {
                    remove.push(idx)
                } else {
                    stack.pop()
                }
            }
        }

        val removeSet = stack.toSet() + remove.toSet()

        s.forEachIndexed { idx, c ->
            if(!removeSet.contains(idx)){
                answer.append(c)
            }
        }

        return answer.toString()
    }
}

fun main(args: Array<String>){
    Solution().minRemoveToMakeValid("lee(t(c)o)de)")
}