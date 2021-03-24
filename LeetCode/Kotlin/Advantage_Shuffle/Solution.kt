package Advantage_Shuffle

// Advantage Shuffle
// URI: https://leetcode.com/explore/challenge/card/march-leetcoding-challenge-2021/591/week-4-march-22nd-march-28th/3683/

import java.util.LinkedList
import java.util.Queue

class Solution {
    fun advantageCount(A: IntArray, B: IntArray): IntArray {
        val sortedA = A.sorted()
        val sortedB = B.withIndex().sortedBy { it.value }
        var aIndex = 0
        var bIndex = 0
        val queue: Queue<Int> = LinkedList()
        val answer = IntArray(A.size) { -1 }

        while (aIndex <= sortedA.lastIndex) {
            if (sortedA[aIndex] > sortedB[bIndex].value) {
                answer[sortedB[bIndex].index] = sortedA[aIndex]
                bIndex++
            } else {
                queue.offer(sortedA[aIndex])
            }
            aIndex++
        }

        for (i in answer.indices) {
            if (answer[i] == -1) {
                answer[i] = queue.poll()
            }
        }

        return answer
    }
}