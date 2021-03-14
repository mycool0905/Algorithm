package Swapping_Nodes_in_a_Linked_List

// Swapping Nodes in a Linked List
// URI: https://leetcode.com/explore/challenge/card/march-leetcoding-challenge-2021/589/week-2-march-8th-march-14th/3671/

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {
    fun swapNodes(head: ListNode?, k: Int): ListNode? {
        val list = mutableListOf<Int>()
        val answer = ListNode(-1)

        var cur = head
        while (cur != null) {
            list.add(cur.`val`)
            cur = cur.next
        }

        val temp = list[k-1]
        list[k-1] = list[list.size-k]
        list[list.size-k] = temp

        cur = answer
        for(e in list){
            if(cur!=null) {
                cur.next = ListNode(e)
                cur = cur.next
            }
        }

        return answer.next
    }
}