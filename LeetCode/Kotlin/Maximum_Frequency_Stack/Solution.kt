package Maximum_Frequency_Stack

// Maximum Frequency Stack
// URI: https://leetcode.com/explore/challenge/card/february-leetcoding-challenge-2021/587/week-4-february-22nd-february-28th/3655/
// ref: https://www.geeksforgeeks.org/design-a-stack-which-can-give-maximum-frequency-element/

import java.util.Stack

class FreqStack() {

    private var maxFreq = 0
    private val countMap = mutableMapOf<Int,Int>()
    private val posMap = mutableMapOf<Int, Stack<Int>>()

    fun push(x: Int) {
        val curFreq = countMap.getOrDefault(x, 0) + 1

        countMap[x] = curFreq

        if(curFreq > maxFreq){
            maxFreq = curFreq
        }

        if(posMap[curFreq] == null){
            posMap[curFreq] = Stack()
        }
        posMap[curFreq]!!.push(x)
    }

    fun pop(): Int {
        val top = posMap[maxFreq]!!.pop()

        countMap[top] = countMap[top]!! - 1

        if(posMap[maxFreq]!!.size==0){
            maxFreq--
        }

        return top
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * var obj = FreqStack()
 * obj.push(x)
 * var param_2 = obj.pop()
 */