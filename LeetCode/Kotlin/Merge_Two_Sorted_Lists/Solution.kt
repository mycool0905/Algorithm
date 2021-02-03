package Merge_Two_Sorted_Lists

// Merge Two Sorted Lists
// URI: https://leetcode.com/explore/challenge/card/january-leetcoding-challenge-2021/579/week-1-january-1st-january-7th/3592/

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {
    fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
        var first = l1
        var second = l2
        val answer = ListNode(-1)
        var cur = answer

        while (first != null && second != null) {
            when {
                first.`val` <= second.`val` -> {
                    cur.next = first
                    first = first.next
                }
                else -> {
                    cur.next = second
                    second = second.next
                }
            }

            cur = cur.next!!
        }

        cur.next = first ?: second

        return answer.next
    }
}
