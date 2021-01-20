package Valid_Parentheses

// Valid Parentheses
// URI: https://leetcode.com/explore/challenge/card/january-leetcoding-challenge-2021/581/week-3-january-15th-january-21st/3610/

import java.util.Stack

class Solution {
    fun isValid(s: String): Boolean {
        val stack = Stack<Char>()

        for (char in s) {
            when (char) {
                '(', '[', '{' -> stack.push(char)
                ')' -> if (stack.isEmpty() || stack.pop() != '(') return false
                ']' -> if (stack.isEmpty() || stack.pop() != '[') return false
                '}' -> if (stack.isEmpty() || stack.pop() != '{') return false
            }
        }

        return stack.isEmpty()
    }
}
