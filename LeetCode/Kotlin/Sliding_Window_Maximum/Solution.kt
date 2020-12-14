package Sliding_Window_Maximum

import java.util.PriorityQueue

class Solution {
    fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
        val maxHeap = PriorityQueue<Int> { first, second -> second-first }
        val answer = mutableListOf<Int>()
        var headIdx = 0
        var tailIdx = k-1

        maxHeap.addAll(nums.slice(0..tailIdx))
        answer.add(maxHeap.peek())

        while(tailIdx < nums.size-1){
            maxHeap.remove(nums[headIdx++])
            maxHeap.add(nums[++tailIdx])
            answer.add(maxHeap.peek())
        }

        return answer.toIntArray()
    }
}