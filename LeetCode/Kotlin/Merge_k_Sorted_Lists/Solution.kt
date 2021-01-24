package Merge_k_Sorted_Lists

// URI: https://leetcode.com/explore/challenge/card/january-leetcoding-challenge-2021/582/week-4-january-22nd-january-28th/3615/

import java.util.PriorityQueue

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class ListNodeElement(val `val`: Int, val listNode: ListNode?) : Comparable<ListNodeElement> {
    override fun compareTo(other: ListNodeElement): Int = this.`val` - other.`val`
}

class Solution {
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        val answer = ListNode(-1)
        var curPtr = answer
        val priorityQueue = PriorityQueue<ListNodeElement>()
        lists.forEach { if (it != null) priorityQueue.offer(ListNodeElement(it.`val`, it)) }

        while (priorityQueue.isNotEmpty()) {
            val curNode = priorityQueue.poll().listNode ?: continue
            curPtr.next = ListNode(curNode.`val`)
            curPtr = curPtr.next!!

            if (curNode.next != null) {
                priorityQueue.offer(ListNodeElement(curNode.next!!.`val`, curNode.next))
            }
        }

        return answer.next
    }
}

fun main(args: Array<String>) {
    val list1 = ListNode(1)
    list1.next = ListNode(4)
    list1.next!!.next = ListNode(5)
    val list2 = ListNode(1)
    list2.next = ListNode(3)
    list2.next!!.next = ListNode(4)
    val list3 = ListNode(2)
    list3.next = ListNode(6)
    val lists = arrayOf<ListNode?>(list1, list2, list3)

    Solution().mergeKLists(lists)
}