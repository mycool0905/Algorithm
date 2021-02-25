package Score_of_Parentheses

// Score of Parentheses
// URI: https://leetcode.com/explore/challenge/card/february-leetcoding-challenge-2021/587/week-4-february-22nd-february-28th/3651/

import java.util.Stack

class Solution {
    fun scoreOfParentheses(S: String): Int {
        val stack = Stack<Int>()

        stack.push(0)

        for(cur in S){
            if(cur == '('){
                stack.push(0)
            }else {
                val v = stack.pop()
                val w = stack.pop()
                stack.push(w + maxOf(2*v, 1))
            }
        }

        return stack.pop()
    }
}