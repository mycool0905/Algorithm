package Intersection_of_Two_Linked_Lists

// Intersection of Two Linked Lists
// URI: https://leetcode.com/explore/challenge/card/march-leetcoding-challenge-2021/588/week-1-march-1st-march-7th/3660/

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {
    fun getIntersectionNode(headA: ListNode?, headB: ListNode?): ListNode? {
        val visited = mutableSetOf<ListNode?>()

        var curA = headA
        var curB = headB

        while (curA != null || curB != null) {
            if (curA == curB || visited.contains(curA)) {
                return curA
            } else if (visited.contains(curB)) {
                return curB
            }

            if (curA != null) {
                visited.add(curA)
                curA = curA.next
            }
            if (curB != null) {
                visited.add(curB)
                curB = curB.next
            }
        }

        return null
    }
}