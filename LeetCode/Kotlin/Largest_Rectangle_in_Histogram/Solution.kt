package Largest_Rectangle_in_Histogram

// URI: https://leetcode.com/explore/challenge/card/december-leetcoding-challenge/573/week-5-december-29th-december-31st/3587/
// ref: https://noname122.tistory.com/58

import kotlin.math.log2
import kotlin.math.pow

class Solution {
    fun largestRectangleArea(heights: IntArray): Int {
        return dynamicSolution(heights)
    }

    // Time Limitation Exceed
    private fun simpleSolution(heights: IntArray): Int {
        if (heights.isEmpty()) return 0

        var answer = Int.MIN_VALUE
        for (start in heights.indices) {
            for (end in start..heights.lastIndex) {
                var min = Int.MAX_VALUE
                heights.sliceArray(start..end).forEach {
                    min = minOf(min, it)
                }
                answer = maxOf(answer, (end - start + 1) * min)
            }
        }

        return answer
    }

    private fun segmentTreeSolution(heights: IntArray): Int {
        if (heights.isEmpty()) return 0
        val size = 2.0.pow((log2(heights.size.toFloat()) + 1).toInt()).toInt()
        val segmentTree = IntArray(size * 2) {
            Int.MAX_VALUE
        }
        var answer = Int.MIN_VALUE

        fun initSegmentTree(start: Int, end: Int, index: Int): Int {
            if(start==end) {
                segmentTree[index] = heights[start]
                return segmentTree[index]
            }

            val mid = (start+end)/2
            val head = initSegmentTree(start, mid, index*2)
            val tail = initSegmentTree(mid+1,end,index*2+1)
            segmentTree[index] = minOf(head,tail)
            return segmentTree[index]
        }

        initSegmentTree(0, heights.lastIndex, 1)

        fun find(start: Int, end: Int, index: Int, left: Int, right: Int): Int {
            if (start > right || end < left) return Int.MAX_VALUE
            if (start >= left && end <= right) return segmentTree[index]

            val mid = (start + end) / 2
            val head = find(start, mid, index*2, left, right)
            val tail = find(mid+1, end, index*2+1, left,right)
            return minOf(head,tail)
        }

        for(left in heights.indices){
            for(right in left..heights.lastIndex){
                val min = find(0,heights.lastIndex,1, left, right)
                answer = maxOf(answer, (right - left + 1) * min)
            }
        }

        return answer
    }

    private fun dynamicSolution(heights: IntArray): Int {
        if(heights.isEmpty()) return 0
        var answer = 0;
        val leftShortIdx = IntArray(heights.size)
        val rightShortIdx = IntArray(heights.size)
        leftShortIdx[0] = -1;
        rightShortIdx[heights.size-1] = heights.size;
        for(i in 1 until heights.size)
        {
            var j = i - 1;
            while(j >= 0 && heights[j] >= heights[i])
            {
                j = leftShortIdx[j];
            }
            leftShortIdx[i] = j;
        }
        for( i in  heights.size - 2 downTo 0)
        {
            var j = i + 1;
            while(j < heights.size && heights[j] >= heights[i])
            {
                j = rightShortIdx[j];
            }
            rightShortIdx[i] = j;
        }
        for(i in heights.indices)
        {
            answer = maxOf(answer, (rightShortIdx[i] - leftShortIdx[i] - 1) * heights[i]);
        }
        return answer;
    }
}

fun main(args: Array<String>) {
    println(Solution().largestRectangleArea(intArrayOf(2,1,5,6,2,3)))
}