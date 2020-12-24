package Swap_Nodes_in_Pairs

// URI: https://leetcode.com/explore/challenge/card/december-leetcoding-challenge/572/week-4-december-22nd-december-28th/3579/

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {
    fun swapPairs(head: ListNode?): ListNode? {
        val dummy = ListNode(-1)
        dummy.next = head
        var cur = dummy

        while (cur != null) {
            val first = cur.next ?: break
            val second = first.next ?: break

            first.next = second.next
            second.next = first
            cur.next = second

            cur = first
        }

        return dummy.next
    }
}