package Linked_List_Cycle

// Linked List Cycle
// https://leetcode.com/explore/challenge/card/february-leetcoding-challenge-2021/584/week-1-february-1st-february-7th/3627/

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {
    fun hasCycle(head: ListNode?): Boolean {
        return fasterSolution(head)
    }

    fun setSolution(head: ListNode?): Boolean {
        var cur = head
        val set = mutableSetOf<ListNode>()

        while(cur != null){
            if(set.contains(cur)){
                return true
            }
            set.add(cur)
            cur = cur.next
        }

        return false
    }

    fun fasterSolution(head: ListNode?): Boolean {
        var slower = head ?: return false
        var faster = head.next

        while(slower != faster){
            if(faster?.next == null){
                return false
            }

            slower = slower.next!!
            faster = faster.next?.next
        }

        return true
    }
}