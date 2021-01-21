package Find_the_Most_Competitive_Subsequence

// URI: https://leetcode.com/explore/challenge/card/january-leetcoding-challenge-2021/581/week-3-january-15th-january-21st/3611/

import kotlin.math.log2
import kotlin.math.pow

class Node(val value: Int, val index: Int) : Comparable<Node> {
    override fun compareTo(other: Node): Int =
        if (this.value == other.value) {
            this.index - other.index
        } else {
            this.value - other.value
        }
}

class Solution {
    fun mostCompetitive(nums: IntArray, k: Int): IntArray {
        if (nums.size == k) return nums
        val size = 2.0.pow((log2(nums.size.toFloat()) + 1).toInt()).toInt()
        val segmentTree = Array(size * 2) {
            Node(Int.MAX_VALUE, -1)
        }

        fun initSegmentTree(start: Int, end: Int, index: Int): Node {
            if (start == end) {
                segmentTree[index] = Node(nums[start], start)
                return segmentTree[index]
            }

            val mid = (start + end) / 2
            val head = initSegmentTree(start, mid, index * 2)
            val tail = initSegmentTree(mid + 1, end, index * 2 + 1)
            segmentTree[index] = minOf(head, tail)
            return segmentTree[index]
        }

        initSegmentTree(0, nums.lastIndex, 1)

        fun find(start: Int, end: Int, index: Int, left: Int, right: Int): Node {
            if (start > right || end < left) return Node(Int.MAX_VALUE, Int.MAX_VALUE)
            if (start >= left && end <= right) return segmentTree[index]

            val mid = (start + end) / 2
            val head = find(start, mid, index*2, left, right)
            val tail = find(mid+1, end, index*2+1, left,right)
            return minOf(head,tail)
        }

        var curStart = 0
        var count = k
        val answer = mutableListOf<Int>()

        while (count != 0) {
            val minNode = find(0,nums.lastIndex,1,curStart,nums.size - count)

            answer.add(minNode.value)
            curStart = minNode.index + 1
            count--
        }

        return answer.toIntArray()
    }
}

fun main(args: Array<String>) {
    Solution().mostCompetitive(intArrayOf(3, 5, 2, 6), 2)
}